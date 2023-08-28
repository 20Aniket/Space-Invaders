import greenfoot.*;

public class powerup extends powerups {
    public powerup() {
        // Set the size of the powerup to 50x50 pixels
        GreenfootImage image = getImage();
        image.scale(50, 55);
        setImage(image);
    }
    
    /**
     * Act - do whatever the powerup wants to do.
     */
    public void act() {
        super.act(); // Call parent class's act() method
        
        // Additional code specific to powerup class
        checkCollision();
        // ...
    }
    
    /**
     * Check for collision with the rocket and update the game accordingly.
     */
    private void checkCollision() {
        if (getOneIntersectingObject(rocket.class) != null) {
            // Increase life by 1
            Levels.rocketLifeCount.add(1);

            // Remove the power-up
            getWorld().removeObject(this);
        }
    }
    
    // Additional methods specific to powerup class
    
    // ...
}
