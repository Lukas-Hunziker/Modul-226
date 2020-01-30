import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Enemies
{
    private double hitDamge = 0.5;//default value 0.5
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    public double getDamage()
    {
        return hitDamge;
    }
}
