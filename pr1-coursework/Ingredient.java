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
    
    // Copy constructor
    public Ingredient(Ingredient other) {
        this.name = other.name;
        this.relativeImagePath = other.relativeImagePath;
        this.isCookable = other.isCookable;
        this.isChoppable = other.isChoppable;
        this.timeToCook = other.timeToCook;
        this.numberOfChops = other.numberOfChops;
        this.isCooked = other.isCooked;
        this.isChopped = other.isChopped;
    }

    public String getName() {
        return name;
    }
    
    public String getIngredientImagePath(){
        return relativeImagePath;
    }
    
    public boolean isCookable() {
        return isCookable;
    }

    public boolean isChoppable() {
        return isChoppable;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    public int getNumberOfChops() {
        return numberOfChops;
    }

    public boolean isCooked() {
        return isCooked;
    }
    
    public boolean isChopped() {
        return isChopped;
    }
    
    public void cooked(){
        isCooked = true; 
        relativeImagePath = "images/" + name + "-cooked.png";
        isCookable = false;
    }
    
    public void chopped(){
        isChopped = true;
        relativeImagePath = "images/" + name + "-sliced.png";
        isChoppable = false;
    }
    public boolean isBurnt() {
        return isBurnt;
    }

    public void burnt() {
        isBurnt = true;
        isCookable = false;
        isChoppable = false;
        relativeImagePath = "images/burnedIngredient.png";
    }
}

