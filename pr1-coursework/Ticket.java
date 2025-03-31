import greenfoot.*;
import java.util.ArrayList;

/**
 * Displays the order information to the player
 */
public class Ticket extends Actor
{   
    private String type; //Type of sandwich
    private ArrayList<String> recipe; //List of ingredients
    
    /**
     * Constructor
     */
    public Ticket(String type) {
        this.type = type;
        this.recipe = new ArrayList<String>(); //Empty recipe
        
        GreenfootImage ticket_img = new GreenfootImage(type + "-ticket.png");
        ticket_img.scale(300, 600);
        setImage(ticket_img);
        
        if (type.equals("blt")) {
            recipe.add("bread");
            recipe.add("bacon");
            recipe.add("lettuce");
            recipe.add("tomato");
            recipe.add("bread");
        } else if (type.equals("bl")) {
            recipe.add("bread");
            recipe.add("bacon");
            recipe.add("lettuce");
            recipe.add("bread");
        } else if (type.equals("lt")) {
            recipe.add("bread");
            recipe.add("lettuce");
            recipe.add("tomato");
            recipe.add("bread");
        }
    }
    
    /**
     * Returns then list of ingredients
     */
    public ArrayList<String> getRecipe() {
        return this.recipe;
    }
    
    public void act()
    {
        
    }
}
