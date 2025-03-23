import greenfoot.*;

public class CookStep extends Step{
    private final int MILLIS_PER_SECOND = 1000;
    private int cookTime;
    private int burnTime;
    private SimpleTimer timer;
    private boolean timerStarted;

       public CookStep(Location location, String name, int cookTime, int burnTime, boolean hasPrevStep){
        super(location, name); 
        // Convert the times passed in in seconds to miliseconds because the SimpleTimer class counts in miliseconds
        this.cookTime = cookTime * MILLIS_PER_SECOND;
        this.burnTime = burnTime * MILLIS_PER_SECOND;
        this.timer = new SimpleTimer();
        this.timerStarted = false;
        // Determine what the starting image for this step should be based on whether the ingredient has already been processed by a step before this
        if (hasPrevStep){
            setIcon(name + "-chopped.png");
        } else{
            setIcon(name + ".png");
        }
    }

    public void prepareIngredient(){
        cook();
    };
    

    private void cook(){
        if (timerStarted){
            if (cookTime <= timer.millisElapsed()){
                setIcon(ingredientName + "-cooked.png");
                setIsStepComplete(true);
                burn();
            }
        } else {
            timer.mark();
            timerStarted = true;
        }
    }

    private void burn(){
        if (burnTime <= timer.millisElapsed()){
            setIcon("burnt.png");
            setIsStepComplete(false);
            setIsRuined();
        }
    
    }

}