import greenfoot.*;
import java.util.List;

/**
 * A class that defines a generic workstation
 */
public class Workstation extends Obstacle {
    private final int INTERACTION_RANGE = 60;
   public Workstation(int width, int height) {
       super(width, height); //Allows for a workstaion object to be a custom width and height
   }

   public Workstation() {
        super(50, 50); //Default 50 width and 50 height 
    }

   public void act() {
        interactWithPlayer();
    }

    /**
     * Allows the player to interact with workstations by pressing E
     */
    protected void interactWithPlayer() {
        if (!(getObjectsInRange(INTERACTION_RANGE, Player.class).isEmpty())) {
            List<Player> players = getObjectsInRange(INTERACTION_RANGE, Player.class);
           if (Greenfoot.isKeyDown("E")) {
                onInteraction(players.get(0));
            }
        }   
    }
   
   /**
     *  This method is called when a player interacts with the workstation
     */ 
   protected void onInteraction(Player player) {
       // This method is overridden by subclasses to define specific interaction behaviours  
     }
}
