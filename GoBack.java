import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoBack here.
 * 
 * Button so that when you enter the start screen and click on the instructions
 * you have a button to go back to the start screen
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class GoBack extends Actor
{
    /**
     * Act - do whatever the GoBack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage goBackButton = getImage();
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
