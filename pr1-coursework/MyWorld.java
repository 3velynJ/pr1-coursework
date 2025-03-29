import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/background.png");
    public static final int WORLD_HEIGHT = 600;
    public static final int WORLD_WIDTH = 1400;
    public static final int INGREDIENT_ICON_OFFSET = 15;
    public static final int SPACE_BETWEEN_COUNTERS = 50;
    public static final int BOTTOM_ROWY = 475;
    public Timer timer;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 1400x600 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        background.scale(WORLD_WIDTH, WORLD_HEIGHT);
        setBackground(background);
        this.timer = new Timer(300);
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
        
        addObject(new Counter(), 1075, BOTTOM_ROWY);
        addObject(new Counter(), 1075, 425);
        // addObject(new Counter(), 1075, 375);
        addObject(new Counter(), 1025, BOTTOM_ROWY);
        addObject(new Counter(), 975, BOTTOM_ROWY);
        addObject(new Counter(), 925, BOTTOM_ROWY);
        addObject(new Bin(), 925, 25);
        
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
        addObject(new Counter(), 425, BOTTOM_ROWY);
        
        addObject(new PrepArea(Location.HOB,875, BOTTOM_ROWY), 875, BOTTOM_ROWY);
        addObject(new PrepArea(Location.CHOPPING_BOARD,475,BOTTOM_ROWY), 475, BOTTOM_ROWY);
        addObject(new Hatch(), 425, 250);
        
        addObject(new Storage("carrot"), 1075, 375);
        addObject(new Counter(), 1075, 325);
        addObject(new Storage("bread"), 1075, 275);
        addObject(new Counter(), 1075, 225);
        addObject(new Storage("carrot"), 1075, 175); 
        addObject(new Counter(), 1075, 125);
        
        addObject(new Plate(), 675, 25);
        
        addObject(new Storage("bread"), 675, BOTTOM_ROWY);
        addObject(new Counter(), 525, BOTTOM_ROWY);
        addObject(new Counter(), 575, BOTTOM_ROWY);
        addObject(new Counter(), 625, BOTTOM_ROWY);
        addObject(new Counter(), 725, BOTTOM_ROWY);
        addObject(new Counter(), 775, BOTTOM_ROWY);
        addObject(new Counter(), 825, BOTTOM_ROWY);

        
        addObject(timer, 315, 557);
        
    
    }
}
