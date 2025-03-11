import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventoryUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryUI extends Actor
{
    public InventoryUI(){
        updateInventoryUI(null);
    }
    
    public void updateInventoryUI(String ingredientTexturePath){
        
        GreenfootImage inventoryContainer = new GreenfootImage(50,50);
        inventoryContainer.setColor(Color.WHITE);
        inventoryContainer.fill();
        inventoryContainer.setColor(Color.BLACK);
        inventoryContainer.drawRect(0,0,49,49);
        
        if (ingredientTexturePath != null){
            GreenfootImage ingredientTexture = new GreenfootImage(ingredientTexturePath);
            ingredientTexture.scale(50,50);
            inventoryContainer.drawImage(ingredientTexture,0,0);
        }
        setImage(inventoryContainer);
    }
    
    /**
     * Act - do whatever the InventoryUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
