import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class magic_staff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wand extends Player
{
    //Variable used for collision detecting
    private int xOld;
    private int yOld;
    
    public Wand()
    {
        setImage("mage/wand.png");
    }
    
    public void move(int speedX, int speedY){
        xOld = getX();
        yOld = getY();
        setLocation(getX() +speedX,getY() +speedY);
    }
    
    public void resetMovement(){
        setLocation(xOld, yOld);
    } 
}
