package supermarketcheckoutsystem;
import java.util.Scanner;

import static java.lang.System.exit;
import static supermarketcheckoutsystem.checkoutSystem.itemsListMap;
import static supermarketcheckoutsystem.itemPriceList.itemPriceMap;


public class mainProgram {
    public static void main(String[] args) {
        checkoutSystem ck = new checkoutSystem();

        // When the cart is empty check the contents
        // This should throw an exception because the cart is empty
        try {
            ck.reviewCart();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
        }
        // Menu to demonstrate the system
        int option = 0;
        while (option != 6) {
            option = showMenu();
            switch (option) {
                case 1:
                    Scanner scan= new Scanner (System.in);
                    int quantity[]=new int[3];
                    String name[]=new String[3];
                    int i = 0;

                    //do while loop to continue entering items until quantity is 0
                    do {
                        System.out.println("Select item from List :" + "\n"
                                            + "A   unit-price 50p   offer-price 3 for 130p" + "\n"
                                            + "B   unit-price 30p   offer-price 2 for 45p" + "\n"
                                            + "C   unit-price 20p   offer-price no Offer" + "\n"
                                            + "D   unit-price 15p   offer-price no Offer" + "\n");

                        name[i] = scan.next();
                        if(itemPriceMap.containsKey(name[i])) {
                            System.out.println("Enter quantity of item, ");
                            quantity[i] = scan.nextInt();
                            ck.addItem(name[i], quantity[i]);
                            reviewMyCartAndHandleException(ck);
                            i++;
                        }
                        else {
                            System.out.println("Please enter valid item from List");
                        }
                    }while(quantity[i]!=0);
                    break;
                case 2:
                    Scanner scan1= new Scanner (System.in);
                    int itemQuantity[]=new int[3];
                    String itemName[]=new String[3];
                    int j = 0;

                    do {
                        System.out.println("Enter name of item to be removed");
                        itemName[j] = scan1.next();
                        System.out.println("Enter quantity to be removed ");
                        itemQuantity[j] = scan1.nextInt();
                        try {
                            ck.removeItem(itemName[j], itemQuantity[j]);
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            System.out.println(e1.toString());
                        }
                        reviewMyCartAndHandleException(ck);
                        }while(itemQuantity[j]==0);
                        break;
                case 3:
                    reviewMyCartAndHandleException(ck);
                    break;
                case 4:
                    ck.emptyCart();
                    reviewMyCartAndHandleException(ck);
                case 5:
                    try {
                        ck.reviewCart();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        System.out.println(e.toString());
                    }
                    if(!itemsListMap.isEmpty()) {
                        Double totalPrice8 = ck.calculateTotalPrice(itemsListMap);
                        System.out.println("Total Amount to be Paid: £" + totalPrice8);
                        System.out.println(".........please wait, Payment is being processed");
                        System.out.println("");
                        System.out.println("You have Paid: £" + totalPrice8);
                        System.out.println("Thank you for shopping");
                    }
                    break;
                case 6:
                    exit(0);
                    break;

                default:
                    System.out.println("Sorry, please enter valid input");
            }
            //option = showMenu();
        }

    }

    public static int showMenu() {

        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nMenu:");
        System.out.println("-------------------------------------");

        System.out.println("1. Add item(s)");
        System.out.println("2. Remove item(s)");
        System.out.println("3. View cart");
        System.out.println("4. Empty my cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");

        System.out.println("--------------");
        System.out.println("Enter your choice:");

        try {
            option = keyboard.nextInt();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
        }

        return option;

    }

    public static void reviewMyCartAndHandleException(checkoutSystem ck){
        try {
            ck.reviewCart();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
        }
        Double totalPrice = ck.calculateTotalPrice(itemsListMap);
        System.out.println("Total Price: £" + totalPrice);
    }
}