import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hatch extends Obstacle
{
    public Hatch() {
        super(50, 100);
    }
    /**
     * Act - do whatever the Hatch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!(getObjectsInRange(75, Player.class).isEmpty())) {
            getWorld().showText("Player touching hatch", 150, 150);
            if (Greenfoot.isKeyDown("E")) {
                getWorld().showText("E key down", 150, 150);
            }
        } else {
            getWorld().showText(" ", 150, 150);
        }
    }
}
