// All other teammates code

import greenfoot.*;
import java.util.ArrayList;

/**
 * Displays the order information to the player
 */
public class Ticket extends Actor
{   
    private String type;
    private ArrayList<String> recipe;
    
    public Ticket(String type) {
        this.type = type;
        // Initialises an empty recipe arraylist that ingredient names will be added to
        this.recipe = new ArrayList<String>();
        
        GreenfootImage ticketImg = new GreenfootImage(type + "-ticket.png");
        ticketImg.scale(300, 600);
        setImage(ticketImg);
        
        // Adds the correct ingredient names to the recipe depending on its type
        if (type == "blt") {
            recipe.add("bread");
            recipe.add("bacon");
            recipe.add("lettuce");
            recipe.add("tomato");
            recipe.add("bread");
        } else if (type == "bl") {
            recipe.add("bread");
            recipe.add("bacon");
            recipe.add("lettuce");
            recipe.add("bread");
        } else if (type == "lt") {
            recipe.add("bread");
            recipe.add("lettuce");
            recipe.add("tomato");
            recipe.add("bread");
        }
    }
    
    // Returns the list of ingredient names needed to make that recipe
    public ArrayList<String> getRecipe() {
        return this.recipe;
    }

    public String getType(){
        return type;
    }
}
