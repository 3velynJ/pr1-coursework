import greenfoot.*;
import java.util.Stack;
import java.util.ArrayList;
/**
 * A workstation where the sandwich is prepared according to the order ticket
 */
public class Plate extends Workstation{   
    private ArrayList<Ingredient> plate; //Ingredients added to the plate 
    
    /**
     * Constructor
     */
    public Plate() {
        this.plate = new ArrayList<Ingredient>(); //Empty plate
        setImage("plate.png");
    }
    /**
     * Handles the interaction between the player and the plate
     */
    @Override
    protected void onInteraction(Player player) {
        Ingredient playerIngredient = player.getInventoryIngredient();
        //Does the players inventory contain an ingredient
        if (playerIngredient != null){
            if (playerIngredient.getIsPrepared()) {
                Ticket ticket = player.getTicket();
                // If it is the correct ingredient, add it to the plate 
                if (isCorrectIngredient(playerIngredient, ticket)){
                    addIngredient(player, playerIngredient);
                    // Added ingredient so check if the order is complete 
                    if (plate.size() == ticket.getRecipe().size()) {
                        // Create the appropriate plate 
                        createCompletedDish(player, ticket);
                        getWorld().addObject(new Textbox("YAY! This dish is now complete!\n Please take it to the hatch to get a new ticket"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                    }
                } 
                else{
                    getWorld().addObject(new Textbox("Uh Oh! This is the wrong ingredient"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                }

            }
            else{
                getWorld().addObject(new Textbox("Uh Oh! This ingredient needs to be prepared first"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
            }
        } 
    }
    
    /** 
     * Checks if the ingredient is as required
     */
    private boolean isCorrectIngredient(Ingredient ingredient, Ticket ticket) {
        int ingregredientIndex = this.plate.size();
        String requiredIngredient = ticket.getRecipe().get(ingregredientIndex);
        return ingredient.getName().equals(requiredIngredient);
    }
    
    
    /** 
     * Adds the ingredient to the plate and removes it from the player 
     */
    private void addIngredient(Player player, Ingredient ingredient) {
        player.useInventoryIngredient();
        if (ingredient.setIngredientLocation(Location.PLATE)) {
            ingredient.setLocation(getX(), getY());
            this.plate.add(ingredient);
        }       
    }
    
    /**
     * Completes the completed dish and gives it to the player
     */
    private void createCompletedDish(Player player, Ticket ticket) {
        deleteIngredients();
        CompletedDish dish = new CompletedDish(ticket);
        getWorld().addObject(dish, player.getX() + MyWorld.INGREDIENT_ICON_OFFSET,
                player.getY() + MyWorld.INGREDIENT_ICON_OFFSET);
        player.setCompletedDish(dish);
    }

    private void deleteIngredients(){
        for (Ingredient ingredient : plate) {
            getWorld().removeObject(ingredient);
        }
    }
   
    
    
    @Override
    public void act(){
        super.act();
    }
}
