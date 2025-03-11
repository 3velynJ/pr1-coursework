import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Step {
    private Location location;
    private GreenfootImage icon;
    private boolean isIconChanged;
    private boolean isStepComplete;
    protected String ingredientName;
    protected boolean isRuined;
    protected String relativePath;
    
    
    public Step(Location location, String name, String relativePath){
        this.location = location;
        this.ingredientName = name;
        this.isIconChanged = false;
        this.isStepComplete = false;
        this.isRuined = false;
        this.relativePath = relativePath;
        setIcon(relativePath);
        
    }

    public void prepareIngredient(){
    };

    public Location getLocation(){
        return location;
    } 

    public GreenfootImage getIcon(){
        isIconChanged = false;
        return icon;
    } 

    protected void setIcon(String iconName){
        icon = new GreenfootImage(iconName);
        isIconChanged = true;
    } 

    public boolean getIsIconChanged(){
        return isIconChanged;
    } 

    public String getRelativePath() { 
        return relativePath;
          }

    public boolean getIsStepComplete(){
        return isStepComplete;
    } 

    protected void setIsStepComplete(boolean stepComplete){
        isStepComplete = stepComplete;
    } 


    
} 
