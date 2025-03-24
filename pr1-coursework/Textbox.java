import greenfoot.*;

/**
 * A textbox that displays images which contain information for the player
 * 
 */
public class Textbox extends Actor {
    private GreenfootImage textbox;

    public Textbox(String imagePath) {
        textbox = new GreenfootImage(imagePath);
        setImage(textbox);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            removeSelf();
        }
    }

    public void removeSelf() {
        getWorld().removeObject(this);
    }
}