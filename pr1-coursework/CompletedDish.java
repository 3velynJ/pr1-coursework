import greenfoot.*;

public class CompletedDish extends Actor{
    
    public CompletedDish(Ticket ticket)
    {
        String orderType = ticket.getType();
        setImage(orderType + ".png");
    }
}
