import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy2 extends Enemy {
    private GreenfootImage imageA = new GreenfootImage("Enemy2A.png");
    private GreenfootImage imageB = new GreenfootImage("Enemy2B.png");

    //Defining variables
    int wait = 1000;
    int gap = 9000;
    SimpleTimer shotTimer = new SimpleTimer();
    int shottime = Greenfoot.getRandomNumber(gap);
    int begin = 1;
    int lives= 3;

    public Enemy2() {
        getImage().scale(40, 40);
    }

    /**
     * The act method is called by the Greenfoot framework to perform the actor's action.
     * It updates the position of the enemy, checks for collisions with walls, and fires projectiles.
     */
    public void act() {
        super.act(); // call the parent act method
        checkWallCollision();
        shootProjectile();
    }
    
    public void resetTimer()
    {
        if(begin == 1)
        {
            shotTimer.mark();
            begin = 0;
        }
    }

    public void randomShooting()
    {
        if(shotTimer.millisElapsed() > wait + shottime)
        {
            getWorld().addObject(new Enemy2_projectile(), getX(), getY());
            //resets the shotTimer to zero milliseconds
            shotTimer.mark();
            shottime = Greenfoot.getRandomNumber(gap);
            Greenfoot.playSound("mixkit-game-whip-shot-1512.mp3");
        }
    }
    
    /**
     * Checks if the enemy has collided with the walls and updates its image accordingly.
     */
    private void checkWallCollision() {
        int x = getX();
        if (x >= getWorld().getWidth() - getImage().getWidth() / 2) {
            // Enemy hits the right wall
            setImage(imageB);
            getImage().scale(40, 40);
        } else if (x <= getImage().getWidth() / 2) {
            // Enemy hits the left wall
            setImage(imageA);
            getImage().scale(40, 40);
        }
    }

    /**
     * Fires a projectile from the enemy's position.
     */
    private void shootProjectile() {
        if (shotTimer.millisElapsed() > (wait + shottime)) {
            getWorld().addObject(new Enemy2_projectile(), getX(), getY());
            shotTimer.mark();
            shottime = Greenfoot.getRandomNumber(gap);
            Greenfoot.playSound("mixkit-game-whip-shot-1512.mp3");
        }
    }
}
