import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor {
    private int X_MOVE = 5;  // Movement speed along the X-axis
    private int Y_MOVE = 20; // Movement speed along the Y-axis
    private int wait = Greenfoot.getRandomNumber(8000);  // Initial waiting time
    private int gap = 8000;  // Time gap between shots
    private SimpleTimer shotTimer = new SimpleTimer();  // Timer for controlling shots
    private int shottime = wait + Greenfoot.getRandomNumber(gap);  // Time until the next shot

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveAndChangeDirection();
        checkCollision();
    }

    // Move the enemy and change direction if reaching the screen edges
    private void moveAndChangeDirection() {
        setLocation(getX() + X_MOVE, getY());
        if ((getX() > getWorld().getWidth() - getImage().getWidth() / 2) || (getX() < getImage().getWidth() / 2)) {
            X_MOVE = -X_MOVE;
            setLocation(getX(), getY() + Y_MOVE);
        }
    }

    // Check if the enemy touches the rocket
    private void checkCollision() {
        if (isTouching(rocket.class)) {
            // Remove the rocket from the world
            getWorld().removeObject(getOneIntersectingObject(rocket.class));
            
            // Stop the game and display the "YouLose" screen
            Greenfoot.setWorld(new YouLose());
        }
    }
}
