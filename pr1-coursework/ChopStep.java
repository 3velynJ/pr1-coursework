import greenfoot.*;

public class ChopStep extends Step{
    private int chopsRequired;
    private int chopCount;
    private boolean cDown;
    

    public ChopStep(Location location, String name, int chopsRequired, boolean hasPrevStep){
        super(location, name); 
        this.chopsRequired = chopsRequired;
        this.chopCount = 0;
        this.cDown = false;
        // Determine what the starting image for this step should be based on whether the ingredient has already been processed by a step before this
        if (hasPrevStep){
            setIcon(name + "-cooked.png");
        } else{
            setIcon(name + ".png");
        }
    }
    
    public void prepareIngredient(){
        checkForChop();
    };

    // Checks for individual presses of the 'c' key and calls the chop method on each press
    private void checkForChop(){
        if (Greenfoot.isKeyDown("c") && !cDown){
            chop();
            cDown = true;
        }
        if (!Greenfoot.isKeyDown("c") && cDown){
            cDown = false;
        }
    }
    
    // Increases the total number of chops by 1 each time this method is called
    // If the total chops is the same as the required number of chops for a specific Ingredient, then the ingredient has completed the ChopStep
    // If the total number of chops is greater than the required number of chops for an Ingredient, then the ingredient has been ruined and cannot be used anymore
    private void chop(){
        chopCount++;
        if (chopCount == chopsRequired){
            setIcon(ingredientName + "-chopped.png");
            setIsStepComplete(true);
        }
        if (chopCount > chopsRequired){
            setIcon("over-chopped.png");
            setIsRuined();
        }
        
    }
}