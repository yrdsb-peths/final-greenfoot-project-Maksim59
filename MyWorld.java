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
    private int lives = 3;
    Lives live1 = new Lives();
    Lives live2 = new Lives();
    Lives live3 = new Lives();
    public static SimpleTimer myTimer = new SimpleTimer();
    public int speed = -2;
    public static int highestScore = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);

        Ship ship = new Ship();
        addObject(ship, 400,300);
        scoreLabel = new Label(score,80);
        addObject(scoreLabel, 100,50);
        addObject(live1,325,35);
        addObject(live2,400,35);
        addObject(live3,475,35);
        Label highestScoreLabel = new Label("HighScore:" + MyWorld.getHighestScore(),30);
        addObject(highestScoreLabel, 700, 35);
        for(int i = 0; i < 4; i++)
        {
            addAsteroid();
        }
    }

    public void addAsteroid()
    {
        addObject(new Asteroid(speed), Greenfoot.getRandomNumber(800), 0);

    }

    public void increaseScore()
    {
        score+=10;
        scoreLabel.setValue(score);
        if(score > highestScore)
        {
            highestScore = score;
        }

    }

    public void decreaseLives()
    {
        lives = lives-1;
        if(lives == 2)
        {
            live1.loseLive();
        }
        if(lives == 1)
        {
            live2.loseLive();
        }
        if(lives == 0)
        {
            live3.loseLive();
        }
        
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

    public void addLiveOne()
    {
        addObject(live1,325,35);
    }

    public void addLiveTwo()
    {
        addObject(live2,400,35);
    }
    
    public void addLiveThree()
    {
        addObject(live3,475,35);
    }
    
    public void increaseSmallScore()
    {
        score+=5;
        scoreLabel.setValue(score);
        if(score > highestScore)
        {
            highestScore = score;
        }
    }
    
    public void startTime()
    {
        myTimer.mark();
    }
    
    public void increaseLevel()
    {
        if(score == 50)
        {
            speed-=1;
        }
        if(score == 100)
        {
            speed-=3;
        }
        else if(score % 150 == 0)
        {
            speed-=1;
        }
        else
        {
            
        }
    }
    
    
    public static int getHighestScore()
    {
        return highestScore;
    }
    

    
}
