/**
 * Represents a sandwich which the player recieves when they put the ingredients specified by the ticket into the plate in the right order
 */
public class Sandwich extends Food {
    private String relativeImagePath;
    
    public Sandwich()
    {
        this.relativeImagePath = "images/sandwich.png";
    }
    @Override
    public String getRelativeImagePath() {
        return this.relativeImagePath;
    }
}
