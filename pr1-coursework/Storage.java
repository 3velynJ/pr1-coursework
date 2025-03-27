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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public boolean canInteract() {
        if (!canInteract && interactTimer.millisElapsed() >= INTERACTION_COOLDOWN) {
            canInteract = true;
            removeCooldownMessage(); 
        }
        return canInteract;
    }

    public void startCooldown() {
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
    
        if (player.getInventory() != null && player.getInventory().isBurnt()) {
            return;
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
    
    @Override
    public void act(){
        super.act();
        canInteract();
    }
}
