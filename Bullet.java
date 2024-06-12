import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * Class the ship uses to destroy asteroids
 * 
 * @author (Maksim Isayenka) 
 * @version (2024-06-12)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    public Bullet(int s)
    {
        speed = s;
    }
    
    public void act()
    {
        move(speed);
        inGame();
    }    
    
    /*checks to see if the bullet is still in the game and if it is outside
    it deletes it */
    public void inGame()
    {
        GreenfootImage img = getImage();
        int width = img.getWidth();
        int height = img.getHeight();
        
        World myWorld = getWorld();

        int left = getX() - width/2;
        int right = getX() + width/2;
        int top = getY() - height/2;
        int bottom = getY() + height/2;
        
        if(left <= 0)
        {
            myWorld.removeObject(this);
        }
        else if(right >= myWorld.getWidth())
        {
            myWorld.removeObject(this);
        }
        else if(top <= 0)
        {
            myWorld.removeObject(this);
        }
        else if(bottom >= myWorld.getHeight())
        {
            myWorld.removeObject(this);
        }
    }
    
    
    
}
