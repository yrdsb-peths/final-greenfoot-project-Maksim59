import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * Start button which basically launches the ship to space so that it can
 * start shooting asteroids
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage launchImg = getImage();
    public void act()
    {
        launchImg.scale(100,100);
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
