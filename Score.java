import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String label;
    public int fontSize;
    public Color textColor;
    public Color backgroundColor;
    public int score;
    
    public Score(int score)
    {
        this.score = score;
        fontSize = 24;
        textColor = Color.RED;
        backgroundColor = new Color(0,0,0,0);
        this.label = "" + score;
        updateImage();
    }
    
    public void update(int change)
    {
        score += change;
        setLabel("" + score);
    }
    
    public void setLabel(String text)
    {
        this.label = text;
        updateImage();
    }
 
    public void updateImage()
    {
        GreenfootImage myImage = new GreenfootImage(label, fontSize, textColor, backgroundColor);
        setImage(myImage);
    }
    

}
