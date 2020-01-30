import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends UserInterface
{
    public Heart()
    {
        setImage("heart/heart_full.png");
    }
    
    public Heart(int status)
    {
        if(status == 2)
        {
            setImage("heart/heart_full.png");
        }
        if(status == 1)
        {
            setImage("heart/heart_half.png");
        }
        if(status == 0)
        {
            setImage("heart/heart_empty.png");
        }
    }
    
    public void change(int status)
    {
        if(status == 2)
        {
            setImage("heart/heart_full.png");
        }
        if(status == 1)
        {
            setImage("heart/heart_half.png");
        }
        if(status == 0)
        {
            setImage("heart/heart_empty.png");
        }
    }
}
