import greenfoot.*;

public class Textbox extends Actor {
    private GreenfootImage textbox;
    private String defaultText = "\nPlease press the space bar to continue";
    private final int FONT_SIZE = 50;

    public Textbox(String text){
        textbox = new GreenfootImage(text + defaultText, FONT_SIZE, greenfoot.Color.BLACK, greenfoot.Color.PINK, greenfoot.Color.BLACK);
        setImage(textbox);
    }

    public void act(){
        if (Greenfoot.isKeyDown("space")) {
            removeSelf();
        }

    }
 
    public void removeSelf()
    {
        getWorld().removeObject(this);
    }


}
