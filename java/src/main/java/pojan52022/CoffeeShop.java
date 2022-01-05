package revature.robtaylor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import revature.robtaylor.MenuItem;

public class CoffeeShop {
    String name;
    ArrayList<MenuItem> menuItems;
    HashMap<String, MenuItem> menuNamesToItem;
    LinkedList<String> currentOrders;
    ArrayList<String> fulfilledOrders, drinkItems, foodItems;
    int amountDue;
    MenuItem cheapest;
    CoffeeShop() {
        name = "My Coffee Shop";
        amountDue = 0;
        cheapest = null;
        addMenuItem(new MenuItem("Item1", false, 1));
        addMenuItem(new MenuItem("Item2", true, 2));
        addMenuItem(new MenuItem("Item3", false, 3));
        addMenuItem(new MenuItem("Item4", true, 4));
        addMenuItem(new MenuItem("Item5", false, 5));
    }
    private void addMenuItem(MenuItem item) {
        //prevent duplicate items
        if(menuNamesToItem.containsKey(item.getName())) return;
        menuItems.add(item);
        menuNamesToItem.put(item.getName(), item);

        //Keep track of the cheapest item
        if(cheapest == null) cheapest = item;
        else if(cheapest.getPrice() > item.getPrice()) cheapest = item;

        //Keep track of item types
        if(item.getIsFood()) foodItems.add(item.getName());
        else drinkItems.add(item.getName());
    }
    public String addOrder(String itemName) {
        if(!menuNamesToItem.containsKey(itemName)) return "This item is currently unavailable!";
        currentOrders.addLast(itemName);
        return "Item successfully added to order!";
    }
    public String fulfillOrder(String itemName) {
        if(currentOrders.isEmpty()) return "All orders have been fulfilled!";
        for(int i = 0; i < currentOrders.size(); ++i) {
            if(currentOrders.get(i).equals(itemName)) {
                currentOrders.remove(i);
                fulfilledOrders.add(itemName);
                amountDue += menuNamesToItem.get(itemName).getPrice();
                return "The " + itemName + " is ready!";
            }
        }
        return "This item is currently unavailable!";
    }
    public ArrayList<String> listOrders() { return fulfilledOrders; }
    public int dueAmount() { return amountDue; }
    public String cheapestItem() {
        if(cheapest == null) return "There are no items in the menu";
        return cheapest.getName();
    }
    public ArrayList<String> drinksOnly() { return drinkItems; }
    public ArrayList<String> foodOnly() { return foodItems; }
}
