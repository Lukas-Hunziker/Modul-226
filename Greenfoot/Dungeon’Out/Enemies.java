
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Actor
{
    public  static int getsShot(World world, Bullet target,Actor enemie, int lifes)
    {
        if (target != null)
        {
            lifes = lifes - target.bulletDamage();
            
            world.removeObject(target);
        }
        
        if (lifes <= 0)
        {   
            //If all Enemies dead open door
            
            world.removeObject(enemie);
            if ((world.getObjects(Enemies.class)).size() <= 0)
            {
                Door door = (Door) world.getObjects(Door.class).get(0);
                door.doorChange("open");
            }
        }
        return lifes;
    } 
    
    public static boolean move(Protagonist protagonist,Actor enemie, int speed,boolean moveStop)
    {
        //Boolean if both X and Y values need to get changed
        boolean ChangeBothXY = false;
        
        if(protagonist.getcollisionDetection() == true)
        {
            moveStop = true;
        }
        else
        {
            moveStop = false;
        }    
            
        //If both cordinates needs to get changed
        if(protagonist.getX() > enemie.getX() && protagonist.getY() > enemie.getY() 
           && moveStop == false)
        {
            enemie.setLocation(enemie.getX()+speed/2, enemie.getY()+speed/2);
            
            ChangeBothXY = true;
        } 
        
        if(protagonist.getX() < enemie.getX() && protagonist.getY() < enemie.getY()
           && moveStop == false)
        {
            enemie.setLocation(enemie.getX()-speed/2, enemie.getY() -speed/2);
            
            ChangeBothXY = true;
        }
        
        if(protagonist.getX() < enemie.getX() && protagonist.getY() > enemie.getY()
           && moveStop == false)
        {
            enemie.setLocation(enemie.getX()-speed/2, enemie.getY()+speed/2);
            
            ChangeBothXY = true;
        }
        
        if(protagonist.getX() > enemie.getX() && protagonist.getY() < enemie.getY()
           && moveStop == false)
        {
            enemie.setLocation(enemie.getX()+speed/2, enemie.getY()-speed/2);
            
            ChangeBothXY = true;
        }
        
        //If only one coordinate needs to get changed.
        if(protagonist.getX() > enemie.getX() && ChangeBothXY == false && moveStop == false)
        {
            enemie.setLocation(enemie.getX()+speed, enemie.getY());
        }
        
        if (protagonist.getX() < enemie.getX() && ChangeBothXY == false && moveStop == false)
        {
            enemie.setLocation(enemie.getX()-speed, enemie.getY());
        }
        
        if(protagonist.getY() > enemie.getY() && ChangeBothXY == false && moveStop == false)
        {
            enemie.setLocation(enemie.getX(), enemie.getY()+speed);   
        }
        if(protagonist.getY() < enemie.getY() && ChangeBothXY == false && moveStop == false)
        {
            enemie.setLocation(enemie.getX(), enemie.getY()-speed);   
        }
        
        return moveStop;
    }
    
    //gets overwritten from specific Objects
    public double getDamage()
    {
        return 0;
    }
    
    public int getSpeed()
    {
        return 0;
    }
    
    public boolean getmoveStop()
    {
        return true;
    }
    
    public void setmoveStop()
    {  
    }
}
