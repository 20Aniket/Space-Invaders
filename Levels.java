import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Levels extends World
{
    public static Counter rocketLifeCount = new Counter();
    public static Counter score = new Counter();
    public static Counter HP = new Counter();
    int Initial_Xposition = 75;
    int gap = 50;
    int Initial_Yposition = 100;
    public static GreenfootSound backgroundMusic = new GreenfootSound("spaceinvaders.mp3");

    public Levels()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        Greenfoot.setWorld(new menu());
        addObject(new rocket(), 300, 750);

        addObject(rocketLifeCount, 70, 20);
        rocketLifeCount.setValue(3);
        addObject(score, 550, 20);
        score.setValue(0);
        HP.setValue(50);
    }
    
    public void started() {
        backgroundMusic.playLoop();
    }
    
    public void act()
    {
        if (getObjects(Enemy1.class).size() == 14) {
            int x = 600;
            int y = 0;
            addObject(new powerup(), x, y-5);
        }
        backgroundMusic.playLoop();
    }
}

