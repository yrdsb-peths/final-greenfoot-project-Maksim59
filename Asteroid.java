import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score = 0;
    int size;
    boolean isSmall = false;
    public Asteroid(int size, boolean isSmall)
    {
        setRotation(Greenfoot.getRandomNumber(360));
        this.size = size;
        isSmall = isSmall;
    }
    public void act()
    {
        GreenfootImage myImage = getImage();
        myImage.scale(size,size);
        
        move(-5);
        infiniteMove();
        colide();

    }
    
    public void infiniteMove()
    {
        if(getX() < 0)
        {
            setLocation(getWorld().getWidth(), getY());
        }
        if(getX() > getWorld().getWidth())
        {
            setLocation(0, getY());
        }
        if(getY() < 0)
        {
            setLocation(getX(), getWorld().getHeight());
        }
        if(getY() > getWorld().getHeight())
        {
            setLocation(getX(), 0);
        }
    }
    
    public void colide()
    {
        if(isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
            score++;
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            if(isSmall == false)
            {
                splitOff();
            }
            else
            {
                world.addAsteroid();
            }
            world.removeObject(this);

        }
    }
    public void splitOff()
    {
        Asteroid smallAstOne = new Asteroid(25, true);
        Asteroid smallAstTwo = new Asteroid(25, true);
        getWorld().addObject(smallAstOne, getX(), getY());
        getWorld().addObject(smallAstTwo, getX(), getY());
    }

    
    
}
