import greenfoot.*;
import java.util.Stack;
import java.util.ArrayList;
/**
 * A workstation where the sandwich is prepared according to the order ticket
 */
public class Plate extends Workstation
{   
    private ArrayList<String> plate; //Ingredients added to the plate 
    private final String WRONG_INGREDIENT_MESSAGE = "Wrong ingredient!";
    private final String SANDWICH_COMPLETED_MESSAGE  = "Sandwich completed!";
    private SimpleTimer messageTimer;
    private boolean showingMessage;
    private final int MESSAGE_DURATION = 2000;
    
    /**
     * Constructor
     */
    public Plate() {
        this.plate = new ArrayList<String>(); //Empty plate
        this.messageTimer = new SimpleTimer();
        this.showingMessage = false;
    }
    /**
     * Handles the interaction between the player and the plate
     */
    @Override
    protected void onInteraction(Player player) {
        //Does the players inventory contain an ingredient
        if (player.getInventory() instanceof Ingredient) {
            Ingredient ingredient = (Ingredient) player.getInventory();
            //Get the recipe from the current order
            ArrayList<String> recipe = getWorld().getObjects(Ticket.class).get(0).getRecipe();
            
            if (isCorrectIngredient(ingredient, recipe)) {
                addIngredient(player, ingredient, recipe);
            } else {
                showMessage(WRONG_INGREDIENT_MESSAGE);
            } 
        }
    }
    
    /** 
     * Checks if the ingredient is as required
     */
    private boolean isCorrectIngredient(Ingredient ingredient, ArrayList<String> recipe) {
        int currentStep = this.plate.size();
        if (currentStep >= recipe.size()) {
            return false; //If all ingredients are already added
        }
        
        String requiredIngredient = recipe.get(currentStep);
        return ingredient.getName().equals(requiredIngredient) && isIngredientReady(ingredient, requiredIngredient);
    }
    
    /** 
     * Checks if the ingredient is ready based on type
     */
    private boolean isIngredientReady(Ingredient ingredient, String requiredIngredient) {
        //Is the ingredient chopped or cooked as required
        switch (requiredIngredient) {
            case "bread":
            case "lettuce":
            case "tomato":
                return ingredient.isChopped();
            case "bacon":
                return ingredient.isCooked();
            default:
                return false;
        }
    }
    
    /** 
     * Adds the ingredient to the plate and checks if the sandwich is complete
     */
    private void addIngredient(Player player, Ingredient ingredient, ArrayList<String> recipe) {
        this.plate.add(ingredient.getName());
        player.setInventory(null);
        player.updateInventoryUI();
        
        if (this.plate.size() == recipe.size()) {
            completeSandwich(player);
        }
    }
    
    /**
     * Completes the sandwich
     */
    private void completeSandwich(Player player) {
        showMessage(SANDWICH_COMPLETED_MESSAGE);
        this.plate.clear();
        player.setInventory(new Sandwich());
        player.updateInventoryUI();
    }
    
    /**
     * Displays a temporary message
     */
     private void showMessage(String message) {
        showingMessage = true;
        messageTimer.mark();
        getWorld().showText(message, getX(), getY() + 30);
    }
    
    /**
     * Removes a displayed message
     */
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
