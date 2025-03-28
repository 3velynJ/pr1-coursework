import greenfoot.*;
/**
   * A workstation where cookable ingredients can be cooked
*/
public class Hob extends Workstation {
    private Ingredient currentIngredient;
    private Player player;
    private int cookingTimeRemaining;
    private boolean isCooking;
    private final String COOKING_MESSAGE = "Cooking Time Left: ";
    private final String READY_MESSAGE = "Ready!";
    private final String BURNED_MESSAGE = "Burned!";
    private SimpleTimer cookingTimer;
    private SimpleTimer burnTimer;
    private boolean isReady;
    private boolean isBurned;

    public Hob() {
        currentIngredient = null;
        cookingTimeRemaining = 0;
        isCooking = false;
        isReady = false;
        isBurned = false;
        setImage("images/hob.png");
        cookingTimer = new SimpleTimer();
        burnTimer = new SimpleTimer();
    }
    
    /**
     * Handles interaction between the player and the hob.
     * If the player is holding a cookable ingredient then it will take it from them so that it can be cooked
     */
    @Override
    protected void onInteraction(Player player) {
        if (isReady && Greenfoot.isKeyDown("c")) {
            player.setInventory(currentIngredient);
            player.updateInventoryUI();
            resetHob();
        } else if (!isCooking && player.getInventory() != null && player.getInventory() instanceof Ingredient) {
            Ingredient ingredient = (Ingredient) player.getInventory();
            if (ingredient.isChopped() && ingredient.isCookable()) {
                this.player = player;
                currentIngredient = ingredient;
                player.setInventory(null);
                player.updateInventoryUI();
                cookingTimeRemaining = currentIngredient.getTimeToCook();
                player.setCanMove(false); // Disables player movement (cooking started)
                isCooking = true;
                cookingTimer.mark();
            }
        }
    }
    
    /**
     * Handles the logic for cooking ingredients.
     * Can set an ingredient to a cooked state after a specific amount of time defined by the ingredient's timeToCook.
     * If the ingredient is cooked then the player can press C to return it to their inventory.
     * Can set an ingredient to a burnt state if the player doesnt pick it up fast enough 
     */
    @Override
    public void act() {
        super.act();
        if (isCooking) {
            int elapsedSeconds = cookingTimer.millisElapsed() / 1000;

            if (elapsedSeconds >= 1) {
                cookingTimeRemaining--;
                cookingTimer.mark();
            }
            getWorld().showText(COOKING_MESSAGE + cookingTimeRemaining, getX(), getY() - 40);
            if (cookingTimeRemaining <= 0) {
                getWorld().showText(READY_MESSAGE, getX(), getY() - 40);
                isCooking = false;
                currentIngredient.cooked();
                isReady = true;
                burnTimer.mark();
            }
        }

        if (isReady) {
            if (Greenfoot.isKeyDown("c")) { 
                player.setInventory(currentIngredient);
                player.updateInventoryUI();
                player.setCanMove(true); // Re-enables player movement (cooking ended)
                resetHob();
            } else if (burnTimer.millisElapsed() >= 1000) { //Burns the ingredient and then returns it to the player's inventory once the burn timer has reached 1 second
                    currentIngredient.burnt();
                    isBurned = true;
                    isReady = false;
                    getWorld().showText(BURNED_MESSAGE, getX(), getY() - 40);
                    player.setInventory(currentIngredient);
                    player.updateInventoryUI();
                    player.setCanMove(true); // Re-enables player movement (cooking ended)
            }
        }
        if(isBurned){
            if(burnTimer.millisElapsed() >= 5000){
                resetHob();
            }
        }
    }
    
    /**
     * Removes the stored ingredient and resets all the attributes of the hob to false
     */
    private void resetHob() {
        getWorld().showText("", getX(), getY() - 40);
        currentIngredient = null;
        isReady = false;
        isCooking = false;
        isBurned = false;
    }
}






