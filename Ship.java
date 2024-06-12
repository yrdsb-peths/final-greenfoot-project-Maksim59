import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * Class of the ship and has methods which allows you to move around and shoot.
 * 
 *@author (Maksim Isayenka) 
 * @version (2024-06-12) */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage myImage = getImage();
    GreenfootImage moveImage = new GreenfootImage("images/shipMoving.png");
    GreenfootSound shootSound = new GreenfootSound("sounds/shot (2).mp3");
    GreenfootSound regenSound = new GreenfootSound("sounds/regen.mp3");
    MyWorld world = (MyWorld) getWorld();
    boolean isDead = false;
    public Ship()
    {
        myImage.scale(50,50);
        moveImage.scale(50,50);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        // key controls for the ship
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(3);
            setImage(moveImage);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(3);
            setImage(moveImage);
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(3);
            setImage(moveImage);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(3);
            setImage(moveImage);
        }
        else if("space".equals(Greenfoot.getKey()))
        {
            shoot();
        }
        else 
        {
            setImage(myImage);
        }
        colide();
        //adds the game over screen
        if(world.getLives() == 0)
        {
            world.gameOver();
        }
        
    }
    
    //shoot method for the ship which shoots a bullet
    public void shoot()
    {
        if(isDead == false)
        {
            Bullet bullet = new Bullet(10);
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet,getX(), getY());
            shootSound.play();
        }
    }
    
    //coliding method that checks if the ship hits a small or big asteroid
    public void colide()
    {
        if(isTouching(Asteroid.class))
        {
            MyWorld world = (MyWorld) getWorld();
            removeTouching(Asteroid.class);
            world.decreaseLives();
            world.addAsteroid();
            regen();
        }
            
        if(isTouching(SmallAsteroid.class))
        {
            MyWorld world = (MyWorld) getWorld();
            removeTouching(SmallAsteroid.class);
            world.decreaseLives();
            world.addAsteroid();
            regen();
        }
    }
    
    //resets the ship back to the middle when colided
    public void regen()
    {
        setLocation(400, 300);
        regenSound.play();
        
    }
}
