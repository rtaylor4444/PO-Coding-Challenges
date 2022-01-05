package revature.robtaylor;

public class MenuItem {
    private String name;
    //Can only be food or a drink
    private Boolean isFood;
    private int price;
    MenuItem() {
        price = 0;
        isFood = true;
        name = "Empty Item";
    }
    MenuItem(String itemName, Boolean food, int itemPrice) {
        name = itemName;
        isFood = food;
        price = itemPrice;
    }
    int getPrice() { return price; }
    String getName() { return name; }
    Boolean getIsFood() { return isFood;}
}
