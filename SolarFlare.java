import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SolarFlare extends Actor {
    private int X_MOVE = 3;
    // Animation images
    private GreenfootImage[] images = {
        new GreenfootImage("SolarFlareA.png"),
        new GreenfootImage("SolarFlareB.png"),
        new GreenfootImage("SolarFlareC.png"),
        new GreenfootImage("SolarFlareD.png")
    };
    private int currentImage = 0;
    private int animationDelay = 8; // Increase or decrease this value to speed up or slow down the animation
    private int animationCounter = 0;
    
    public SolarFlare() {
        getImage().scale(120, 120);
    }
    
    /**
     * Perform the actions for the solar flare.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        animateSolarFlare();
        moveSolarFlare();
    }
    
    /**
     * Animates the solar flare by cycling through the images with a delay.
     */
    private void animateSolarFlare() {
        animationCounter++;
        if (animationCounter % animationDelay == 0) {
            setImage(images[currentImage]);
            getImage().scale(120, 120);
            currentImage = (currentImage + 1) % images.length;
        }
    }
    
    /**
     * Moves the solar flare horizontally and reverses its direction when reaching the edge of the world.
     */
    private void moveSolarFlare() {
        setLocation(getX() + X_MOVE, getY());
        if (isAtEdge()) {
            X_MOVE = -X_MOVE; // Reverse the direction when reaching the edge
        }
    }
}
