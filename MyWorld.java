import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Score scoreboard;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);

        Ship ship = new Ship();
        addObject(ship, 400,300);
        addAsteroid();
        prepare();
    }

    public void addAsteroid()
    {
        for(int i = 0; i < 10; i++)
        {
            addObject(new Asteroid(), Greenfoot.getRandomNumber(800), 0);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Score scoreboard = new Score(0);
        addObject(scoreboard, getWidth()/2, scoreboard.getImage().getHeight()/2);
        
        
    }
    public Score getScoreboard()
    {
        return scoreboard;
    }
}
