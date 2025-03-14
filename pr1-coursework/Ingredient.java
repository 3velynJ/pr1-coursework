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
            // Always let the player pick up the ingredient
            if (location == Location.HAND){
                myLocation = location;
                if (currentStep.getIsStepComplete()){
                    moveToNextStep();
                }
            } 
            else {
                // The BIN should remove the object from the world so it wont need to set an enum location 
                if (currentStep.getIsRuined()){
                    getWorld().addObject(new Textbox("Uh oh! This ingredient is ruined.\nYou can't use it anymore.\nPlease put it in the bin and start again."), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                }
                else if ((location != currentStep.getLocation()) || (location == Location.PLATE && !isPrepared) || location != Location.PLATE && isPrepared){
                    getWorld().addObject(new Textbox("Uh Oh! This is the wrong location.\nPlease take this ingredient to the " + (currentStep.getLocation().locationText)), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                }
                // The player is at the correct location
                else {
                    myLocation = location;
                }
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

}