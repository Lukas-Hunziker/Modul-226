import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Wogol is a type of enemie, who does mele damage.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Wogol extends Enemies
{
    //Stats from wogol
    private int speed = 4;//default value 4
    private int lifes = 2;
    private double hitDamge = 0.25;//default value 0.25
    
    //animationtimer
    int atime;
    
    //target
    Protagonist protagonist;
    
    //collision detection
    private int xOld;
    private int yOld;
    
    //Stop movemenent, when Enemie just hit the Protagonist
    private boolean moveStop = false;
    
    ArrayList<String> pictures = new ArrayList<String>();
    
    public Wogol(){
        setImage("enemies/wogol_run_anim_f0.png");
        pictures.add("enemies/wogol_run_anim_f0.png");
        pictures.add("enemies/wogol_run_anim_f1.png");
        pictures.add("enemies/wogol_run_anim_f2.png");
        pictures.add("enemies/wogol_run_anim_f3.png");
    }
    
    public void act() 
    {
        atime = Controller.animation(speed,pictures,this,atime);
        
        move();
        getsShot();
    }
    
    private void move()
    {
        protagonist= (Protagonist) getWorld().getObjects(Protagonist.class).get(0);
        
        xOld = getX();
        yOld = getY();
        
        moveStop = Enemies.move(protagonist, this,speed,moveStop);
        
        collisionDetection();
    }
    
    private void collisionDetection()
    {
        if (getOneIntersectingObject(Enemies.class) != null || 
            getOneIntersectingObject(Bobjects.class) != null)
        {
            setLocation(xOld, yOld);
        }
    }
    
    private void getsShot()
    {
        greenfoot.World world = getWorld();
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        lifes = Enemies.getsShot(world, bullet, this, lifes);
    }
    
    public double getDamage()
    {
        return hitDamge;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public boolean getmoveStop()
    {
        return moveStop;
    }
    
    public void setmoveStop()
    {
        moveStop = true;
    }
}
