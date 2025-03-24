import greenfoot.*;

/**
 * Used for the buttons that are needed for the start menu
 * 
 */
public class Button extends Actor {
    private String text;
    private Runnable action;

    public Button(String text, Runnable action) {
        this.text = text;
        this.action = action;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(text, 40, Color.BLACK, Color.LIGHT_GRAY);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            action.run();
        }
    }
}