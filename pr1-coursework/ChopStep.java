import greenfoot.*;

public class ChopStep extends Step{
    private int chopsRequired;
    private int chopCount;
    private boolean cDown;
    

    public ChopStep(String name, int chopsRequired, boolean hasPrevStep){
        super(name, name+".png"); 
        this.chopsRequired = chopsRequired;
        this.chopCount = 0;
        this.cDown = false;
        // if (hasPrevStep){
        //     setIcon(name + "-cooked.png");
        // } else{
        //     setIcon(name + ".png");
        // }
    }
    
    public void prepareIngredient(){
        checkForChop();
    };

    private void checkForChop(){
        if (Greenfoot.isKeyDown("c") && !cDown){
            chop();
            cDown = true;
        }
        if (!Greenfoot.isKeyDown("c") && cDown){
            cDown = false;
        }
    }
    
    private void chop(){
        chopCount++;
        if (chopCount >= chopsRequired){
            setIcon(ingredientName + "-chopped.png");
            setIsStepComplete(true);
            super.relativePath = ingredientName + "-chopped.png";
        }
        
    }
}
