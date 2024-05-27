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
    public Asteroid()
    {
        setRotation(Greenfoot.getRandomNumber(360));
    }
    public void act()
    {
        
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
            getWorld().removeObject(this);

        }
    }

    
    
}
