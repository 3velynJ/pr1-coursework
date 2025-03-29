import greenfoot.*;

public class ProgressBar extends Actor{
    private GreenfootImage barImage;
    private final int BAR_WIDTH = 60;
    private final int BAR_HEIGHT = 10;
    private final int OUTLINE_PIXELS = 3;
    private double fractionComplete;


    public ProgressBar(){
        this.barImage = new GreenfootImage(BAR_WIDTH + OUTLINE_PIXELS, BAR_HEIGHT + OUTLINE_PIXELS);
        barImage.setColor(Color.WHITE);
        barImage.fill();
        setImage(barImage);
    }

    public void act(){
        //setPercentComplete(1/2);
    }

    private void update() {
        int progressWidth = (int) (fractionComplete * BAR_WIDTH);
        // Only paint the progress bar if we have made some progress
        if (progressWidth > 0) {
            GreenfootImage progressImage = new GreenfootImage(progressWidth, BAR_HEIGHT);
            progressImage.setColor(Color.GREEN);
            progressImage.fill();
            barImage.drawImage(progressImage, OUTLINE_PIXELS, OUTLINE_PIXELS);
            setImage(barImage);
        }
    }

    public void setPercentComplete(double fraction){
        if (fraction >= 1){
            getWorld().removeObject(this);
        } else{
            fractionComplete = fraction;
            update();
        }
    }


    
}
