import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Obstacle
{   
    GreenfootImage counter_img = new GreenfootImage("images/counter.png");
    public Counter() {
        super(50, 50);
        counter_img.scale(50, 50);
        setImage(counter_img);
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
