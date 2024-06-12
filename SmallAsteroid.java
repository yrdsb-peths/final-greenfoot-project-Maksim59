import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class smallAsteroid here.
 * 
 * Acts as a projectile that does damage to the ship. This one is smaller
 * and only occurs when it splits off a bigger asteroid
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 * */
public class SmallAsteroid extends Actor
{
    /**
     * Act - do whatever the smallAsteroid wants to do. This method is called whenever
     * Act - do whatever the SmallAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound breakSound = new GreenfootSound("sounds/rockbreak.mp3");
    public int speedAst;
    public SmallAsteroid(int speed)
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
    
    /*makes it so that the asteroid keeps moving and when reaching the end
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
    
    //checks if the small asteroid colides with the bullet
    public void colide()
    {
        if(isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            breakSound.play();
            world.increaseLevel();
            world.removeObject(this);

        }
    }
    
}