import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class necromancer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Necromancer extends Enemies
{
    //animationtimer
    int atime;
    
    int speed = 6;//default value
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
}
