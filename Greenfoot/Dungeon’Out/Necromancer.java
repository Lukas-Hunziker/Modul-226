import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Necromancer is a type of enemie, who does range damage.
 * currently not used.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Necromancer extends Enemies
{
    //animationtimer
    int atime;
    
    int speed = 1;//default value 1
    
    boolean multiplekeys = false;
    ArrayList<String> pictures = new ArrayList<String>();
    
    public Necromancer(){
        setImage("enemies/necromancer_run_anim_f0.png");
        pictures.add("enemies/necromancer_run_anim_f0.png");
        pictures.add("enemies/necromancer_run_anim_f1.png");
        pictures.add("enemies/necromancer_run_anim_f2.png");
        pictures.add("enemies/necromancer_run_anim_f3.png");
    }
    
    public void act() 
    {
        atime = Controller.animation(speed,pictures,this,atime);
    }
    
    public int getSpeed()
    {
        return speed;
    }
}
