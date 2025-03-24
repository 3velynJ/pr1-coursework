import greenfoot.*;
import java.util.ArrayList;

/**
 * This is the base class for an Ingredient. It is passed different Steps on
 * construction, depenting on what kind of ingredient it is.
 * 
 * 
 * @author (Joanna Grant)
 * @version (08/03/2025)
 */
public class Ingredient {
    private ArrayList<Step> steps;
    private Step currentStep;
    private boolean isPrepared;

    
    public Ingredient(ArrayList<Step> steps) {
        this.steps = steps;
        this.currentStep = steps.get(0);
        this.isPrepared = false;
    }
    
    public void moveToNextStep(){
        int currentIndex = steps.indexOf(currentStep);
        int nextIndex = currentIndex + 1;
        if (nextIndex < (steps.size())){
            currentStep = steps.get(nextIndex);
        } 
        else {
            isPrepared = true;
        }
    }
    
    public String getRelativePath(){
        return currentStep.getRelativePath();
    }

    public boolean getIsIngredientPrepared(){
        return isPrepared;
    } 

}