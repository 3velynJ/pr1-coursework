import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/background.png");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 1100x500 cells with a cell size of 1x1 pixels.
        super(1400, 600, 1);
        background.scale(1400, 600);
        setBackground(background);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        InventoryUI inventoryUI = new InventoryUI();
        
        Player player = new Player(inventoryUI);
        addObject(player,500,250);
        
        addObject(new Counter(), 1075, 475);
        addObject(new Counter(), 1075, 425);
        // addObject(new Counter(), 1075, 375);
        addObject(new Counter(), 1025, 475);
        addObject(new Counter(), 975, 475);
        addObject(new Counter(), 925, 475);
        
        addObject(new Counter(), 1075, 25);
        addObject(new Counter(), 1025, 25);
        addObject(new Counter(), 975, 25);
        addObject(new Counter(), 1075, 75);
        addObject(new Counter(), 1075, 125);
        
        addObject(new Counter(), 875, 225);
        addObject(new Counter(), 825, 225);
        addObject(new Counter(), 775, 225);
        addObject(new Counter(), 875, 275);
        addObject(new Counter(), 725, 225);
        addObject(new Counter(), 675, 225);
        addObject(new Counter(), 675, 275);
        
        addObject(new Counter(), 475, 25);
        addObject(new Counter(), 525, 25);
        addObject(new Counter(), 575, 25);
        addObject(new Counter(), 625, 25);
        
        //Wall between kitchen and restaurant - counters work for now, left a
        //gap for service hatch object
        addObject(new Counter(), 425, 25);
        addObject(new Counter(), 425, 75);
        addObject(new Counter(), 425, 125);
        addObject(new Counter(), 425, 175);
        addObject(new Counter(), 425, 325);
        addObject(new Counter(), 425, 375);
        addObject(new Counter(), 425, 425);
        addObject(new Counter(), 425, 475);
        
        addObject(inventoryUI, 100, 550);
        
        addObject(new Hob(), 875, 475);
        addObject(new ChoppingBoard(), 475, 475);
        addObject(new Hatch(), 425, 250);
        
        Ingredient carrot = IngredientFactory.createVegetableIngredient("carrot",10,10,30);
        Ingredient bread = IngredientFactory.createStandardIngredient("bread",5);
        // ----- Ingredients should be instantiated in Storage class!!! ------
        // pass in name string (e.g. "bread") to Storage object and create ingredient accordingly
        
        addObject(new Storage(carrot), 1075, 375);
        addObject(new Counter(), 1075, 325);
        addObject(new Storage(bread), 1075, 275);
        addObject(new Counter(), 1075, 225);
        addObject(new Storage(carrot), 1075, 175); 
        addObject(new Counter(), 1075, 125);
        
        addObject(new Plate(), 675, 25);
        
        addObject(new Storage(bread), 675, 475);
        addObject(new Counter(), 525, 475);
        addObject(new Counter(), 575, 475);
        addObject(new Counter(), 625, 475);
        addObject(new Counter(), 725, 475);
        addObject(new Counter(), 775, 475);
        addObject(new Counter(), 825, 475);
        
        
    }
}
