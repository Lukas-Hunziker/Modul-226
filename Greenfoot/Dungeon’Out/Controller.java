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
    public static int FloorNr= 1;
    
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
    
    public static int getFloorNr()
    {
        return FloorNr;
    }
    
    public static void changeFloorNr()
    {
        FloorNr++;
    }
    
    public static void changeFloorNr(int number)
    {
        FloorNr = number;
    }
    
    public static void spawnHeart(World world, double lifes)
    {
        if (lifes > 4.5)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(2), 360, 700);
            world.addObject (new Heart(2), 390, 700);
            world.addObject (new Heart(2), 420, 700);
        }
        
        if (lifes <= 4.5 && lifes > 4.0)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(2), 360, 700);
            world.addObject (new Heart(2), 390, 700);
            world.addObject (new Heart(1), 420, 700);
        }
        
        if (lifes <= 4.0 && lifes > 3.5)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(2), 360, 700);
            world.addObject (new Heart(2), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 3.5 && lifes > 3.0)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(2), 360, 700);
            world.addObject (new Heart(1), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 3.0 && lifes > 2.5)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(2), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 2.5 && lifes > 2.0)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(1), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 2.0 && lifes > 1.5)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(2), 330, 700);
            world.addObject (new Heart(0), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 1.5 && lifes > 1.0)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(1), 330, 700);
            world.addObject (new Heart(0), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 1.0 && lifes > 0.5)
        {
            world.addObject (new Heart(2), 300, 700);
            world.addObject (new Heart(0), 330, 700);
            world.addObject (new Heart(0), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
        
        if (lifes <= 0.5)
        {
            world.addObject (new Heart(1), 300, 700);
            world.addObject (new Heart(0), 330, 700);
            world.addObject (new Heart(0), 360, 700);
            world.addObject (new Heart(0), 390, 700);
            world.addObject (new Heart(0), 420, 700);
        }
    }
}
