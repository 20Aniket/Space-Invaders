import greenfoot.*;

public class Enemyprojectiles extends Actor {
    int move_value = 6;
    
    /**
     * Perform the actions for the enemy projectiles.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveProjectile();
        checkCollision();
    }
    
    /**
     * Move the projectile downwards.
     */
    private void moveProjectile() {
        setLocation(getX(), getY() + move_value);
    }
    
    /**
     * Check for collision with the player's rocket or if the projectile has reached the bottom of the world.
     */
    private void checkCollision() {
        rocket r = (rocket) getOneIntersectingObject(rocket.class);
        if (r != null && r.getImage().getTransparency() == 255) {
            Levels.rocketLifeCount.add(-1);
            Greenfoot.playSound("invaderkilled.mp3");
            
            if (Levels.rocketLifeCount.getValue() == 0) {
                getWorld().removeObject(r);
                Greenfoot.setWorld(new YouLose());
            }
            
            getWorld().removeObject(this);
        } else if (getY() > 790) {
            getWorld().removeObject(this);
        }
    }
}
