import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RulesButton here.
 * 
 * Button that displays the rules of the game on the start screen
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class RulesButton extends Actor
{
    /**
     * Act - do whatever the RulesButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage ruleImg = getImage();
    public void act()
    {
        ruleImg.scale(150,105);
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new RulesWorld());
        }
    }
}
