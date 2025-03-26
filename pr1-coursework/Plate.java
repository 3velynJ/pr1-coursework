import greenfoot.*;
import java.util.Stack;
import java.util.ArrayList;
/**
 * A workstation where the sandwich is prepared according to the order ticket
 */
public class Plate extends Workstation
{   
    private ArrayList<String> plate; 
    // Tried to use a stack but had to access ingredients from bottom of the sandwich upwards
    // And need to reference elements by index to compare to recipe
    public Plate() {
        this.plate = new ArrayList<String>();
    }
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
                        getWorld().showText("sandwich done!", 300, 400);
                        this.plate = new ArrayList<String>(); // reset array
                        // player.setInventory(); 
                        // Give player sandwich
                        // Inventory should be able to store ingredient and sandwich objects - 
                        // make one inherit from other or create overarching "food" class?
                    }
                } else {
                    getWorld().showText("wrong ingredient!", 300, 400);
                }
            }
        }
    }
    @Override
    public void act(){
        super.act();
        getWorld().showText(this.plate.toString(), 300, 300);
    }
}
