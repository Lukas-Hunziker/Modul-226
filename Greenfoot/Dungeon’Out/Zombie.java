import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemies
{
    //animationtimer
    int atime;
    
    int speed = 6;//default value
    boolean multiplekeys = false;
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
    }    
}
