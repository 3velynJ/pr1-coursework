import greenfoot.*;

public class Bin extends Workstation{

    public Bin() {
        setImage("bin.png");
    }
     
    // Deletes the Ingredient object, removing it from the world 
    @Override
    protected void onInteraction(Player player) {
        getWorld().removeObject(player.useInventoryIngredient());
    }

}
