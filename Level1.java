import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Levels
{
    int Initial_Xposition= 75;
    int gap= 50;
    int Initial_Yposition= 100;
    int Bunkernumber= 3;
    int Bunkerrows= 4;
    int Bunkerwidth= 17;
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 10; x++) {
                addObject(new Enemy1(), Initial_Xposition + gap * x, Initial_Yposition + gap * y);
            }
        }
        
        for (int c=0; c<Bunkernumber; c++)
        {
            for(int b=0; b<Bunkerrows; b++)
            {
                for (int a=0; a<Bunkerwidth; a++)
                {
                    //addObject(new Bunker(), 110 + 5*x, 590 + 5*b);
                    addObject(new Bunker(), 47 + 5*a + c*200, 590 + 5*b);
                }
            }
        }
    }
    public void act()
    {
        if (getObjects(Enemy1.class).size() == 0)
        {
            Greenfoot.setWorld(new Level2());
        }
    }
}
