import greenfoot.*;

/**
 * A UI display to show what is in the players inventory
 * 
 */
public class InventoryUI extends Actor
{
    public InventoryUI(){
        updateInventoryUI(null); //Be default the inventory ui is empty
    }
    
    public void updateInventoryUI(String ingredientTexturePath){
        
        //Draws the inventory ui
        GreenfootImage inventoryContainer = new GreenfootImage(50,50);
        inventoryContainer.setColor(Color.WHITE);
        inventoryContainer.fill();
        inventoryContainer.setColor(Color.BLACK);
        inventoryContainer.drawRect(0,0,49,49);
        
        if (ingredientTexturePath != null){
            GreenfootImage ingredientTexture = new GreenfootImage(ingredientTexturePath);
            ingredientTexture.scale(35,35);
            inventoryContainer.drawImage(ingredientTexture,8,8);
        }
        setImage(inventoryContainer); // Sets the ui to either display nothing or the image of the ingredient the player is holding
    }
}
