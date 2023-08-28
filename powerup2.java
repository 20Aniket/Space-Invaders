import greenfoot.*;
import java.util.List;

public class powerup2 extends powerups {
    private boolean collided = false;
    private SimpleTimer timer = new SimpleTimer();
    private int transparencyDuration = 5000; // 5 seconds in milliseconds
    private rocket collidedRocket; // Store the rocket object when collision occurs
    
    public powerup2() {
        // Set the size of the powerup2 to 50x50 pixels
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
    
    /**
     * Act - do whatever the powerup2 wants to do.
     */
    public void act() {
        super.act(); // Call parent class's act() method

        if (!collided && getOneIntersectingObject(rocket.class) != null) {
            collidedRocket = (rocket) getOneIntersectingObject(rocket.class);
            collidedRocket.getImage().setTransparency(128); // Set transparency to 50%
            getImage().setTransparency(0);
            timer.mark();
            collided = true;
        }

        if (collided && timer.millisElapsed() > transparencyDuration) {
            collidedRocket.getImage().setTransparency(255); // Set transparency to 100%
            getWorld().removeObject(this); // Delete the powerup2 object
            collided = false;
            collidedRocket = null;
        }
    }
}
