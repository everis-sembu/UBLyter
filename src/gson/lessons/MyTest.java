package gson.lessons;


import java.util.HashMap;

public class MyTest {


    String name;
    int age;
    HashMap<String, Symbol> table;


    public MyTest(String name, int age, HashMap<String, Symbol> table) {
        this.name = name;
        this.age = age;
        this.table = table;
    }
}
