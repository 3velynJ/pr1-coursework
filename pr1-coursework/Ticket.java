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
        this.recipe = new ArrayList<String>();
        
        GreenfootImage ticket_img = new GreenfootImage(type + "-ticket.png");
        ticket_img.scale(300, 600);
        setImage(ticket_img);
        
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
    
    public ArrayList<String> getRecipe() {
        return this.recipe;
    }
    
    public void act()
    {
        
    }
}
