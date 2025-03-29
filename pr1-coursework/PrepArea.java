public class PrepArea extends Workstation {
    private Ingredient currentIngredient; 
    private Location myLocation;
    private String name;
    private final int xCoOrd;
    private final int yCoOrd;

    public PrepArea(Location location, int x, int y) {
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
            // the hob
            if (playerIngredient != null && currentIngredient == null) {
                currentIngredient = player.useInventoryIngredient();
                // If the enum location of the Ingredient was sucessfully set to that of this
                // prep area, place the Ingredient on the prep area
                if (currentIngredient.setIngredientLocation(myLocation)) {
                    currentIngredient.setLocation(xCoOrd, yCoOrd);
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

    @Override
    public void act(){
        super.act();
    }
}