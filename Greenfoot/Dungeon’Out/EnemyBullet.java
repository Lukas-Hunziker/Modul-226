import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet from ranged enemies
 * currently not used.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class EnemyBullet extends Enemies
{
    private double hitDamge = 0.5;//default value 0.5
    
    public void act() 
    {
        
    } 
    
    public double getDamage()
    {
        return hitDamge;
    }
}
