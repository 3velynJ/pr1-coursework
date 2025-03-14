import greenfoot.*;

public class CookStep extends Step{
    private final int MILLIS_PER_SECOND = 1000;
    private int cookTime;
    private int burnTime;
    private SimpleTimer timer;

       public CookStep(Location location, String name, int cookTime, int burnTime, boolean hasPrevStep){
        super(location, name); 
        this.cookTime = cookTime * MILLIS_PER_SECOND;
        this.burnTime = burnTime * MILLIS_PER_SECOND;
        this.timer = new SimpleTimer();
        if (hasPrevStep){
            setIcon(name + "-chopped.png");
        } else{
            setIcon(name + ".png");
        }
    }

    public void prepareIngredient(){
        startCooking();
    };
    
    private void startCooking(){
        timer.mark();
        if (cookTime == timer.millisElapsed()){
            setIcon(ingredientName + "-cooked.png");
            setIsStepComplete(true);
            startBurning();
        }
    
    }

    private void startBurning(){
        timer.mark();
        if (burnTime == timer.millisElapsed()){
            setIcon("burnt.png");
            setIsStepComplete(false);
            setIsRuined();
        }
    
    }

}