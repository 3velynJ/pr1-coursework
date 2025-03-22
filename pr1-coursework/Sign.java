import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sign extends Actor
{
    /**
     * Act - do whatever the Sign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage sign_img = new GreenfootImage("images/sign.png");
    public Sign() {
        sign_img.scale(700, 100);
        setImage(sign_img);
    }
    public void act()
    {
        sign_img.scale(700, 100);
        setImage(sign_img);
    }
}
