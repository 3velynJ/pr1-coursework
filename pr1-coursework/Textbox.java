import greenfoot.*;

public class Textbox extends Actor {
    private GreenfootImage textbox;
    private String defaultText = "\nPlease press the space bar to continue";
    private final int FONT_SIZE = 50;

    // Constructor that creates a pink Textbox message that displays the message passed in
    public Textbox(String text){
        textbox = new GreenfootImage(text + defaultText, FONT_SIZE, greenfoot.Color.BLACK, greenfoot.Color.PINK, greenfoot.Color.BLACK);
        setImage(textbox);
    }

    // Removes itself, allowing the player to continue with the game, after the space bar is pressed
    public void act(){
        if (Greenfoot.isKeyDown("space")) {
            getWorld().removeObject(this);
        }

    }


}