import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Protagonist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protagonist extends Player
{
    /**
     * Act - do whatever the Protagonist wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int atime;
    
    int speed = 6;//default value 5
    boolean multiplekeys = false;
    
    public Protagonist(){
        setImage("mage/wizzard_m_idle_anim_f0.png");
    }
    public void act() 
    {
        animation();
        move();
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
    
    private void move()
    {
        multiplekeys();
        
        if (Greenfoot.isKeyDown("w") && multiplekeys == false)
        {
            setLocation(getX(), getY()-speed);
        } 
        
        if (Greenfoot.isKeyDown("a") && multiplekeys == false)
        {
            setLocation(getX()-speed, getY());
        } 
        
        if (Greenfoot.isKeyDown("s") && multiplekeys == false)
        {
            setLocation(getX(), getY()+speed);
        } 
        
        if (Greenfoot.isKeyDown("d") && multiplekeys == false)
        {
            setLocation(getX()+speed, getY());
        }
        
        multiplekeys = false;
    }  
    
    private void multiplekeys()
    {
        if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+speed/2, getY()-speed/2);
            multiplekeys = true;
        }
        
        if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s"))
        {
            setLocation(getX()+speed/2, getY()+speed/2);
            multiplekeys = true;
        }
        
        if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-speed/2, getY()+speed/2);
            multiplekeys = true;
        }
        
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX()-speed/2, getY()-speed/2);
            multiplekeys = true;
        }
    }
}