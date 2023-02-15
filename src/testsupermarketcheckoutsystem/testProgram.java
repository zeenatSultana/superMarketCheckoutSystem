package testsupermarketcheckoutsystem;

import supermarketcheckoutsystem.*;

public class testProgram {
    public static void main(String[] args){
        // Test to check if the price calculation is correct or not.
        // For 4quantities of A, 1 quantity of item B and 4 quantities of item C
        // the total price should be 290.0 pence that is £ 2.9. Test to check this.
        checkoutSystem ck = new checkoutSystem();
        ck.addItem("A", 4);
        ck.addItem("B", 1);
        ck.addItem("C", 4);
        if(ck.calculateTotalPrice(ck.itemsListMap) == 2.9) System.out.println("Passed");
        else System.out.println("Failed");

        // For 1 quantity of item B and 4 quantities of item C
        // the total price should be 110.0 pence that is £ 1.1. Test to check this.
        try {
            ck.removeItem("A", 4);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); //Prints this throwable and its backtrace to the specified print stream.
        }
        if(ck.calculateTotalPrice(ck.itemsListMap) == 1.1) System.out.println("Passed");
        else System.out.println("Failed");

    }
}
