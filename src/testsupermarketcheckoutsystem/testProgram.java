package testsupermarketcheckoutsystem;

import supermarketcheckoutsystem.*;

public class testProgram {
    public static void main(String[] args){
        // Test to check if the price calculation is correct or not.
        // For 4quantities of A, 1 quantity of item B and 4 quantities of item C
        // the total price should be 320.0. Test to check this.
        checkoutSystem ck = new checkoutSystem();
        ck.addItem("A", 4);
        ck.addItem("B", 1);
        ck.addItem("C", 4);
        if(ck.calculateTotalPrice(ck.itemsListMap) == 290.0) System.out.println("Passed");
        else System.out.println("Failed");

        // For 1 quantity of item B and 4 quantities of item C
        // the total price should be 110.0. Test to check this.
        try {
            ck.removeItem("A", 4);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(ck.calculateTotalPrice(ck.itemsListMap) == 110.0) System.out.println("Passed");
        else System.out.println("Failed");

    }
}
