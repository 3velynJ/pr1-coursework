import greenfoot.*;

public class Storage extends Workstation {
    private String ingredientName;
    private SimpleTimer interactTimer;
    private boolean canInteract;
    private final int INTERACTION_COOLDOWN = 5000;
    private final String COOLDOWN_MESSAGE = "Storage on cooldown!";

    public Storage(String ingredientName) {
        setImage("storage.png");
        this.ingredientName = ingredientName;
        this.interactTimer = new SimpleTimer();
        this.canInteract = true;
    }

    // Creates the correct ingredient based on the ingredient name passed in on construction
    private Ingredient createIngredient(Player player) {
        Ingredient newIngredient = null;
        switch (ingredientName) {
            case "bread":
                newIngredient = IngredientFactory.createStandardIngredient("bread", 5);
                break;
            case "carrot":
                newIngredient = IngredientFactory.createHobIngredient("carrot", 10, 10, 15);
                break;
        }
        getWorld().addObject(newIngredient, player.getX() + MyWorld.INGREDIENT_ICON_OFFSET, player.getY() + MyWorld.INGREDIENT_ICON_OFFSET);
        return newIngredient;
    }

    private boolean canInteract() {
        if (!canInteract && interactTimer.millisElapsed() >= INTERACTION_COOLDOWN) {
            canInteract = true;
            removeCooldownMessage(); 
        }
        return canInteract;
    }

    private void startCooldown() {
        canInteract = false;
        interactTimer.mark();
        showCooldownMessage(); 
    }

    private void showCooldownMessage() {
        getWorld().showText(COOLDOWN_MESSAGE, getX(), getY() - 30);
    }

    private void removeCooldownMessage() {
        getWorld().showText("", getX(), getY() - 30);
    }
    
    @Override
    protected void onInteraction(Player player) {
        if (canInteract()) {
            if (player.getInventoryIngredient() == null) {
                player.storeInventoryIngredient(createIngredient(player));
            }
            startCooldown();
        }
    }
    
    @Override
    public void act(){
        super.act();
        canInteract();
    }
}