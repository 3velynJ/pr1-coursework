import greenfoot.*;

public class Plate extends Workstation
{
    public Plate() {
        setImage("plate.png");
    }
    @Override
    protected void onInteraction(Player player) {
        //player.inventoryIngredient.setLocation(Location.PLATE);
    }
    @Override
    public void act(){
        super.act();
    }
}
