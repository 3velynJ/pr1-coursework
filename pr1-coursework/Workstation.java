import greenfoot.*;
import java.util.List;

public class Workstation extends Obstacle {
    private final int INTERACTION_RANGE = 60;
    private boolean eDown;

    public Workstation(int width, int height) {
        super(width, height);

    }

    public Workstation() {
        super(50, 50);
    }

    public void act() {
        interactWithPlayer();
    }

    // Gets a list of Players in range of the workstation
    // Once a player is in range, and therefore the list is not empty, call interaction on our player, the first player in the list
    protected void interactWithPlayer() {
        List<Player> players = getObjectsInRange(INTERACTION_RANGE, Player.class);
        if (!players.isEmpty()) {
            checkForSingleEDownInteraction(players.get(0));
        }
    }

    protected void onInteraction(Player player) {
        // This method will be overridden by the storage subclass which acts differently to other workstations.
    }

    // Checks for a single press of the 'e' button, calling the onInteraction method with each press
    private void checkForSingleEDownInteraction(Player player){
        if (Greenfoot.isKeyDown("e") && !eDown){
            onInteraction(player);
            eDown = true;
        }
        if (!Greenfoot.isKeyDown("e") && eDown){
            eDown = false;
        }
    }


}
