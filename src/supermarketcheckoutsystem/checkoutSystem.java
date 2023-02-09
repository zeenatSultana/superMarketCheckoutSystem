package supermarketcheckoutsystem;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import static supermarketcheckoutsystem.itemPriceList.itemPriceMap;


public class checkoutSystem {
    public static TreeMap<String, Integer> itemsListMap = new TreeMap<String, Integer>();

    // Method to add item to the existing cart
    public static void addItem(String item, Integer quantity){
        //If entered item is not there in the itemList
//        if (!itemPriceMap.containsKey(item))
//            System.out.println("Please enter valid item from List");

        // If the item does not exist in the cart then add it
        if(!itemsListMap.containsKey(item))
            itemsListMap.put(item, quantity);
        else
        {
            // if the cart already contains the item then just update
            // the amount by adding the new quantity to old one
            itemsListMap.put(item, quantity + itemsListMap.get(item));
        }
    }


    // Method to remove items along with their quantities from the existing cart
    public static void removeItem(String item, Integer quantity) throws Exception{
        // If the item is not in the cart then throw exception
        if(!itemsListMap.containsKey(item))
            throw new Exception("No such item in your cart");

        // If the item's quantity to be removed is equal to the existing quantity
        // of the item then remove the item from the cart or else update the quantity
        // of the item in the cart. If the quantity to be removed is more than what's
        // existing in the cart then throw exception as well.
        if(itemsListMap.get(item) == quantity)
            itemsListMap.remove(item);
        else if(itemsListMap.get(item) > quantity)
            itemsListMap.put(item, itemsListMap.get(item) - quantity);
        else
            throw new Exception("Quantity for the provided iem is more than the quantity in the cart");
    }


    // Method to preview the content of the cart and all items in it
    public static void reviewCart() throws Exception
    {
        if(itemsListMap.isEmpty())
            throw new Exception("Your cart is empty");

        // Iterate through the cart and display the items with their quantities
        Set<String> allItemsInCart = itemsListMap.keySet();
        for(Iterator<String> i = allItemsInCart.iterator(); i.hasNext();){
            String item = i.next();
            Integer quantity = itemsListMap.get(item);
            System.out.println("Item: "+ item + " of Quantity: " + quantity);
        }
    }


    // Method to empty the cart
    public static void emptyCart(){
        itemsListMap.clear();
    }


    // Method to calculate all total price based on the contents of the cart
    public static double calculateTotalPrice(TreeMap<String, Integer> itemsListMap){
        Double total = 0.0;
        //Double totalWithoutOffer = 0.0;
        //Double savedAmount = 0.0;

        // Iterate through the cart and calculate the total value of each item and then add the total
        Set<String> keys = itemsListMap.keySet();
        for (Iterator<String> i = keys.iterator(); i.hasNext();) {
            String item = i.next();
            Integer quantity = itemsListMap.get(item);

            // If there is an offer on this item then process the price accordingly
            if(itemOfferList.itemOfferMap.containsKey(item)){
                itemOffer thisOffer = (itemOffer)itemOfferList.itemOfferMap.get(item);

                // If the quantity of the item in the cart is more than offer quantity
                // then process the items and their price accordingly
                if(thisOffer.quantity < quantity)
                {
                    //totalWithoutOffer += (quantity)*itemPriceList.itemPriceMap.get(item);
                    total += (quantity % thisOffer.quantity)* itemPriceMap.get(item) + (quantity / thisOffer.quantity) * thisOffer.price;
                    System.out.println("Offer price applied for " + item);
                    //savedAmount += totalWithoutOffer - total;
                    //System.out.println("You've saved " + savedAmount);
                }
                else if(thisOffer.quantity == quantity)
                {
                    //totalWithoutOffer += (quantity)*itemPriceList.itemPriceMap.get(item);
                    total += thisOffer.price;
                    System.out.println("Offer price applied for " + item);
                    //savedAmount += totalWithoutOffer - total;
                    //System.out.println("You've saved " + savedAmount);
                }
                else
                {
                    total += (quantity)* itemPriceMap.get(item);
                }
            }
            else // If there is no offer on the item then just fetch the price from the price map and calculate the total
            {
                total += (quantity)* itemPriceMap.get(item);
            }
        }
        total = total/100;
        return total;
    }
}