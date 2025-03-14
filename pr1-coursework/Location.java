public enum Location {
    STORAGE("storage"),HAND("hand"),CHOPPING_BOARD("chopping board"),HOB("hob"),OVEN("oven"),PLATE("plate");
    public String locationText;

    Location(String valueString){
        this.locationText = valueString;
    }
}
