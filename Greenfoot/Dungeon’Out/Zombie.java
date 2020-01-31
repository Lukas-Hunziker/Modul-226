import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Zombie is a type of enemie, who does mele damage.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Zombie extends Enemies
{
    //Stats from zombie
    private int speed = 2;//default value 2
    private int lifes = 5;//default value 5
    private double hitDamge = 0.5;//default value 0.5
    
    //animationtimer
    int atime;
    
    //target
    Protagonist protagonist;
    
    //Boolean if both X and Y values need to get changed
    boolean ChangeBothXY = false;
    
    //collision detection
    private int xOld;
    private int yOld;
    
    //Stop movemenent, when Enemie just hit the Protagonist
    private boolean moveStop = false;

    ArrayList<String> pictures = new ArrayList<String>();
    
    public Zombie(){
        setImage("enemies/big_zombie_run_anim_f0.png");
        pictures.add("enemies/big_zombie_run_anim_f0.png");
        pictures.add("enemies/big_zombie_run_anim_f1.png");
        pictures.add("enemies/big_zombie_run_anim_f2.png");
        pictures.add("enemies/big_zombie_run_anim_f3.png");
    }    
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        
        moveStop = Enemies.move(protagonist,this,speed,moveStop);
        
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
        //creates a refrence to the bullet that hits the Zombie
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
