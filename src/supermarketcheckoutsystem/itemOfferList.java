package supermarketcheckoutsystem;

import java.util.*;

// Map to hold items which have offer on them and the offer details
public class itemOfferList {
    public static TreeMap<String, itemOffer> itemOfferMap = new TreeMap<String, itemOffer>();

    static{
        itemOfferMap.put("A", new itemOffer("A", 3, 130.0));
        itemOfferMap.put("B", new itemOffer("B", 2, 45.0));
    }


}
