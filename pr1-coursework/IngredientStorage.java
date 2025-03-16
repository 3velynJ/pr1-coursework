import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StorageCrate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IngredientStorage extends Counter
{
    private Ingredient ingredient;
    private SimpleTimer interactTimer;
    private boolean canInteract;
    private final int INTERACT_COOLDOWN = 10000;

    public IngredientStorage(Ingredient ingredient) {
        this.ingredient = ingredient;
        this.interactTimer = new SimpleTimer();
        this.canInteract = true;
    }
    
    public Ingredient getIngredient() {
        return ingredient;
    }

    public boolean canInteract() {
        if (!canInteract && interactTimer.millisElapsed() >= INTERACT_COOLDOWN) {
            canInteract = true;
        }
        return canInteract;
    }

    public void startCooldown() {
        canInteract = false;
        interactTimer.mark();
    }
}
