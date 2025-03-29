import greenfoot.*;

/**
 * Used to make buttons that can run a method when clicked
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
            action.run(); //Runs a method
        }
    }
}