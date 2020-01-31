import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2 gets generated
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Level2 extends World
{
    private double lifes;
    
    public Level2(double lifes)
    {    
        // Create a new world with 480x720 cells with a cell size of 1x1 pixels.
        super(480, 720, 1); 
        setBackground(new GreenfootImage("Bobjectives/Background.png"));
        this.lifes = lifes;
        map();
    }
    
    public void map()
    {
        //create building objects
        addObject (new Walls("top"), 240, 52);
        addObject (new Walls("right"), 472, 360);
        addObject (new Walls("bottom"), 240, 690);
        addObject (new Walls("left"), 7, 360);
        addObject (new Door(), 240, 57);
        
        addObject (new Obstacle(), 130, 445);
        addObject (new Obstacle(), 370, 390);
        addObject (new Obstacle(), 230, 250);
        
        //Enemies
        addObject (new Wogol(), 250, 355);
        addObject (new Wogol(), 150, 180);
        addObject (new Wogol(), 420, 350);
        addObject (new Wogol(), 355, 250);
        
        addObject (new Demon(), 50, 150);
        addObject (new Demon(), 400, 500);
        
        //spawn Protagonist
        addObject (new Protagonist(lifes), 240, 625);
        
        //Userinterface
        showText("Floor: "+Controller.getFloorNr(), 360, 25);
        Controller.spawnHeart(this, lifes);
    }
}
