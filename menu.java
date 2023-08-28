import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menu extends World
{
    public menu() {    
        super(600, 800, 1); 
    }
    
    public void act() {
        changeWorld();
    }
    
    private void changeWorld() {
        if (Greenfoot.isKeyDown("P")) {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Level1());
        }
        if (Greenfoot.isKeyDown("?")) {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Howtoplay());
        }
    }

}
