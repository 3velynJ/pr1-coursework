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
    private SimpleTimer messageTimer;
    private final String MESSAGE = "Order Complete!";
    private final int MESSAGE_DURATION = 3000;
    private boolean showMessage;
    private boolean isGameCompleted = false;
    
    public Hatch() {
        super(50, 100);// (width, height)
        ticketList = new java.util.ArrayList<>(); //Initialises the list that the order tickets will be added to
        
        //Add the tickets to the list
        ticketList.add(new Ticket("bl"));
        ticketList.add(new Ticket("blt"));

        Collections.shuffle(ticketList); //Shuffles ticketList to randomise its order

        listIndex = 0;
        currentTicket = ticketList.get(listIndex);
        
        messageTimer = new SimpleTimer();
        showMessage = false;
    }
    
    /**
     * A method that is called to display a success mesasage when a order is completed
     */
    private void showSuccessMessage() {
        if (messageTimer.millisElapsed() < MESSAGE_DURATION) {
            getWorld().showText(MESSAGE, getX(), getY() - 40);
        } else {
            getWorld().showText("", getX(), getY() - 40);
            showMessage = false;
        }
    }
    
    /**
     * Method to check if the game has been completed
     */
    public boolean gameCompleted() {
        return isGameCompleted;
    }
    
    /**
     * Shows the game completed textbox
     */
    public void showGameCompleted() {
        World world = getWorld();
        Textbox gameOverTextbox = new Textbox("images/game-completed.png");
        world.addObject(gameOverTextbox, world.getWidth() / 2, world.getHeight() / 2);
    }
    
    /**
     * Uses a built in greenfoot method to add the first ticket into the world it has been constructed
     */
    @Override
    protected void addedToWorld(World world) {
        world.addObject(currentTicket, 1250, 300);
    }
    
    /**
     * Handles interaction between the player and the hatch.
     * Handles the logic for completing orders and setting the next order.
     * Once there are no more order tickets then isGameCompleted will be set to true - the game will end
     */
    @Override
    protected void onInteraction(Player player) {
        if (player.getInventory() instanceof Sandwich) {
            player.setInventory(null);
            player.updateInventoryUI();
            messageTimer.mark();
            getWorld().removeObject(currentTicket);

            listIndex++; //Increments listIndex to get the next ticket in the list
            if (listIndex < ticketList.size()) {
                showMessage = true;
                currentTicket = ticketList.get(listIndex); //Sets currentTicket to the next ticket to be completed
                getWorld().addObject(currentTicket, 1250, 300);
            } else { //All tickets have been comnpleted
                currentTicket = null;
                isGameCompleted = true; 
            }
        }
    }
    
    @Override
    public void act(){
        super.act();
        if (showMessage){
            showSuccessMessage();
        }
    }
}
