import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Walls extends Bobjects
{
    public Walls(String side){
        if (side == "top")
        setImage("Bobjectives/top_wall.png");
        
        if (side == "right")
        setImage("Bobjectives/right_wall.png");
        
        if (side == "bottom")
        setImage("Bobjectives/bottom_wall.png");
        
        if (side == "left")
        setImage("Bobjectives/left_wall.png");
    }     
}
