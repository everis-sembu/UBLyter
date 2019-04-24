package gson.lessons;

import java.util.List;

public class Restaurant {

    String name;
    List<RestaurantMenuItem> items;

    public Restaurant(String name, List<RestaurantMenuItem> items) {
        this.name = name;
        this.items = items;
    }


    public static class RestaurantMenuItem {

        String name;
        float price;

        public RestaurantMenuItem(String itemName, float price){
            this.name  = itemName;
            this.price = price;
        }
    }

}
