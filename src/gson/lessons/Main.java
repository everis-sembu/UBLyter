package gson.lessons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Main {


    public static void main(String [] args){

        //SerialiseRestaurant();
        //DeserialiseRestaurant();
        //SerialiseMyTest();
        DeserialiseMyTest();
    }

    private static void DeserialiseMyTest() {
        String json = "{\"name\":\"Enric\",\"age\":12,\"table\":{\"k1\":{\"id\":\"s1\",\"value\":\"BT-01\",\"type\":\"operand\"},\"k2\":{\"id\":\"s2\",\"value\":\"+\",\"type\":\"operator\"},\"k3\":{\"id\":\"s3\",\"value\":\"BT-10\",\"type\":\"operand\"}}}";
        MyTest test = new Gson().fromJson(json, MyTest.class);
        System.out.println((test.table.get("k1")).value);
        System.out.println(((Symbol) test.table.get("k2")).value);
        System.out.println(((Symbol) test.table.get("k3")).value);
    }

    private static void SerialiseMyTest() {

        Symbol s1 = new Symbol("s1", "BT-01", "operand");
        Symbol s2 = new Symbol("s2", "+", "operator");
        Symbol s3 = new Symbol("s3", "BT-10", "operand");

        HashMap<String, Symbol> table = new HashMap<>();
        table.put("k1", s1);
        table.put("k2", s2);
        table.put("k3", s3);

        MyTest test = new MyTest("Enric", 12, table);

        String json = new Gson().toJson(test);

    }

    private static void DeserialiseRestaurant() {
        //String json ="[{\"name\": \"Christian\", \"flowerCount\": 1}, {\"name\": \"Marcus\", \"flowerCount\": 3}, {\"name\": \"Norman\", \"flowerCount\": 2}]";
        String json = "{\n" +
                "  \"name\": \"MyRestaurant\",\n" +
                "  \"website\": \"http://mywebsite.org\",\n" +
                "  \"founders\": [\n" +
                "    {\"name\": \"Christian\", \"flowerCount\": 1}, {\"name\": \"Marcus\", \"flowerCount\": 3}, {\"name\": \"Norman\", \"flowerCount\": 2}\n" +
                "  ]\n" +
                "}";
        //Founder[] founders = new Gson().fromJson(json, Founder[].class);
        //Type founderListType = new TypeToken<ArrayList<Founder>>(){}.getType();

        GeneralInfo info = new Gson().fromJson(json, GeneralInfo.class);

    }

    private static void SerialiseRestaurant() {

        List<Restaurant.RestaurantMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new Restaurant.RestaurantMenuItem("Steak", 20f));
        menuItems.add(new Restaurant.RestaurantMenuItem("Spaghetti", 30f));
        menuItems.add(new Restaurant.RestaurantMenuItem("Nuddles", 10f));

        Restaurant restaurant = new Restaurant("MyRestaurant", menuItems);

        String json = new Gson().toJson(restaurant);
    }
}
