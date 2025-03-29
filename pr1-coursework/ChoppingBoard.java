import greenfoot.*;

/**
 * A workstation where chopable ingredients can converted to their chopped version
 */
public class ChoppingBoard extends Workstation {
    private Ingredient currentIngredient;
    private Player player;
    private int chopsRemaining;
    private boolean isChopping;
    private final String CHOPPING_MESSAGE = "Chops Left: ";
    private boolean chopKeyPressed;

    public ChoppingBoard() {
        currentIngredient = null;
        chopsRemaining = 0;
        isChopping = false;
        setImage("images/chopping-board.png");
        chopKeyPressed = false;
    }
    
    /**
     * Handles interaction between the player and the chopping board.
     * If the player is holding a choppable ingredient it will take it from them so they can chop it
     */
    @Override
    protected void onInteraction(Player player) {
        if (player != null) {
            this.player = player;
            if (!isChopping) {
                if (player.getInventory() != null && player.getInventory() instanceof Ingredient) {
                    Ingredient ingredient = (Ingredient) player.getInventory();
                    //Cast inventory contents to ingredient type so methods can be used
                    if (ingredient.isChoppable()) {
                        if (ingredient.isChopped()) {
                            return;
                        }
                        currentIngredient = ingredient;
                        player.setInventory(null);
                        player.updateInventoryUI();
                        chopsRemaining = currentIngredient.getNumberOfChops();
                        isChopping = true;
                        player.setCanMove(false);
                        chopKeyPressed = false;
                    }
                }
            }
        }
    }
    
    /**
     * Handles chopping logic and returns the chopped ingredient to the player when chopping is done
     */
    @Override
    public void act() {
        super.act();
        if (isChopping) {
            getWorld().showText(CHOPPING_MESSAGE + chopsRemaining, getX(), getY() - 40);
            
            if (Greenfoot.isKeyDown("c")) {
                if (!chopKeyPressed) {
                    chopsRemaining--;
                    chopKeyPressed = true;
                }
            } else {
                chopKeyPressed = false;
            }

            if (chopsRemaining <= 0) {
                isChopping = false;
                if (currentIngredient != null) {
                    currentIngredient.chopped();
                    player.setInventory(currentIngredient);
                    player.updateInventoryUI();
                    currentIngredient = null;
                    player.setCanMove(true); //Re-enables player movement (chopping ended)
                    getWorld().showText("", getX(), getY() - 40);
                }
            }
        }
    }
}
