import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Step {
    private Location location;
    private GreenfootImage icon;
    private boolean isIconChanged;
    private boolean isStepComplete;
    protected String ingredientName;
    private boolean isRuined;
    
    
    public Step(Location location, String name){
        this.location = location;
        this.ingredientName = name;
        this.isIconChanged = false;
        this.isStepComplete = false;
        this.isRuined = false;
    }

    // Called by the Ingredient when it is in the correct location
    public abstract void prepareIngredient();

    public Location getLocation(){
        return location;
    } 

    // Changes the step GreefootImage icon to be the iconName passed in 
    // And changes the isIconChanged flag to true so that we know to update the Ingredient GreenfootImage 
    protected void setIcon(String iconName){
        icon = new GreenfootImage(iconName);
        isIconChanged = true;
    } 

    // Gets the step GreefootImage icon so that the Ingredient GreenfootImage can be set to match
    // Sets the isIconChanged flag back to false
    public GreenfootImage getIcon(){
        isIconChanged = false;
        return icon;
    } 

    // Used to check if the step GreefootImage icon has been changed so that we know to update the Ingredient GreenfootImage 
    public boolean getIsIconChanged(){
        return isIconChanged;
    } 

    // Used by inherited steps to change whether they have been completed or not
    protected void setIsStepComplete(boolean stepComplete){
        isStepComplete = stepComplete;
    } 

    // Used to check if the step has been completed and the Ingredient can move onto the next step
    public boolean getIsStepComplete(){
        return isStepComplete;
    } 

    // Used by inherited steps to set the step to not be complete (it will never be able to be completed if it is ruined) 
    // And sets the isRuined flag to true so that we can mark our Ingredient as ruined
    protected void setIsRuined(){
        setIsStepComplete(false);
        isRuined = true;
    } 

    // Used by the Ingredient to determine if it has been ruined and can no longer be used 
    public boolean getIsRuined(){
        return isRuined;
    } 

    

    
} 
