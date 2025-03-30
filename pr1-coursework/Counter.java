// All other teammates code

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * /**
 * A counter which acts as an obstacle for the player that they have to navigate around
 */
public class Counter extends Obstacle
{   
   private GreenfootImage counterImage = new GreenfootImage("counter.png");
    public Counter() {
        super(50, 50);
        counterImage.scale(50, 50);
        setImage(counterImage);
    }
}
