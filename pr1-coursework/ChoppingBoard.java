import greenfoot.*;

public class ChoppingBoard extends Workstation{
    private Ingredient currentIngredient;
    private final int xCoOrd;
    private final int yCoOrd;

    public ChoppingBoard(int x, int y) {
        this.xCoOrd = x;
        this.yCoOrd = y;
        setImage("chopping-board.png");
    }
    @Override
    protected void onInteraction(Player player) {
        Ingredient playerIngredient = player.getInventoryIngredient();
        // If the player has an ingredient in the inventory and there isn't already an ingredient on the chopping board, then put the ingredient on the hob
        if (playerIngredient != null && currentIngredient == null) {
            currentIngredient = player.useInventoryIngredient();
            currentIngredient.setIngredientLocation(Location.CHOPPING_BOARD);
            currentIngredient.setLocation(xCoOrd + MyWorld.INGREDIENT_ICON_OFFSET, yCoOrd + MyWorld.INGREDIENT_ICON_OFFSET);
            // If the player's inventory is empty but the chopping board has an ingredient, more the ingredient into the inventory on interaction
        } else if (playerIngredient == null && currentIngredient != null){
            player.storeInventoryIngredient(currentIngredient);
            currentIngredient = null;
        }
    }
    @Override
    public void act(){
        super.act();
    }
}
