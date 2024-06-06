import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RulesButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        ruleImg.scale(100,100);
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
