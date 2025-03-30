import greenfoot.*;

public class CompletedDish extends Actor{
    
    // An actor visulaisation of a completed order/dish. 
    // The plate will instansiate a new CompletedDish once it has all of the correct Ingredients 
    // Only accepted by the Hatch
    public CompletedDish(Ticket ticket)
    {
        String orderType = ticket.getType();
        setImage(orderType + ".png");
    }
}
