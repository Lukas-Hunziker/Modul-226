import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Door which opens, when all Enemies are dead to go to next Level.
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Door extends Bobjects
{
    //Grennfoot Images for closed and open door
    private GreenfootImage openDoor = new GreenfootImage("Bobjectives/doors_leaf_open.png");
    private GreenfootImage closeDoor = new GreenfootImage("Bobjectives/doors_leaf_closed.png");
    
    public Door(){
        setImage(closeDoor);
    } 
    
    //function to open or close door
    public void doorChange(String status)
    {
        if (status == "closed")
            setImage(closeDoor);
        
        if (status == "open")
            setImage(openDoor);
    }
    
    //function too check if door is open
    public boolean doorOpen()
    {
        if (getImage() == openDoor)
        return true;
        
        else 
        return false;
    }
}
