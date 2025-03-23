import greenfoot.*;

public class ChoppingBoard extends Workstation{
    private Ingredient currentIngredient;

    public ChoppingBoard() {
        updateWorkstationImage("chopping-board", currentIngredient);
    }
    @Override
    protected void onInteraction(Player player) {
        Ingredient playerIngredient = player.getInventoryIngredient();
        // If the player has an ingredient in the inventory and there isn't already an ingredient on the hob, then put the ingredient on the hob
        if (playerIngredient != null && currentIngredient == null) {
            currentIngredient = player.useInventoryIngredient();
            currentIngredient.setLocation(Location.CHOPPING_BOARD);
            updateWorkstationImage("chopping-board", currentIngredient);
            // If the player's inventory is empty but the hob has an ingredient, more the ingredient into the inventory on interaction
        } else if (playerIngredient == null && currentIngredient != null){
            player.storeInventoryIngredient(currentIngredient);
            currentIngredient = null;
            updateWorkstationImage("chopping-board", null);
        }
    }
    @Override
    public void act(){
        super.act();
    }
}
