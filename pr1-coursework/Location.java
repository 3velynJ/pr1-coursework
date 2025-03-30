// Enum class for Ingredient and Step Locations
// Workstations will set the enum locations of ingredients, allowing the ingredient to calculate what needs doing   
// Text strings are associated with each Enum so that error messages displayed to the user can referer to locations in words
// Text strings are also used by the PrepArea to find and display the correct image for its type

public enum Location {
    INVENTORY("inventory"),CHOPPING_BOARD("chopping-board"),HOB("hob"),OVEN("oven"),PLATE("plate");
    public String locationText;

    Location(String valueString){
        this.locationText = valueString;
    }
}