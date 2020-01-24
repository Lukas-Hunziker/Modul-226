import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * @author Lukas
 * @version 1.0 10.01.2020
 */
public class Protagonist extends Player
{
    /**
     * Act - do whatever the Protagonist wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //animationtimer
    int atime;
    
    int firerate = 25;
    //reloadtimer
    int rtime = firerate;
    
    int speed = 6;//default value
    boolean multiplekeys = false;
    ArrayList<String> pictures = new ArrayList<String>();
    
    public Protagonist(){
        setImage("mage/wizzard_m_idle_anim_f0.png");
        pictures.add("mage/wizzard_m_idle_anim_f0.png");
        pictures.add("mage/wizzard_m_idle_anim_f1.png");
        pictures.add("mage/wizzard_m_idle_anim_f2.png");
        pictures.add("mage/wizzard_m_idle_anim_f3.png");
    }
    public void act() 
    {
        atime = Controller.animation(speed,pictures,this,atime);
        move();
        shoot();
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
    
    private void shoot()
    {
        if (rtime > 0)
        {
            rtime--;
        }
        if(Greenfoot.isKeyDown("up") && rtime == 0)
        {
            getWorld().addObject (new Bullet("up"), getX() + 25, getY()-33);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("right") && rtime == 0)
        {
            getWorld().addObject (new Bullet("right"), getX() + 25, getY()-33);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("down") && rtime == 0)
        {
            getWorld().addObject (new Bullet("down"), getX() + 25, getY()-33);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("left") && rtime == 0)
        {
            getWorld().addObject (new Bullet("left"), getX() + 25, getY()-33);
            
            rtime = firerate;
        }
    }    
}