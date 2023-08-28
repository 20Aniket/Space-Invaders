import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    //Animation images
    private GreenfootImage[] images = {
        new GreenfootImage("Enemy1A.png"),
        new GreenfootImage("Enemy1B.png"),
        new GreenfootImage("Enemy1C.png"),
        new GreenfootImage("Enemy1D.png"),
        new GreenfootImage("Enemy1E.png"),
        new GreenfootImage("Enemy1F.png"),
        new GreenfootImage("Enemy1G.png"),
        new GreenfootImage("Enemy1H.png")
    };
    private int currentImage = 0;
    private int animationDelay = 5; // Increase or decrease this value to speed up or slow down the animation
    private int animationCounter = 0;
    
    //Defining variables
    int wait = 1000;
    int gap = 9000;
    SimpleTimer shotTimer = new SimpleTimer();
    int shottime = Greenfoot.getRandomNumber(gap);
    int begin = 1;
    
    public Enemy1()
    {
        getImage().scale(40,40);
        /*YourWorld world = (YourWorld) getWorld();
        int enemy1Count = world.countInstances(Enemy1.class);*/
    }
    
    public void act()
    {
        super.act(); // call the parent act method
        animationTimer();
        // if (shotTimer.millisElapsed() > wait + shottime)
        // {
            // getWorld().addObject(new Enemy_projectile(), getX(), getY());
            // shotTimer.mark();
            // shottime = Greenfoot.getRandomNumber(gap);
            // Greenfoot.playSound("mixkit-game-whip-shot-1512.mp3");
        // }
        resetTimer();
        randomShooting();
    }
    
    public void resetTimer()
    {
        if(begin == 1)
        {
            shotTimer.mark();
            begin = 0;
        }
    }

    public void randomShooting()
    {
        if(shotTimer.millisElapsed() > wait + shottime)
        {
            getWorld().addObject(new Enemy_projectile(), getX(), getY());
            //resets the shotTimer to zero milliseconds
            shotTimer.mark();
            shottime = Greenfoot.getRandomNumber(gap);
            Greenfoot.playSound("mixkit-game-whip-shot-1512.mp3");
        }
    }
    
    private void animationTimer() {
        animationCounter++;
        if (animationCounter % animationDelay == 0) {
            setImage(images[currentImage]);
            getImage().scale(40, 40);
            currentImage = (currentImage + 1) % images.length;
        }
    }
}
