import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bin extends Workstation
{
    public Bin() {
        
    }
    @Override
    protected void onInteraction(Player player) {
        player.setInventory(null);
        player.updateInventoryUI();
    }
    @Override
    public void act()
    {
       super.act();
    }
}
