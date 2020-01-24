

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Player
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 10;//default value 10
    
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
    }    
    public void act() 
    {
       atime = Controller.animation(speed,pictures,this,atime);
       move();
       if(isAtEdge())
       {
           getWorld().removeObject(this);
       }
    }
    
    private void move()
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
        
        move(speed);
    }    
}
