import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plate extends Counter
{
    /**
     * Act - do whatever the Plate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!(getObjectsInRange(75, Player.class).isEmpty())) {
            getWorld().showText("Player touching plate", 150, 150);
            if (Greenfoot.isKeyDown("E")) {
                getWorld().showText("E key down", 150, 150);
            }
        } else {
            getWorld().showText(" ", 150, 150);
        }
    }
}
