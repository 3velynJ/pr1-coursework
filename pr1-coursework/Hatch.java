import greenfoot.*;
import java.util.List;
/**
 * A workstation where the player puts the finished sandwich to complete the order
 * 
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
        super(50, 100);
        ticketList = new java.util.ArrayList<>();
        //Add the tickets to the list
        ticketList.add(new Ticket("bl"));
        ticketList.add(new Ticket("blt"));
        listIndex = 0;
        currentTicket = ticketList.get(listIndex);
        messageTimer = new SimpleTimer();
        showMessage=false;
    }
    
    private void showSuccessMessage() {
        if (messageTimer.millisElapsed() < MESSAGE_DURATION) {
            getWorld().showText(MESSAGE, getX(), getY() - 40);
        } else {
            getWorld().showText("", getX(), getY() - 40);
        }
    }
    
    public boolean gameCompleted() {
        return isGameCompleted;
    }

    public void showGameCompleted() {
        World world = getWorld();
        Textbox gameOverTextbox = new Textbox("images/game-completed.png");
        world.addObject(gameOverTextbox, world.getWidth() / 2, world.getHeight() / 2);
    }
    
    //Making use of built in greenfoot method to add the ticket in once 
    //the world has been constructed
    @Override
    protected void addedToWorld(World world) {
        world.addObject(currentTicket, 1250, 300);
    }
    
    @Override
    protected void onInteraction(Player player) {
    
    //This is set to ingredient for testing but will be sandwich for final thing
    if (player.getInventory() instanceof Ingredient) {
        player.setInventory(null);
        player.updateInventoryUI();
        messageTimer.mark();
        getWorld().removeObject(currentTicket);

        listIndex++;
        if (listIndex < ticketList.size()) {
            showMessage = true;
            currentTicket = ticketList.get(listIndex);
            getWorld().addObject(currentTicket, 1250, 300);
        } else {
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
