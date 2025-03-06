import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/kitchen_floor.png");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 1100x500 cells with a cell size of 1x1 pixels.
        super(1100, 500, 1);
        background.scale(1100, 500);
        setBackground(background);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,500,250);
        
        addObject(new Counter(), 1075, 475);
        addObject(new Counter(), 1075, 425);
        addObject(new Counter(), 1075, 375);
        addObject(new Counter(), 1025, 475);
        addObject(new Counter(), 975, 475);
        addObject(new Counter(), 925, 475);
        
        addObject(new Counter(), 1075, 25);
        addObject(new Counter(), 1025, 25);
        addObject(new Counter(), 975, 25);
        addObject(new Counter(), 1075, 75);
        addObject(new Counter(), 1075, 125);
        
        addObject(new Counter(), 875, 225);
        addObject(new Counter(), 825, 225);
        addObject(new Counter(), 775, 225);
        addObject(new Counter(), 875, 275);
        addObject(new Counter(), 725, 225);
        addObject(new Counter(), 675, 225);
        addObject(new Counter(), 675, 275);
        
        addObject(new Counter(), 475, 25);
        addObject(new Counter(), 525, 25);
        addObject(new Counter(), 575, 25);
        addObject(new Counter(), 625, 25);
        
        //Wall between kitchen and restaurant - counters work for now, left a
        //gap for service hatch object
        addObject(new Counter(), 425, 25);
        addObject(new Counter(), 425, 75);
        addObject(new Counter(), 425, 125);
        addObject(new Counter(), 425, 175);
        addObject(new Counter(), 425, 325);
        addObject(new Counter(), 425, 375);
        addObject(new Counter(), 425, 425);
        addObject(new Counter(), 425, 475);
    }
}
