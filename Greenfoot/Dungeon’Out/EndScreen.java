import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Show the Game Over screenn when the player died
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class EndScreen extends World
{
    public EndScreen()
    {    
        // Create a new world with 480x720 cells with a cell size of 1x1 pixels.
        super(480, 720, 1); 
        setBackground(new GreenfootImage("Bobjectives/gameover.png"));
    }
}
