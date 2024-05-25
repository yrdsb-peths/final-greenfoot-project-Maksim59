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
    public Ship()
    {
        myImage.scale(50,50);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(3);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(3);
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(3);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(3);
        }
        shoot();
    }
    public void shoot()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Bullet(), getX(), getY());
        }
    }

}
