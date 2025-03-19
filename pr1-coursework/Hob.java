import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hob extends Counter
{
    public Hob() {
    }
    public void act()
    {
        if (!(getObjectsInRange(75, Player.class).isEmpty())) {
            getWorld().showText("Player touching hob", 150, 150);
            if (Greenfoot.isKeyDown("E")) {
                getWorld().showText("E key down", 150, 150);
            }
        } else {
            getWorld().showText(" ", 150, 150);
        }
        
    }
}
