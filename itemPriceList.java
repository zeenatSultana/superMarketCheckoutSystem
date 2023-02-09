package supermarketcheckoutsystem;
import java.util.*;

// Map to hold price of individual item
public class itemPriceList {
    public static TreeMap<String, Double> itemPriceMap = new TreeMap<String, Double>();

    static{
        itemPriceMap.put("A", 50.0);
        itemPriceMap.put("B", 30.0);
        itemPriceMap.put("C", 20.0);
        itemPriceMap.put("D", 15.0);
    }
}
