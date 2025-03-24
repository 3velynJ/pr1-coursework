import greenfoot.*;

/**
 * The base world object that all other world objects inherit from
 */
public class Obstacle extends Actor
{
    public Obstacle(int width, int height){
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }
}