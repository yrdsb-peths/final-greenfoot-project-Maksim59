import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class smallAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class smallAsteroid extends Actor
{
    /**
     * Act - do whatever the smallAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound breakSound = new GreenfootSound("sounds/rockbreak.mp3");
    public int speedAst;
    public smallAsteroid(int speed)
    {
        setRotation(Greenfoot.getRandomNumber(360));
        speedAst = speed;
    }
    public void act()
    {
        GreenfootImage myImage = getImage();
        myImage.scale(25,25);
        
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
            setLocation(getX(), 0);
            removeTouching(Bullet.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseSmallScore();
            breakSound.play();
            world.removeObject(this);
            
        }
    }
    
    
    public void reset()
    {
        setLocation(getX(), 0);
    }
}
