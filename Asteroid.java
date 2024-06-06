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
    int size;
    boolean isSmall = false;
    GreenfootSound breakSound = new GreenfootSound("sounds/rockbreak.mp3");
    public Asteroid()
    {
        setRotation(Greenfoot.getRandomNumber(360));
    }
    public void act()
    {
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
        
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
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            splitOff();
            world.addAsteroid();
            breakSound.play();
            world.removeObject(this);
            

        }
    }
    public void splitOff()
    {
        smallAsteroid smallAstOne = new smallAsteroid();
        smallAsteroid smallAstTwo = new smallAsteroid();
        getWorld().addObject(smallAstOne, getX(), getY());
        getWorld().addObject(smallAstTwo, getX(), getY());
    }

    
    
}
