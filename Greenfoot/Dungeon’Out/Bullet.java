

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bullet here.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Bullet extends Player
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 8;//default value 8
    private int atime;
    
    //Damage that bullet does to enemies
    public int bulletDamage = 1;
    
    private String direction; 
    ArrayList<String> pictures = new ArrayList<String>();
    public Bullet(String direction){
       (this).direction = direction;
       setImage("fireball/FB001.png");
       pictures.add("fireball/FB001.png");
       pictures.add("fireball/FB002.png");
       pictures.add("fireball/FB003.png");
       pictures.add("fireball/FB004.png");
       pictures.add("fireball/FB005.png");
       setRotation();
    }    
    public void act() 
    {
       atime = Controller.animation(speed,pictures,this,atime);
       
       move(speed);
       
       if(getOneIntersectingObject(Bobjects.class) != null)
       {
           getWorld().removeObject(this);
       }
    }
    
    private void setRotation()
    {
        if (direction == "up")
        {
            setRotation(270);
        }
        
        if (direction == "right")
        {
            setRotation(0);
        }
        
        if (direction == "down")
        {
            setRotation(90);
        }
        
        if (direction == "left")
        {
            setRotation(180);
        }
    }
    
    public int bulletDamage()
    {
        return bulletDamage;
    }
}
