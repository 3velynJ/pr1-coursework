import greenfoot.*;

/**
 * The game/ restuarnt logo that appears at the bottom of the screen 
*/
public class Sign extends Actor
{
    GreenfootImage sign_img;
    
    /**
     * Constructor
     */
    public Sign() {
        this.sign_img = new GreenfootImage("images/sign.png");
        this.sign_img.scale(700, 100); //(width, height)
        setImage(this.sign_img);
    }
    
    public void act()
    {
        
    }
}
