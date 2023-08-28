import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends Levels
{
    int Initial_Xposition = 75;
    int gap = 50;
    int Initial_Yposition = 100;
    int Bunkernumber= 3;
    int Bunkerrows= 2;
    int Bunkerwidth= 15;
    public Level2()
    {   
        //Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        for (int y = 0; y < 3; y++) {
            // Add Enemy1 row
            for (int x = 0; x < 10; x++) {
                addObject(new Enemy1(), Initial_Xposition + gap * x, Initial_Yposition + gap * (2 * y));
            }
            
            // Add Enemy2 row
            for (int x = 0; x < 10; x++) {
                addObject(new Enemy2(), Initial_Xposition + gap * x, Initial_Yposition + gap * (2 * y + 1));
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
        if (getObjects(Enemy1.class).size() == 0 )
        {
            Greenfoot.setWorld(new Level3());
        }
    }
}
