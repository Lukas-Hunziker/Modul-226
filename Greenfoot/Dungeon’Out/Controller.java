import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller  
{

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int animation(int speed,  ArrayList<String> pictures, Actor actor, int atime)
    {
        while (60 % speed !=0)
        {
            speed++;
            
            if (speed > 60)
            {
                speed = 60;
            }
        }
        
        atime= atime +speed;

        //Animates the objects with diffrent pictures
        if (atime==240 && pictures.size() == 4) atime=0;
        if (atime==300 && pictures.size() == 5) atime=0;
        if (atime==0) actor.setImage(pictures.get(0));
        if (atime==60) actor.setImage(pictures.get(1));
        if (atime==120) actor.setImage(pictures.get(2));
        if (atime==180) actor.setImage(pictures.get(3));
        if (atime==240 && pictures.size() == 5) actor.setImage(pictures.get(4));
        return atime;
    }
}
