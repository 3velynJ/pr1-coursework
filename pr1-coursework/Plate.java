import greenfoot.*;
import java.util.Stack;
import java.util.ArrayList;
/**
 * A workstation where the sandwich is prepared according to the order ticket
 */
public class Plate extends Workstation
{   
    private ArrayList<String> plate; 
    private final String WRONG_INGREDIENT_MESSAGE = "Wrong ingredient!";
    private final String SANDWICH_COMPLETED_MESSGAE  = "Sandwich completed!";
    private SimpleTimer messageTimer;
    private boolean showingMessage;
    private final int MESSAGE_DURATION = 2000;

    public Plate() {
        this.plate = new ArrayList<String>();
        this.messageTimer = new SimpleTimer();
        this.showingMessage = false;
    }
    /**
     * Handles the interaction between the player and the plate
     */
    @Override
    protected void onInteraction(Player player) {
        ArrayList<String> recipe = getWorld().getObjects(Ticket.class).get(0).getRecipe();
        Ingredient ingredient = player.getInventory();
        if (ingredient != null) { //Check inventory full - might not need this
            if (this.plate.size() < recipe.size()) { //Also might not need this - checked later?
                String requiredIngredient = recipe.get(this.plate.size());
                if (ingredient.getName().equals(requiredIngredient)) {
                    this.plate.add(ingredient.getName());
                    player.setInventory(null);
                    player.updateInventoryUI(); // Take ingredient from inventory and add to plate
                    if (this.plate.size() == recipe.size()) {
                        showMessage(SANDWICH_COMPLETED_MESSGAE);
                        this.plate = new ArrayList<String>(); // reset array
                        // player.setInventory(); 
                        // Give player sandwich
                        // Inventory should be able to store ingredient and sandwich objects - 
                        // make one inherit from other or create overarching "food" class?
                    }
                } else {
                    showMessage(WRONG_INGREDIENT_MESSAGE);
                }
            }
        }
    }
    
     private void showMessage(String message) {
        showingMessage = true;
        messageTimer.mark();
        getWorld().showText(message, getX(), getY() + 30);
    }

    private void removeMessage() {
        getWorld().showText("", getX(), getY() + 30);
        showingMessage = false;
    }
    
    @Override
    public void act(){
        super.act();
        getWorld().showText(this.plate.toString(), 300, 300);
        if (showingMessage && messageTimer.millisElapsed() >= MESSAGE_DURATION) {
            removeMessage();
        }
    }
}
