import greenfoot.*;
import java.util.ArrayList;

public class IngredientFactory {
    
    public static Ingredient createStandardIngredient(String name, int chopsRequired){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(name,chopsRequired,false));
        // name, no. of chops, hasPrevStep?
        Ingredient standardIngredient = new Ingredient(steps);
        return standardIngredient;
    }

    public static Ingredient createVegetableIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(name,chopsRequired,false));
        // name, no. of chops, hasPrevStep?
        steps.add(new CookStep(name, cookTime, burnTime,true));
        // name, cooktime, burntime, hasPrevStep?
        Ingredient vegetable = new Ingredient(steps);
        return vegetable;
    }

    public static Ingredient createMeatIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new CookStep(name, cookTime, burnTime,false));
        steps.add(new ChopStep(name,chopsRequired,true));
        Ingredient meat = new Ingredient(steps);
        return meat;
    }

}
