import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 *@author (Maksim Isayenka) 
 * @version (2024-06-12)
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
        prepare();
    }
    
    
    public void act()
    {
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Asteroid asteroid = new Asteroid(-5);
        addObject(asteroid,622,252);
        StartButton startButton = new StartButton();
        addObject(startButton,722,330);
        removeObject(asteroid);
        RulesButton rulesButton = new RulesButton();
        addObject(rulesButton,119,366);
    }
}
