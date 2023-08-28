import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends World
{

    /**
     * Constructor for objects of class YouWin.
     * 
     */
    public YouWin()
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
