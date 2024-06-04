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
    private int score = 0;
    private Label scoreLabel;
    private Label livesLabel;
    private int lives = 4;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);

        Ship ship = new Ship();
        addObject(ship, 400,300);
        scoreLabel = new Label(score,80);
        addObject(scoreLabel, 50,50);
        livesLabel = new Label(lives, 80);
        addObject(livesLabel, 50,100);
        
        for(int i = 0; i < 6; i++)
        {
            addAsteroid();
        }
        decreaseLives();
    }

    public void addAsteroid()
    {
        addObject(new Asteroid(50, false), Greenfoot.getRandomNumber(800), 0);

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    public void increaseScore()
    {
        score+=100;
        scoreLabel.setValue(score);

    }
    public void decreaseLives()
    {
        lives = lives-1;
        livesLabel.setValue(lives);
    }
    
    public void gameOver()
    {

        GameOver gameOverWorld = new GameOver();
        Greenfoot.setWorld(gameOverWorld);

    }
    
    public int getLives()
    {
        return lives;
    }
    
    
}
