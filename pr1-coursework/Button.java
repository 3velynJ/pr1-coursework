import greenfoot.*;

/**
 * Used for the buttons that are needed for the start menu
 */
public class Button extends Actor {
    private Runnable action;
    private GreenfootImage buttonImage;

    public Button(String imagePath, Runnable action) {
        this.action = action;
        this.buttonImage = new GreenfootImage(imagePath);
        setImage(buttonImage);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            action.run();
        }
    }
}