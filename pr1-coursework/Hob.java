import greenfoot.*;

public class Hob extends Workstation {
    private Ingredient currentIngredient; 
    private final int xCoOrd;
    private final int yCoOrd;

    public Hob(int x, int y) {
        this.xCoOrd = x;
        this.yCoOrd = y;
        setImage("hob.png");
    }
  
    @Override
    protected void onInteraction(Player player) {
        Ingredient playerIngredient = player.getInventoryIngredient();
        // If the player has an ingredient in the inventory and there isn't already an ingredient on the hob, then put the ingredient on the hob
        if (playerIngredient != null && currentIngredient == null) {
            currentIngredient = player.useInventoryIngredient();
            currentIngredient.setIngredientLocation(Location.HOB);
            currentIngredient.setLocation(xCoOrd + MyWorld.INGREDIENT_ICON_OFFSET,
                    yCoOrd + MyWorld.INGREDIENT_ICON_OFFSET);
            // If the player's inventory is empty but the hob has an ingredient, more the ingredient into the inventory on interaction
        } else if (playerIngredient == null && currentIngredient != null) {
            player.storeInventoryIngredient(currentIngredient);
            currentIngredient = null;
        }
    }

    @Override
    public void act(){
        super.act();
    }
}
