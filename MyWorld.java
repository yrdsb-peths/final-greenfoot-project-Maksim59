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
    private int score;
    private Label scoreLabel;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);

        Ship ship = new Ship();
        addObject(ship, 400,300);
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        addAsteroid();
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
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);

    }
}
