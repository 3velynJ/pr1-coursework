import greenfoot.*;

/**
 * Represents an ingredient in the game which can have different states depending on what workstation the player has put it into (e.g. chopped)
 */
public class Ingredient extends Food {
    private String name;
    private String relativeImagePath;
    private boolean isCookable;
    private boolean isChoppable;
    private int timeToCook;
    private int numberOfChops;
    private boolean isCooked;
    private boolean isChopped;
    private boolean isBurnt;

    public Ingredient(String name, boolean isCookable, boolean isChoppable, int timeToCook, int numberOfChops) {
        this.name = name;
        this.relativeImagePath = "images/" + name + ".png";
        this.isCookable = isCookable;
        this.isChoppable = isChoppable;
        this.timeToCook = timeToCook;
        this.numberOfChops = numberOfChops;
        this.isCooked = false;
        this.isChopped = false;
        this.isBurnt = false;
    }
    
    /**
     * Copy constructor for the Ingredient class. 
     * Creates a new Ingredient object with the same properties - used by storage to "clone" ingredients
     */
    public Ingredient(Ingredient other) {
        this.name = other.name;
        this.relativeImagePath = other.relativeImagePath;
        this.isCookable = other.isCookable;
        this.isChoppable = other.isChoppable;
        this.timeToCook = other.timeToCook;
        this.numberOfChops = other.numberOfChops;
        this.isCooked = other.isCooked;
        this.isChopped = other.isChopped;
        this.isBurnt = other.isBurnt;
    }

    /**
     * Gets the name of the ingredient
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the relative file path of the ingredient image
     */
    public String getIngredientImagePath(){
        return relativeImagePath;
    }
    
    /**
     * Checks if the ingredient can be cooked
     */
    public boolean isCookable() {
        return isCookable;
    }

    /**
     * Checks if the ingredient can be chopped
     */
    public boolean isChoppable() {
        return isChoppable;
    }

    /**
     * Gets the time required to cook the ingredient
     */
    public int getTimeToCook() {
        return timeToCook;
    }

    /**
     * Gets the number of chops required to chop the ingredient
     */
    public int getNumberOfChops() {
        return numberOfChops;
    }

    /**
     * Checks if the ingredient is cooked
     */
    public boolean isCooked() {
        return isCooked;
    }
    
    /**
     * Checks if the ingredient is chopped
     */
    public boolean isChopped() {
        return isChopped;
    }
    
    /**
     * Sets the ingredient's state as cooked and updates its image path
     */
    public void cooked(){
        isCooked = true; 
        relativeImagePath = "images/" + name + "-cooked.png";
        isCookable = false;
    }
    
    /**
     * Sets the ingredient's state as chopped and updates its image path
     */
    public void chopped(){
        isChopped = true;
        relativeImagePath = "images/" + name + "-sliced.png";
        isChoppable = false;
    }
    
    /**
     * Checks if the ingredient is burnt
    */
    public boolean isBurnt() {
        return isBurnt;
    }

    /**
     * Sets the ingredient's state as burnt and updates its image path
    */
    public void burnt() {
        isBurnt = true;
        isCookable = false;
        isChoppable = false;
        relativeImagePath = "images/burnedIngredient.png";
    }
}
