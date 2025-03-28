import greenfoot.*;
/**
   * A workstation where cookable ingredients can be cooked
**/
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
        super(50, 50);
        currentIngredient = null;
        cookingTimeRemaining = 0;
        isCooking = false;
        isReady = false;
        isBurned = false;
        setImage("images/hob.png");
        cookingTimer = new SimpleTimer();
        burnTimer = new SimpleTimer();
    }

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
                player.setCanMove(false);
                isCooking = true;
                cookingTimer.mark();
            }
        }
    }

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
                player.setCanMove(true);
                resetHob();
            } else if (burnTimer.millisElapsed() >= 3000) {
                    currentIngredient.burnt();
                    isBurned = true;
                    isReady = false;
                    getWorld().showText(BURNED_MESSAGE, getX(), getY() - 40);
                    player.setInventory(currentIngredient);
                    player.updateInventoryUI();
                    player.setCanMove(true);
            }
        }
        if(isBurned){
            if(burnTimer.millisElapsed() >= 5000){
                resetHob();
            }
        }
    }

    private void resetHob() {
        getWorld().showText("", getX(), getY() - 40);
        currentIngredient = null;
        isReady = false;
        isCooking = false;
        isBurned = false;
    }
}






