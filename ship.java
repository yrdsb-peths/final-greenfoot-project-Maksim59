import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage myImage = getImage();
    GreenfootImage moveImage = new GreenfootImage("images/shipMoving.png");
    GreenfootSound shootSound = new GreenfootSound("sounds/shot.mp3");
    MyWorld world = (MyWorld) getWorld();
    int transp = 200;
    public Ship()
    {
        
        myImage.scale(50,50);
        moveImage.scale(50,50);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
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
        if(world.getLives() == 0)
        {
            world.gameOver();
        }
        
    }
    
    public void shoot()
    {
        Bullet bullet = new Bullet(10);
        bullet.setRotation(getRotation());
        getWorld().addObject(bullet,getX(), getY());
        shootSound.play();
    }
    
    public void colide()
    {
        if(isTouching(Asteroid.class))
        {
            MyWorld world = (MyWorld) getWorld();
            removeTouching(Asteroid.class);
            world.decreaseLives();
            world.addAsteroid();
            transp -= 20;
            myImage.setTransparency(transp);
            
        }
    }

}
