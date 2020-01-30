import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * @author Lukas
 * @version 1.0 10.01.2020
 */
public class Protagonist extends Player
{
    //Stats from Protagonist:
    //Movementspeed
    public int speed = 6;//default value 6
    //firerate default 25
    public int firerate = 25;
    //Lifes from protagnist
    public double lifes;
    
    //Variable used for collision detecting
    private int xOld;
    private int yOld;
    
    //refrence of Wand
    private Wand wand;
    
    //reloadTimer
    private int rtime = firerate;
    
    //animationTimer
    private int atime;
    
    //Touching open door for default 20 tics goes to next floor
    private int odtime;
    
    //Timer to see if Protagonist is ready to receive damage
    private int dtime;
    
    //How long Protagonist is invincible after he got hit
    private int invincibleTime = 50;
    
    boolean multiplekeys = false;
    ArrayList<String> pictures = new ArrayList<String>();
    
    public Protagonist(double lifes){
        this.lifes = lifes;
        
        setImage("mage/wizzard_m_idle_anim_f0.png");
        pictures.add("mage/wizzard_m_idle_anim_f0.png");
        pictures.add("mage/wizzard_m_idle_anim_f1.png");
        pictures.add("mage/wizzard_m_idle_anim_f2.png");
        pictures.add("mage/wizzard_m_idle_anim_f3.png");
    }
    public void act() 
    {
        spawnWand();
        atime = Controller.animation(speed,pictures,this,atime);
        shoot();
        move();
    }
    
    private void move()
    {
        xOld = getX();
        yOld = getY();
        wand= (Wand) getWorld().getObjects(Wand.class).get(0);
        
        multiplekeys();
        
        if (Greenfoot.isKeyDown("w") && multiplekeys == false)
        {
            setLocation(getX(), getY()-speed);
            
            wand.move(0, -speed);
        } 
        
        if (Greenfoot.isKeyDown("a") && multiplekeys == false)
        {
            setLocation(getX()-speed, getY());
            
            wand.move(-speed, 0);
        } 
        
        if (Greenfoot.isKeyDown("s") && multiplekeys == false)
        {
            setLocation(getX(), getY()+speed);
            
            wand.move(0, +speed);
        } 
        
        if (Greenfoot.isKeyDown("d") && multiplekeys == false)
        {
            setLocation(getX()+speed, getY());
            
            wand.move(+speed, 0);
        }
        multiplekeys = false;
        collisionDetection();
    }  
    
    private void multiplekeys()
    {
        if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+speed/2, getY()-speed/2);
            wand.move(+speed/2, -speed/2);
            
