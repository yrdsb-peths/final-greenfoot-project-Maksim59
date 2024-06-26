import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RulesWorld here.
 * 
 *@author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class RulesWorld extends World
{

    /**
     * Constructor for objects of class RulesWorld.
     * 
     */
    public RulesWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GoBack goBack = new GoBack();
        addObject(goBack,141,526);
    }
}
