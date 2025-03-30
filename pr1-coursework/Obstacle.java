// All other teammates code

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Obstacle extends Actor
{
    /**
     * Sets the image and size of the obstacle object
     */
    public Obstacle(int width, int height){
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }
}