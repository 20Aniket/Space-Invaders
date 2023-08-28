import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2_projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2_projectile extends Enemyprojectiles
{
    /**
     * Act - do whatever the Enemy2_projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int Enemy_projectile_width= 30;
    int Enemy_projectile_length= 50;
    public Enemy2_projectile()
    {
        getImage().scale(Enemy_projectile_width, Enemy_projectile_length);
    }
}