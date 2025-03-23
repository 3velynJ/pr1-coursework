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
    
    public void updateInventoryUI(GreenfootImage ingredientIcon){
        
        GreenfootImage inventoryContainer = new GreenfootImage(50,50);
        inventoryContainer.setColor(Color.WHITE);
        inventoryContainer.fill();
        inventoryContainer.setColor(Color.BLACK);
        inventoryContainer.drawRect(0,0,49,49);
        
        if (ingredientIcon != null){
            ingredientIcon.scale(35,35);
            inventoryContainer.drawImage(ingredientIcon,8,8);
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
