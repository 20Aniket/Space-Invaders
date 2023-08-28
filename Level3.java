import greenfoot.*;

public class Level3 extends Levels
{
    private int bombSpeed = 100;       // Adjust the speed of the bombs
    private int spawnDelay = 50;     // Delay between bomb spawns (adjust as needed)
    private int spawnCounter = 0;    // Counter for bomb spawns
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        SolarFlare solarFlare = new SolarFlare();
        addObject(solarFlare, 300, 200);
        addObject(HP, solarFlare.getX(), solarFlare.getY() - 40);
    }

    public void act() {
        super.act();  // Call the act() method of the superclass (if needed)

        spawnCounter++;

        // Spawn a new bomb at regular intervals
        if (spawnCounter >= spawnDelay) {
            spawnBomb();
            spawnCounter = 0;  // Reset the spawn counter
        }
        SolarFlare solarFlare = getObjects(SolarFlare.class).get(0);
        
        // Update the position of the counter
        HP.setLocation(solarFlare.getX(), solarFlare.getY() - 40);

    }

    public void spawnBomb() {
        Bomb bomb = new Bomb();
        int randomX = Greenfoot.getRandomNumber(getWidth());  // Random x-coordinate
        int y = 0;  // Starting y-coordinate at the top of the screen
        bomb.setInitialPosition(randomX, y);
        addObject(bomb, randomX, y);
    }
}
