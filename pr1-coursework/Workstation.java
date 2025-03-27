import greenfoot.*;
import java.util.List;

/**
 * A class that defines a generic workstation
 */
public class Workstation extends Obstacle {
    private final int INTERACTION_RANGE = 60;
   public Workstation(int width, int height) {
       super(width, height);
   }

   public Workstation() {
        super(50, 50);
    }

   public void act() {
        interactWithPlayer();
    }

    protected void interactWithPlayer() {
        if (!(getObjectsInRange(INTERACTION_RANGE, Player.class).isEmpty())) {
            List<Player> players = getObjectsInRange(INTERACTION_RANGE, Player.class);
           if (Greenfoot.isKeyDown("E")) {
                onInteraction(players.get(0));
            }
        }   
    }

   protected void onInteraction(Player player) {
       // This method is overridden by subclasses
     }
}
