import greenfoot.*;

public class CookStep extends Step{
    private final int MILLIS_PER_SECOND = 1000;
    private int cookTime;
    private int burnTime;
    private SimpleTimer timer;

       public CookStep(String name, int cookTime, int burnTime, boolean hasPrevStep){
        super(name, name+".png"); 
        this.cookTime = cookTime * MILLIS_PER_SECOND;
        this.burnTime = burnTime * MILLIS_PER_SECOND;
        this.timer = new SimpleTimer();
    }

    public void prepareIngredient(){
        startCooking();
    };
    
    private void startCooking(){
        timer.mark();
        if (cookTime == timer.millisElapsed()){
            setIcon(ingredientName + "-cooked.png");
            setIsStepComplete(true);
            super.relativePath = ingredientName + "-cooked.png";
            startBurning();
        }
    
    }

    private void startBurning(){
        timer.mark();
        if (burnTime == timer.millisElapsed()){
            setIcon("burnt.png");
            setIsStepComplete(false);
            isRuined = true;
            super.relativePath = "burnt.png";
        }
    
    }

}