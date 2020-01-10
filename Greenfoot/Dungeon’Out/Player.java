import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int atime;
    int speed;
    
    public void act() 
    {
    }
    
        private void animation()
    {
        //Animates the Walking with diffrent pictures
        while (60 % speed !=0)
        {
            speed++;
            
            if (speed > 60)
            {
                speed = 60;
            }
        }
        
        int animationSpeed = speed;
        
        atime= atime +animationSpeed;
        if (atime==240) atime=0;
        if (atime==0) setImage("mage/wizzard_m_idle_anim_f0.png");
        if (atime==60) setImage("mage/wizzard_m_idle_anim_f1.png");
        if (atime==120) setImage("mage/wizzard_m_idle_anim_f2.png");
        if (atime==180) setImage("mage/wizzard_m_idle_anim_f3.png");
    }  
}
