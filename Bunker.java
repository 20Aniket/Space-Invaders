import greenfoot.*;

public class Bunker extends Actor {
    
    public Bunker() {
        GreenfootImage image = getImage();
        
        // Scale the image to the desired size
        image.scale(10, 10);
        
        setImage(image);
    }
    
    public void act() {
        checkCollision();
    }
    
    private void checkCollision() {
        if (isTouching(Enemyprojectiles.class)) {
            // Remove the enemy projectile
            Enemyprojectiles projectile = (Enemyprojectiles) getOneIntersectingObject(Enemyprojectiles.class);
            getWorld().removeObject(projectile);
            
            // Destroy the entire bunker
            destroyBunker();
        }
    }
    
    private void destroyBunker() {
        getWorld().removeObject(this);
    }
}
