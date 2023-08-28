import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouLose extends World
{

    /**
     * Constructor for objects of class YouLose.
     * 
     */
    public YouLose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        Levels.backgroundMusic.stop();
    }
    
    public void act()
    {
        switchworld();
    }
    public void switchworld()
    {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Level1());
        }
    }
}