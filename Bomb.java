import greenfoot.*;

public class Bomb extends Actor {
    private GreenfootImage image;  // Image for the bomb
    private int xPos;              // X position of the bomb
    private int yPos;              // Y position of the bomb
    //Animation images
    private GreenfootImage[] images = {
        new GreenfootImage("bomb2.png"),
        new GreenfootImage("bomb.png"),
    };
    private int currentImage = 0;
    private int animationDelay = 5; // Increase or decrease this value to speed up or slow down the animation
    private int animationCounter = 0;
    // Move the bomb downwards
    public void act() {
        moveDownwards();
        checkCollision();
        checkOutOfBounds();
    }

    // Constructor
    public Bomb() {
        image = new GreenfootImage("bomb.png");  // Replace "bomb.png" with the actual image file name
        image.scale(150, 180);
        setImage(image);    
    }

    // Set the initial position of the bomb
    public void setInitialPosition(int x, int y) {
        xPos = x;
        yPos = y;
        setLocation(xPos, yPos);
    }

    // Move the bomb downwards
    private void moveDownwards() {
        yPos += 5;  // Adjust the speed of the bomb by changing the value (5 in this example)
        setLocation(xPos, yPos);
    }

    // Check if the bomb intersects with the rocket
    private void checkCollision() {
        rocket rocket = (rocket) getOneIntersectingObject(rocket.class);
        if (rocket != null) {
            endGame();
        }
    }

    // Remove the bomb and set the world to YouLose when it reaches the bottom of the screen
    private void checkOutOfBounds() {
        if (yPos >= getWorld().getHeight() - 1) {
            endGame();
        }
    }

    // Stop the game and display the "YouLose" screen
    private void endGame() {
        Greenfoot.stop();
        Greenfoot.setWorld(new YouLose());
    }
    

}
