import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 1 gets generated
 * 
 * @author (Lukas Hunziker) 
 * @version (30.01.2020)
 */
public class Level1 extends World
{
    private double lifes = 5.0;
    
    public Level1()
    {    
        // Create a new world with 480x720 cells with a cell size of 1x1 pixels.
        super(480, 720, 1); 
        setBackground(new GreenfootImage("Bobjectives/Background.png"));
        Controller.changeFloorNr(1);
        map();
    }
    
    public Level1(double lifes)
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
        
        //Enemies
        addObject (new Zombie(), 130, 210);
        addObject (new Zombie(), 350, 210);
        
        addObject (new Wogol(), 240, 230);
        addObject (new Wogol(), 270, 260);
        
        addObject (new Demon(), 425, 410);
        addObject (new Demon(), 110, 350);
        
        //spawn Protagonist
        addObject (new Protagonist(lifes), 240, 625);
        
        //Userinterface
        showText("Floor: "+Controller.getFloorNr(), 360, 25);
        Controller.spawnHeart(this, lifes);
    }
}
