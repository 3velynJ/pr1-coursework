import greenfoot.*;

public class ProgressBar extends Actor{
    private GreenfootImage barImage;
    private final int BAR_WIDTH = 60;
    private final int BAR_HEIGHT = 10;
    private final int OUTLINE_PIXELS = 3;
    private double fractionComplete;


    public ProgressBar(){
        // Set a white rectange as the image on construction
        this.barImage = new GreenfootImage(BAR_WIDTH + OUTLINE_PIXELS, BAR_HEIGHT + OUTLINE_PIXELS);
        barImage.setColor(Color.WHITE);
        barImage.fill();
        setImage(barImage);
    }

    private void update() {
        // Work out what portion of the bar shoubld be filled
        // Convert the double into an int because number of pixels must be whole
        int progressWidth = (int) (fractionComplete * BAR_WIDTH);
        // Only paint the progress bar if we have made some progress
        if (progressWidth > 0) {
            // Create a green "progress" rectange
            GreenfootImage progressImage = new GreenfootImage(progressWidth, BAR_HEIGHT);
            progressImage.setColor(Color.GREEN);
            progressImage.fill();
            // Draw the green progress rectangle onto the white progresss bar background
            barImage.drawImage(progressImage, OUTLINE_PIXELS, OUTLINE_PIXELS);
            setImage(barImage);
        }
    }

    // Once the progress reaches 100% / is complete then delete the progress bar from the world
    // If progress is not complete then update the bar to show the new proportion of the step that is complete 
    public void setPercentComplete(double fraction){
        if (fraction >= 1){
            getWorld().removeObject(this);
        } else{
            fractionComplete = fraction;
            update();
        }
    }

}
