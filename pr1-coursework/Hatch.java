import greenfoot.*;
import greenfoot.*;
import java.util.List;
import java.util.Collections;
/**
 * A workstation where the player puts the finished sandwich to complete the order
 */
public class Hatch extends Workstation
{
    private Ticket currentTicket;
    private List<Ticket> ticketList;
    private int listIndex;

    public Hatch() {
        super(50, 100);// (width, height)
        setImage("hatch.png");
        this.ticketList = new java.util.ArrayList<>(); //Initialises the list that the order tickets will be added to
        
        //Add the tickets to the list
        ticketList.add(new Ticket("bl"));
        ticketList.add(new Ticket("blt"));

        Collections.shuffle(ticketList); //Shuffles ticketList to randomise its order

        this.listIndex = 0;
        this.currentTicket = ticketList.get(listIndex);
        
    }
    
    
    /**
     * Handles interaction between the player and the hatch.
     * Handles the logic for completing orders and setting the next order.
     * Once there are no more order tickets then isGameCompleted will be set to true - the game will end
     */
    @Override
    protected void onInteraction(Player player) {
        CompletedDish dish = player.getCompletedDish();
        if (dish != null) {
            player.setCompletedDish(null);
            getWorld().removeObject(dish);
            listIndex++; //Increments listIndex to get the next ticket in the list

            if (listIndex < ticketList.size()) {
                getWorld().addObject(new Textbox("YAY! Order complete!\n Time for the next one!"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);

                currentTicket = ticketList.get(listIndex); //Sets currentTicket to the next ticket to be completed
                player.setTicket(currentTicket);
            } else { //All tickets have been completed so game has been won
                currentTicket = null;
                getWorld().addObject(new Textbox("YWell done! You completed the game!"), MyWorld.WORLD_WIDTH/2, MyWorld.WORLD_HEIGHT/2);
                ((MyWorld) getWorld()).timer.stop();
            }
        }
    }
    
    @Override
    public void act(){
    }
}