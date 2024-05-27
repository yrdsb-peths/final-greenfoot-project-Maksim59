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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        Ship ship = new Ship();
        addObject(ship, 50, 50);
        addAsteroid();
    }
    
    public void addAsteroid()
    {
        for(int i = 0; i < 3; i++)
        {
            addObject(new Asteroid(), Greenfoot.getRandomNumber(1000), 0);
        }
    }
    

}
