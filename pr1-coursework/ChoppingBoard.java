import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChoppingBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChoppingBoard extends Counter
{
    public ChoppingBoard() {
    }
    /**
     * Act - do whatever the Hob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!(getObjectsInRange(75, Player.class).isEmpty())) {
            getWorld().showText("Player touching chopping board", 150, 150);
            if (Greenfoot.isKeyDown("E")) {
                getWorld().showText("E key down", 150, 150);
            }
        } else {
            getWorld().showText(" ", 150, 150);
        }
    }
}
