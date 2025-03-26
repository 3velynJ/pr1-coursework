import greenfoot.*;
import java.util.ArrayList;
/**
 * Defines the attributes of an ingredient based on its type
 */
public class IngredientFactory {
    
    public static Ingredient createStandardIngredient(String name, int chopsRequired){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(name,chopsRequired,false));
        Ingredient standardIngredient = new Ingredient(name, steps);
        return standardIngredient;
    }

    public static Ingredient createVegetableIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(name,chopsRequired,false));
        steps.add(new CookStep(name, cookTime, burnTime,true));
        Ingredient vegetable = new Ingredient(name, steps);
        return vegetable;
    }

    public static Ingredient createMeatIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new CookStep(name, cookTime, burnTime,false));
        steps.add(new ChopStep(name,chopsRequired,true));
        Ingredient meat = new Ingredient(name, steps);
        return meat;
    }
    
    // Meat ingredient is the same as veg ingredient??
}
