import greenfoot.*;

public class powerups extends Actor {
    private int moveValue = 5;
    
    /**
     * Act - do whatever the powerups wants to do.
     */
    public void act() {
        movePowerUp();
    }
    
    /**
     * Move the power-up downwards.
     */
    private void movePowerUp() {
        setLocation(getX(), getY() + moveValue);
    }
}
