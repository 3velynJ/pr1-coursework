import greenfoot.*;

/**
 * The game/ restuarnt logo that appears at the bottom of the screen 
*/
public class Sign extends Actor
{

    GreenfootImage sign_img = new GreenfootImage("images/sign.png");
    public Sign() {
        sign_img.scale(700, 100); //(width,height)
        setImage(sign_img);
    }
    public void act()
    {
        sign_img.scale(700, 100); //(width,height)
        setImage(sign_img);
    }
}
