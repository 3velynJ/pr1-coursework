import greenfoot.*;

public class ProgressBar extends Actor{
    private final int BAR_WIDTH = 60;
    private final int BAR_HEIGHT = 10;
    private int stagesComplete;
    private int pixexlsPerStage;


    public ProgressBar(int noOfStages){
        this.stagesComplete = noOfStages;
        this.pixexlsPerStage = (int) BAR_WIDTH / stagesComplete;
        update();

    }

    public void act(){
        update();
    }

    private void update(){
        GreenfootImage barImage = new GreenfootImage(BAR_WIDTH + 2,BAR_HEIGHT +2);
        barImage.setColor(Color.WHITE);
        barImage.drawRect(0,0,BAR_WIDTH, BAR_HEIGHT);
        barImage.setColor(Color.GREEN);
        barImage.fillRect(2,2,pixexlsPerStage * stagesComplete,BAR_HEIGHT);
    }

    public void incrementProgress(){
        stagesComplete++;
    }


    
}
