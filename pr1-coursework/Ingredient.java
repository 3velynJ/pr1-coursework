import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the base class for an Ingredient. It is passed different Steps on
 * construction, depenting on what kind of ingredient it is.
 * 
 * 
 * @author (Joanna Grant)
 * @version (08/03/2025)
 */
public class Ingredient extends Actor {
    private ArrayList<Step> steps;
    private Step currentStep;
    private Location myLocation ;
    private boolean isPrepared;
    //private boolean isRuined;

    
    public Ingredient(ArrayList<Step> steps) {
        this.steps = steps;
        this.currentStep = steps.get(0);
        this.myLocation = Location.STORAGE;
        this.isPrepared = false;
        setImage(currentStep.getIcon());
    }

    /**
     * Act - do whatever the Ingredient wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (currentStep.getIsIconChanged()){
            setImage(currentStep.getIcon());
        }
        if (myLocation.equals(currentStep.getLocation())){
            currentStep.prepareIngredient();
        }
    
    }

    public void setLocation(Location location){
        if (location != myLocation){
            //if it is ruined
            //if ((location != currentStep.getLocation()) && (location == Location.HOB || location == Location.OVEN ) || (location == Location.PLATE && !isPrepared))
            //call error messagew 
            //else 
            myLocation = location;
            if ((myLocation == Location.HAND) && currentStep.getIsStepComplete()){
                moveToNextStep();
            }
        }
    }

    public void moveToNextStep(){
        setLocation(Location.HOB);
        int currentIndex = steps.indexOf(currentStep);
        int nextIndex = currentIndex + 1;
        if (nextIndex < (steps.size())){
            currentStep = steps.get(nextIndex);
        } 
        else {
            isPrepared = true;
        }
    }
 

    public boolean getIsIngredientPrepared(){
        return isPrepared;
    } 

    public String getRelativePath(){
        return currentStep.getRelativePath();
    }

}