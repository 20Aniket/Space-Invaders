import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Howtoplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Howtoplay extends World
{

    public Howtoplay() {    
        super(600, 800, 1); 
    }
    
    public void act() {
        changeWorld();
        Levels.backgroundMusic.playLoop();
    }
    
    private void changeWorld() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new menu());
        }
    }
}
