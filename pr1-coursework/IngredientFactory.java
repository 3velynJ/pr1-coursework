import greenfoot.*;
import java.util.ArrayList;


// Creates an ArrayList of different Steps depending on which method has been called and then creates an ingredient, passing in the list of steps
public class IngredientFactory {
    
    // Only adds 1 step (the ChopStep) to the list of Steps, so this ingredient only needs to be chopped
    public static Ingredient createStandardIngredient(String name, int chopsRequired){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,false));
        Ingredient standardIngredient = new Ingredient(steps);
        return standardIngredient;
    }

    // Adds 2 steps (the ChopStep and then the CookStep, passing in the hob) to the list of Steps, so this ingredient has to be chopped before it can be cooked (at the hob)
    public static Ingredient createHobIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,false));
        steps.add(new CookStep(Location.HOB, name, cookTime, burnTime,true));
        Ingredient vegetable = new Ingredient(steps);
        return vegetable;
    }

   // Adds 2 steps (the CookStep,passing in the oven, and then the ChopStep) to the list of Steps, so this ingredient has to be cooked (in the oven) before it can be chopped
    public static Ingredient createOvenIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new CookStep(Location.OVEN, name, cookTime, burnTime,false));
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,true));
        Ingredient meat = new Ingredient(steps);
        return meat;
    }

}