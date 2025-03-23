import greenfoot.*;

public class Hob extends Workstation {
    private Ingredient currentIngredient; 



    public Hob() {
        updateWorkstationImage("hob", currentIngredient);
    }
    @Override
    protected void onInteraction(Player player) {
        Ingredient playerIngredient = player.getInventoryIngredient();
        // If the player has an ingredient in the inventory and there isn't already an ingredient on the hob, then put the ingredient on the hob
        if (playerIngredient != null && currentIngredient == null) {
            currentIngredient = player.useInventoryIngredient();
            currentIngredient.setLocation(Location.HOB);
            updateWorkstationImage("hob", currentIngredient);
            // If the player's inventory is empty but the hob has an ingredient, more the ingredient into the inventory on interaction
        } else if (playerIngredient == null && currentIngredient != null){
            player.storeInventoryIngredient(currentIngredient);
            updateWorkstationImage("hob", null);
        }
    }
    @Override
    public void act(){
        super.act();
    }
}
