import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The rocket class represents the player-controlled rocket in the game.
 */
public class rocket extends Actor {
    SimpleTimer shotTimer = new SimpleTimer();
    int shot_interval = 250;
    int Move_value = 5;
    int rocket_size = 70;
    
    /**
     * Create a new rocket instance and scale its image.
     */
    public rocket() {
        getImage().scale(rocket_size, rocket_size);
    }
    
    /**
     * Perform the actions for the rocket.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveRocket();
        shootProjectile();
        updateLifeCountImage();
        
    }
    
    /**
     * Move the rocket based on player input.
     */
    private void moveRocket() {
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + Move_value, getY());
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - Move_value, getY());
        }
    }
    
    /**
     * Shoot a projectile if enough time has passed since the last shot.
     */
    private void shootProjectile() {
        if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed() > shot_interval) {
            getWorld().addObject(new projectile(), getX(), getY());
            Greenfoot.playSound("shoot.mp3");
            shotTimer.mark();
        }
    }
    
    /**
     * Update the life count image based on the remaining lives.
     */
    private void updateLifeCountImage() {
        Levels.rocketLifeCount.setImage(new GreenfootImage("Life.png"));
        
        if (Levels.rocketLifeCount.getValue() == 2) {
            Levels.rocketLifeCount.setImage("Life2.png");
        }
        
        if (Levels.rocketLifeCount.getValue() == 1) {
            Levels.rocketLifeCount.setImage("Life3.png");
        }
    }
}
