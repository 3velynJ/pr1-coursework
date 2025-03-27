import greenfoot.*; 

/**
 * A workstation to remove food from the player's inventory.
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
