import greenfoot.*;
import java.util.ArrayList;

public class IngredientFactory {
    
    public static Ingredient createStandardIngredient(String name, int chopsRequired){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,false));
        Ingredient standardIngredient = new Ingredient(steps);
        return standardIngredient;
    }

    public static Ingredient createVegetableIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,false));
        steps.add(new CookStep(Location.HOB, name, cookTime, burnTime,true));
        Ingredient vegetable = new Ingredient(steps);
        return vegetable;
    }

    public static Ingredient createMeatIngredient(String name, int chopsRequired, int cookTime, int burnTime){
        ArrayList<Step> steps = new ArrayList<Step>();
        steps.add(new CookStep(Location.OVEN, name, cookTime, burnTime,false));
        steps.add(new ChopStep(Location.CHOPPING_BOARD,name,chopsRequired,true));
        Ingredient meat = new Ingredient(steps);
        return meat;
    }

}