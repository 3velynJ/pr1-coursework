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
    private Location myLocation;
    private boolean isPrepared;

    
    public Ingredient(ArrayList<Step> steps) {
        this.steps = steps;
        this.currentStep = steps.get(0);
        this.isPrepared = false;
        this.myLocation = Location.INVENTORY;
        setImage(currentStep.getIcon());
    }

    /**
     * Act - do whatever the Ingredient wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Gets the correct icon for the ingredient from the current step and sets it to be the ingredient's GreenfootImage each time the icon is updated/changed
        if (currentStep.getIsIconChanged()){
            setImage(currentStep.getIcon());
        }
        // The the ingredient has been placed in the correct location then call the prepare method on its current step
        if (myLocation.equals(currentStep.getLocation())){
            currentStep.prepareIngredient();
        }
    
    }

    public boolean setIngredientLocation(Location location){
        boolean isLocationSet = false;
        if (location != myLocation){
            // Always lets the player pick up the ingredient and put it in their inventory
            if (location == Location.INVENTORY){
                myLocation = location;
                isLocationSet = true;
                // The ingredient will always be placed in the inventory when moving between Step locations so if the ingredient has been placed in the inverntory and its current step is complete, move on to the next step
                if (currentStep.getIsStepComplete()){
                    moveToNextStep();
                }
            } 
            else {
                // If the ingredient is ruined and the location is trying to be set, throw an error message
                // The BIN just removes the ingredient object from the world so no enum location should be being set 
                if (currentStep.getIsRuined()){
                    getWorld().addObject(new Textbox("Uh oh! This ingredient is ruined.\nYou can't use it anymore.\nPlease put it in the bin and start again."), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                }
                // If the ingredient is not runied but not prepared and the player is at the wrong location, throw an error message directing them to the correct location
                else if ((location != currentStep.getLocation()) || (location == Location.PLATE && !isPrepared)){
                    getWorld().addObject(new Textbox("Uh Oh! This is the wrong location.\nPlease take this ingredient to the " + (currentStep.getLocation().locationText)), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                } 
                // If the ingredient is prepared and the location is trying to be set to anything other than the plate, throw an error message
                else if (location != Location.PLATE && isPrepared){
                    getWorld().addObject(new Textbox("Uh Oh! This is the wrong location.\nPlease take this ingredient to the plate"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                }
                // The player is at the correct location so set the enum location
                else {
                    myLocation = location;
                    isLocationSet = true;
                }
            }
        } 
        return isLocationSet;     
    }

    // Checks if all of the steps have been completed, moving on to the next step if not
    // If all steps have been completed, the isPrepared field is set to true
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
 

}
