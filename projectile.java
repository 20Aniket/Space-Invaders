import greenfoot.*;

public class projectile extends Actor {
    private int moveValue = 8;
        public projectile() {
        // Set the size of the projectile to 50x50 pixels
        GreenfootImage image = getImage();
        image.scale(6, 15);
        setImage(image);
    }

        /**
     * Perform the actions for the projectile.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveProjectile();
        checkCollision();
        // ...
    }
    
    /**
     * Move the projectile upwards.
     */
    private void moveProjectile() {
        setLocation(getX(), getY() - moveValue);
    }
    
        /**
         * Check for collision with bombs, enemies, and SolarFlare, updating the game accordingly.
         */
        private void checkCollision() {
        World world = getWorld();
    
        // Check for collision with bombs
        for (Bomb bomb : world.getObjects(Bomb.class)) {
            if (intersects(bomb)) {
                world.removeObject(bomb);
                world.removeObject(this);
                Levels.score.add(5);
                return; // Stop further execution of the method
            }
        }
    
        // Check for collision with enemies
        for (Enemy1 enemy1 : world.getObjects(Enemy1.class)) {
            if (intersects(enemy1)) {
                int enemyX = enemy1.getX();
                int enemyY = enemy1.getY();
                world.removeObject(enemy1);
                Levels.score.add(12);
                Greenfoot.playSound("invaderkilled.mp3");
                world.removeObject(this);
    
                int milestone = 102;
                if (Levels.score.getValue() % milestone == 0 && Levels.rocketLifeCount.getValue() < 3) {
                    world.addObject(new powerup(), enemyX, enemyY);
                }
    
                return; // Stop further execution of the method
            }
        }
    
        // Check for collision with Enemy2
        // Check for collision with Enemy2
        for (Enemy2 enemy2 : world.getObjects(Enemy2.class)) {
            if (intersects(enemy2)) {
                enemy2.lives--;
                if (enemy2.lives <= 0) {
                    world.removeObject(enemy2);
                    Levels.score.add(13);
                    int milestone2 = 10;
                    if (Levels.rocketLifeCount.getValue() < 2 && Levels.score.getValue() % milestone2 == 0 ) {
                        world.addObject(new powerup2(), getX(), getY());
                    }
                } else {
                    // Reduce the size of the enemy image
                    GreenfootImage enemyImage = enemy2.getImage();
                    double scaleFactor = 0.9;
                    int newWidth = (int) (enemyImage.getWidth() * scaleFactor);
                    int newHeight = (int) (enemyImage.getHeight() * scaleFactor);
                    enemyImage.scale(newWidth, newHeight);
        
                    // Set the scaled image
                    enemy2.setImage(enemyImage);
                }
                world.removeObject(this); // Move this line inside the if block
                return; // Stop further execution of the method
            }
        }
    
        // Check for collision with SolarFlare
        for (SolarFlare solarFlare : world.getObjects(SolarFlare.class)) {
            if (intersects(solarFlare)) {
                Levels.HP.add(-1);
                Greenfoot.playSound("mixkit-falling-hit-757.mp3");
    
                if (Levels.HP.getValue() <= 0) {
                    world.removeObject(solarFlare);
                    Levels.score.add(50);
                    Greenfoot.delay(20);
                    Greenfoot.setWorld(new YouWin());
                }
                
                world.removeObject(this);
                return; // Stop further execution of the method
            }
        }
    
        // Check if projectile is out of bounds
        if (getY() < 5) {
            world.removeObject(this);
        }
    }
}
