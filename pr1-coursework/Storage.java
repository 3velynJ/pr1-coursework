import greenfoot.*;
/**
 * A workstation where ingredients are stored and can be taken out by the player
 */
public class Storage extends Workstation {
    private Ingredient ingredient;
    private SimpleTimer interactTimer;
    private boolean canInteract;
    private final int INTERACTION_COOLDOWN = 5000;
    private final String COOLDOWN_MESSAGE = "Storage on cooldown!";

    public Storage(Ingredient ingredient) {
        this.ingredient = ingredient;
        this.interactTimer = new SimpleTimer();
        this.canInteract = true;
        
        setImage(this.ingredient.getName() + "-storage.png");
    }
    /**
     * Returns the type of ingredient stored in this storage
     */
    public Ingredient getIngredient() {
        return ingredient;
    }
    
    /**
     * Checks whether the cooldown to interact with the storage has ended
     */
    public boolean canInteract() {
        if (!canInteract && interactTimer.millisElapsed() >= INTERACTION_COOLDOWN) {
            canInteract = true;
            removeCooldownMessage(); 
        }
        return canInteract;
    }
    
    /**
     * Shows a message while the storage is on cooldown so the play knows that they can't interact with it 
     */
    public void startCooldown() {
        canInteract = false;
        interactTimer.mark();
        showCooldownMessage(); 
    }
    
    /**
     * Removes the cooldown message when the cooldown ends 
     */
    private void showCooldownMessage() {
        getWorld().showText(COOLDOWN_MESSAGE, getX(), getY() - 30);
    }

    private void removeCooldownMessage() {
        getWorld().showText("", getX(), getY() - 30);
    }
    /**
     * Handles the interaction between the player and the storage.
     * Prevents the player from picking up an ingredient if they have a burnt one in their inventory.
     * If can interact is true (the cooldown on taking items from the storage is over) then the player can pick up an ingredient the that storage
     */
    @Override
    protected void onInteraction(Player player) {
    
        if (player.getInventory() != null && player.getInventory() instanceof Ingredient) {
            Ingredient ingredient = (Ingredient) player.getInventory();
            if (ingredient.isBurnt()) {
                return;
            }
        }
        
        if (canInteract()) {
            Ingredient newIngredient = new Ingredient(this.ingredient);
            player.setInventory(newIngredient);
            if (player.getInventory() != null) {
                player.updateInventoryUI();
            }
            startCooldown();
        }
    }
    
    /**
     * Calls the canInteract method to check if the cooldown on the storage has ended so that the player can interact with it again
     */
    @Override
    public void act(){
        super.act();
        canInteract();
    }
}
