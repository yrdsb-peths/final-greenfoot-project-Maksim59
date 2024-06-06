import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound popSound = new GreenfootSound("sounds/pop.mp3");
    GreenfootImage[]  idle = new GreenfootImage[5];
    SimpleTimer animationTimer = new SimpleTimer();
    public Lives()
    {
        for(int i = 0; i < 5; i++)
        {
            idle[i] = new GreenfootImage("images/heartAni/heart" + i + ".png");
            idle[i].scale(50,50);
        }
    }
    public void act()
    {
        animateLives();
    }
    
    public void loseLive()
    {
        MyWorld world = (MyWorld) getWorld();
        world.removeObject(this);
        popSound.play();
    }
    int imageIndex = 0;
     public void animateLives()
    {
        if(animationTimer.millisElapsed() < 180)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;

    }
}
