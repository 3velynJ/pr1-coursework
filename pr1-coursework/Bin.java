import greenfoot.*;

public class Bin extends Workstation{

    public Bin() {
        setImage("bin.png");
    }
     
    // Deletes the Ingredient object from the world 
    @Override
    protected void onInteraction(Player player) {
        getWorld().removeObject(player.useInventoryIngredient());
    }
    
    @Override
    public void act()
    {
       super.act();
    }
}