            multiplekeys = true;
        }
        
        else if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s"))
        {
            setLocation(getX()+speed/2, getY()+speed/2);
            wand.move(+speed/2, +speed/2);
            
            multiplekeys = true;
        }
        
        else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-speed/2, getY()+speed/2);
            wand.move(-speed/2, +speed/2);
            
            multiplekeys = true;
        }
        
        else if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX()-speed/2, getY()-speed/2);
            wand.move(-speed/2, -speed/2);
            
            multiplekeys = true;
        }
    }
    
    private void collisionDetection(){
        //collision detection with building objects
        if(nextLevel() == false && getOneIntersectingObject(Bobjects.class) != null)
        {
            setLocation(xOld, yOld);
            wand.resetMovement();
        }
        
        //collision detection with enemy objects
        //timer to see if Protagonist is ready to receive damage
        dtime++;
        
        //Make refrence of enemie hitting Protagonist if there is one 
        Enemies enemie = (Enemies) getOneIntersectingObject(Enemies.class);
        
        if(enemie != null)
        {
            enemeyHit(enemie);
        }
    } 
    
    //Checks for arrowkeys, when one is pressed shots in this direction. 
    private void shoot()
    {
        if (rtime > 0)
        {
            rtime--;
        }
        
        if(Greenfoot.isKeyDown("up") && rtime == 0)
        {
            getWorld().addObject (new Bullet("up"), getX() + 28, getY()-20);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("right") && rtime == 0)
        {
            getWorld().addObject (new Bullet("right"), getX() + 28, getY()-20);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("down") && rtime == 0)
        {
            getWorld().addObject (new Bullet("down"), getX() + 28, getY()-20);
            
            rtime = firerate;
        }
        
        if(Greenfoot.isKeyDown("left") && rtime == 0)
        {
            getWorld().addObject (new Bullet("left"), getX() + 28, getY()-20);
            
            rtime = firerate;
        }
    } 
    
    //If the Protagonist hasn't a wand yet, than the Wand spawns
    private void spawnWand()
    {
        if((getWorld().getObjects(Wand.class)).size() == 0)
        {
            getWorld().addObject (new Wand(), getX()+15, getY());
            getWorld().setPaintOrder(Protagonist.class,Wand.class);
        }
    }
    
    //Check if the Protagonist is at door if this is open he goes to next Level
    private boolean nextLevel()
    {
        Door door = (Door) getWorld().getObjects(Door.class).get(0);
        
        if (door.doorOpen() == true && 
            getOneIntersectingObject(Door.class) != null)
        { 
            odtime++;
            if (odtime >= 100)
            {
                //go next Level
                Controller.changeFloorNr();
                if (Controller.getFloorNr() %2 == 0)
                {
                    Greenfoot.setWorld(new Level2(lifes));
                }
                else
                {
                    Greenfoot.setWorld(new Level1(lifes));
                }
            }
            return true;
        }
        
        else
        {
            odtime = 0;
            return false;
        }    
    }
    
    private void resetXY()
    {
        xOld = getX();
        yOld = getY();  
    }
    
    private void enemeyHit(Enemies enemie)
    {
        //push protagonist away from enemie
        Actor bobject = getOneIntersectingObject(Bobjects.class);
        
        if(bobject != null)
        {
            enemie.setmoveStop();
        }
        
        if(enemie.getY() > yOld && bobject == null && enemie.getmoveStop() == false)
        {
            resetXY();
            setLocation(xOld, yOld-enemie.getSpeed());
            wand.move(0, -enemie.getSpeed());
        }
        
        if (enemie.getY() < yOld && bobject == null && enemie.getmoveStop() == false)
        {
            resetXY();
            setLocation(xOld, yOld+enemie.getSpeed());
            wand.move(0, enemie.getSpeed());
        }
        
        if (enemie.getX() > xOld && bobject == null && enemie.getmoveStop() == false)
        {
            resetXY();
            setLocation(xOld-enemie.getSpeed(), yOld);
            wand.move(-enemie.getSpeed(), 0);
        }
        
        if (enemie.getX() < xOld && bobject == null && enemie.getmoveStop() == false)
        {
            resetXY();
            setLocation(xOld+enemie.getSpeed(), yOld);
            wand.move(+enemie.getSpeed(), 0);
        }
        
        if (dtime > invincibleTime)
        {
            lifes = lifes - enemie.getDamage();
            dtime = 0;
            heartManagement();
        }
    }
    
    public boolean getcollisionDetection()
    {
        if (getOneIntersectingObject(Bobjects.class) != null && isTouching(Enemies.class))
        {
            return true;
        } 
        else
        {
            return false;
        }
    }
    
    private void heartManagement()
    {
        //import all hearts
        Heart heart4= (Heart) getWorld().getObjects(Heart.class).get(4);
        Heart heart3= (Heart) getWorld().getObjects(Heart.class).get(3);
        Heart heart2= (Heart) getWorld().getObjects(Heart.class).get(2);
        Heart heart1= (Heart) getWorld().getObjects(Heart.class).get(1);
        Heart heart0= (Heart) getWorld().getObjects(Heart.class).get(0);
        if (lifes <= 5 && lifes > 4.5)
        {
            heart4.change(2);
        }
        
        if (lifes <= 4.5 && lifes > 4.0)
        {
            heart4.change(1);
        }
        
        if (lifes <= 4.0 && lifes > 3.5)
        {
            heart4.change(0);
        }
        
        if (lifes <= 3.5 && lifes > 3.0)
        {
            heart4.change(0);
            heart3.change(1);
        }
        
        if (lifes <= 3.0 && lifes > 2.5)
        {
            heart4.change(0);
            heart3.change(0);
        }
        
        if (lifes <= 2.5 && lifes > 2.0)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(1);
        }
        
        if (lifes <= 2.0 && lifes > 1.5)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(0);
        }
        
        if (lifes <= 1.5 && lifes > 1.0)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(0);
            heart1.change(1);
        }
        
        if (lifes <= 1.0 && lifes > 0.5)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(0);
            heart1.change(0);
        }
        
        if (lifes <= 0.5)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(0);
            heart1.change(0);
            heart0.change(1);
        }
        
        if (lifes <= 0)
        {
            heart4.change(0);
            heart3.change(0);
            heart2.change(0);
            heart1.change(0);
            heart0.change(0);
            Greenfoot.setWorld(new EndScreen());
        }   
    }
}