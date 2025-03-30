import greenfoot.*;

public class PrepArea extends Workstation {
    private Ingredient currentIngredient; 
    private Location myLocation;
    private String name;
    private final int xCoOrd;
    private final int yCoOrd;
    private final int BAR_OFFSET = -25;

    public PrepArea(Location location, int x, int y) {
        // Set the enum location of this prep area so that it can try to set the Ingredient's location to match
        this.myLocation = location;
        this.name = location.locationText;
        this.xCoOrd = x;
        this.yCoOrd = y;
        setImage(name + ".png");
    }
  
    @Override
    protected void onInteraction(Player player) {
        if (player.getCompletedDish() != null) {
            // If the player is holding a completed dish, display error message re directing
            // them to the hatch
            getWorld().addObject(new Textbox(
                    "Uh Oh! Please take this dish to the hatch"),
                    MyWorld.WORLD_WIDTH / 2, MyWorld.WORLD_HEIGHT / 2);
        } else {
            Ingredient playerIngredient = player.getInventoryIngredient();
            // If the player has an ingredient in the inventory and there isn't already an
            // ingredient on this prep area, then try set the Ingredient's enum location to
            // the prep area
            if (playerIngredient != null && currentIngredient == null) {
                // If the enum location of the Ingredient was sucessfully set to that of this
                // prep area, place the Ingredient on the prep area
                if (playerIngredient.setIngredientLocation(myLocation)) {
                    currentIngredient = player.useInventoryIngredient();
                    currentIngredient.setLocation(xCoOrd, yCoOrd);
                    ProgressBar bar = currentIngredient.getProgressBar();
                    getWorld().addObject(bar,xCoOrd,yCoOrd + BAR_OFFSET);
                }
            }
            // If the player's inventory is empty but the prep area has an ingredient, move
            // the ingredient into the inventory on interaction
            else if (playerIngredient == null && currentIngredient != null) {
                player.storeInventoryIngredient(currentIngredient);
                currentIngredient = null;
            }
            // If the player has an ingredient in the inventory but there is already an
            // ingredient on this prep area, display error message
            else if (playerIngredient != null && currentIngredient != null) {
                getWorld().addObject(new Textbox(
                        "Uh Oh! You can't put this ingredient here.\nThere is already an ingredient on the " + name),
                        MyWorld.WORLD_WIDTH / 2, MyWorld.WORLD_HEIGHT / 2);

            }
        }
    }
}