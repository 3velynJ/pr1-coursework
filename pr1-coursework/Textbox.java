import greenfoot.*;

public class Textbox extends Actor {
    private GreenfootImage textbox;
    private String defaultText = "\nPlease press the space bar to continue";
    private final int FONT_SIZE = 50;
    private boolean timerStopped;

    // Constructor that creates a pink Textbox message displaying whatever message is passed in
    public Textbox(String text){
        this.textbox = new GreenfootImage(text + defaultText, FONT_SIZE, greenfoot.Color.BLACK, greenfoot.Color.PINK, greenfoot.Color.BLACK);
        setImage(textbox);
        this.timerStopped = false;
    }

    
    public void act(){
        // If the timer has not already been stoppped, then stop it, pausing the game
        if (!timerStopped) {
            ((MyWorld) getWorld()).timer.stop(); 
        }
        // If the space bar is pressed, it removes itself from the world and resumes the timer 
        // This allows the player to continue with the game
        if (Greenfoot.isKeyDown("space")) {
            ((MyWorld) getWorld()).timer.resume(); 
            getWorld().removeObject(this);
        }

    }


}