import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ticket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ticket extends Actor
{   
    private String type;
    /**
     * Act - do whatever the Ticket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ticket(String type) {
        this.type = type;
        GreenfootImage ticket_img = new GreenfootImage(type + "-ticket.png");
        ticket_img.scale(300, 600);
        setImage(ticket_img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
