import greenfoot.*; 

/**
 * A workstation to remove food from the player's inventory.
 */
public class Bin extends Workstation
{
    public Bin() {
        
    }
    
    /**
     * Handles interaction between the player and the bin.
     * This removes the food itemk that the player has in their inventory reguardless of its state (esentially 'binning' it)
     */
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
