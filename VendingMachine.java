package vendingmachine;
import java.util.Scanner;
public class VendingMachine {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int PotatoChips = 3;
        int Cookies = 0;
        int Candies = 2;
        // Price is in pennies
        double price = 0;
        float item = 1;
        
        while (choice < 1 || choice > 3 || item == 0){
            
                System.out.println("What would you like to have?\n"
                        + "1. Potato Chips \t $1.25\n"
                        + "2. Cookies \t $0.85\n"
                        + "3. Candies \t $ 0.95");       
                choice = in.nextInt();
                //Displaying price & validation of item
                switch (choice) {
                    case 1:
                        item = PotatoChips;
                        price = 125;
                        break;
                    case 2:
                        item = Cookies;
                        price = 85;
                        break;
                    case 3:
                        item = Candies;
                        price = 95;
                        break;
                    default:
                        System.out.println("Please enter a valid option!");
                        break;    
                    }
                if (item == 0) {
                    System.out.println("Sorry! The item chosen is sold out.\n"
                       + "Please select a different item.");
                }          
        }
        System.out.println("Please insert $" + price/100);     
   
        //Insert money
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        double total = 0;
        System.out.println("Please enter amount of");
        
        do {
        System.out.print("quarters: ");
        quarters = quarters + (in.nextInt() * 25);
        System.out.print("dimes: ");
        dimes = dimes + (in.nextInt() * 10);
        System.out.print("nickles: ");
        nickles = nickles + (in.nextInt() * 5);
        total = quarters + dimes + nickles;
        
        System.out.print("You have inserted $");
        System.out.println(total/100);
        if (total < price){
            System.out.println("Insufficient amount entered.\n"
                   + "Please add more money");
            }
        } while (total < price);
        
   
        if (total == price){
           System.out.println("Please collect your snack.\n"
                   + "Thank you!");
           item--;
        }
        else if (total > price) {
            //Collect item and change
            int change = (int)(total - price);
            int quartersOut = (change/25);
            int dimesOut = ((change%25)/10);
            int nicklesOut = (((change%25)%10)/5);
            System.out.println("Please collect your snack.\n"
                   + "Thank you!");
            item--;
            System.out.println("Your change is " + quartersOut + " quarter(s), " + dimesOut + " dime(s) and " + nicklesOut + " nickle(s)." );
        }
    }
}