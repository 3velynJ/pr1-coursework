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
        if (player.getInventory() != null && player.getInventory() instanceof Ingredient) { 
            Ingredient ingredient = (Ingredient) player.getInventory();
            String requiredIngredient = recipe.get(this.plate.size());
            if (ingredient.getName().equals(requiredIngredient) && isIngredientReady(ingredient, requiredIngredient)) {
                //Checks if the ingredient is correct type and if it is ready
                this.plate.add(ingredient.getName());
                player.setInventory(null);
                player.updateInventoryUI();
                //Takes ingredient from player and adds to plate
                if (this.plate.size() == recipe.size()) {
                    showMessage(SANDWICH_COMPLETED_MESSGAE);
                    this.plate = new ArrayList<String>(); //Resets plate
                    Sandwich sandwich = new Sandwich();
                    player.setInventory(sandwich); 
                    player.updateInventoryUI();
                }
            } else {
                 showMessage(WRONG_INGREDIENT_MESSAGE);
            }
        }
    }
    
    private boolean isIngredientReady(Ingredient ingredient, String requiredIngredient) {
        //Accesses state of ingredient and returns t/f if it meets requirements
        if (requiredIngredient.equals("bread") || requiredIngredient.equals("lettuce") || requiredIngredient.equals("tomato")) {
            return ingredient.isChopped();
        } else if (requiredIngredient.equals("bacon")) {
            return ingredient.isCooked();
        } else {
            return false;
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
        if (showingMessage && messageTimer.millisElapsed() >= MESSAGE_DURATION) {
            removeMessage();
        }
    }
}
