import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_projectile extends Enemyprojectiles
{
    int Enemy_projectile_width= 30;
    int Enemy_projectile_length= 50;
    public Enemy_projectile()
    {
        getImage().scale(Enemy_projectile_width, Enemy_projectile_length);
    }
}
