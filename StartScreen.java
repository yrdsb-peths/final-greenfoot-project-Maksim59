import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        Label startLabel = new Label("ASTEROIDS",80);
        addObject(startLabel, 400,50);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    private void prepare()
    {
        Label label = new Label("Press <space> to start the game", 40);
        addObject(label,551,186);
        label.setLocation(275,110);
        Ship ship = new Ship();
        addObject(ship,720,203);
        ship.setLocation(724,81);
        ship.setLocation(739,83);
        Asteroid asteroid = new Asteroid();
        addObject(asteroid,118,216);
        asteroid.setLocation(77,16);
        Label label2 = new Label("WASD to move", 30);
        addObject(label2,53,208);
        label2.setLocation(130,201);
        Label label3 = new Label("and <space> to shoot", 30);
        addObject(label3,47,247);
        label3.setLocation(179,249);
        label3.setLocation(156,250);
        label3.setLocation(160,236);
    }
}
