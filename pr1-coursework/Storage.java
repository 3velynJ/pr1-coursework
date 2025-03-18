import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Storage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Storage extends Counter
{   
    private Ingredient ingredient;
    private SimpleTimer interactTimer;
    private boolean canInteract;
    private final int INTERACT_COOLDOWN = 10000;
    
    public Storage(Ingredient ingredient) {
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
    /**
     * Act - do whatever the Storage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (!(getObjectsInRange(75, Player.class).isEmpty())) {
            if (Greenfoot.isKeyDown("E")) {
                Player player = getObjectsInRange(75, Player.class).get(0);
                player.setInventory(this.ingredient);
                getWorld().showText(player.getInventory().getRelativePath(), 150, 150);
            }
        } else {
            //getWorld().showText(" ", 150, 150);
        }
    }
}