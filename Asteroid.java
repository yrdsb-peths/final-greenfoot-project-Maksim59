import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * Asteroid class which acts as the projectile the ship has to dodge/shoot
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class Asteroid extends Actor
{
    
    int size;
    boolean isSmall = false;
    public int speedAst;
    GreenfootSound breakSound = new GreenfootSound("sounds/rockbreak.mp3");
    
    //Asteroid constructor
    public Asteroid(int speed)
    {
        speedAst = speed;
        setRotation(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
        
        move(speedAst);
        infiniteMove();
        colide();

    }
    
    /* /*makes it so that the asteroid keeps moving and when reaching the end
    of the screen it appears at the opposite end*/
    
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
    
    // checks if the asteroid colides with a bullet
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
            world.increaseLevel();
            

        }
    }
    /* makes it so when the asteroid colides two smaller asteroids spawn in 
    in opposite directions
    */
    public void splitOff()
    {
        SmallAsteroid smallAstOne = new SmallAsteroid(-3);
        SmallAsteroid smallAstTwo = new SmallAsteroid(-3);
        getWorld().addObject(smallAstOne, getX(), getY());
        getWorld().addObject(smallAstTwo, getX(), getY());
    }

    
    
}
