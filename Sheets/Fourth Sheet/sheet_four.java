import java.util.*;
public class sheet_four{
   public static void main(String [] args){
      Scanner input = new Scanner(System.in);
      String name, membership; String passenger_class; double bag_weight;   
      System.out.println("Please enter your full name: ");
      name = input.nextLine();
      System.out.println("Please enter your membership number: ");
      membership = input.nextLine();
      while(!(isValidMembership(membership))) { // if the input is invalid it will ask the user to reenter until it is validated
         System.out.println("Wrong membership number, enter again :");
         membership = input.nextLine();
      }
      System.out.println("Please enter your class: ");
      passenger_class = input.nextLine();
      while(!isValidClass(passenger_class)) { // if the input is invalid it will ask the user to reenter until it is validated
         System.out.println("Wrong passenger class, enter again :");
         passenger_class = input.nextLine();
      }
      System.out.println("Please enter your bag weight: ");
      bag_weight = input.nextDouble();
      printBill(name,membership,passenger_class.charAt(0),calculate(passenger_class,bag_weight)); // calls the methods print bill and calculate to print the bill     
   } //end of main
   
   public static double calculate(String x, double y){
      double amount = 0;
      switch (Character.toUpperCase(x.charAt(0))){ 
         case 'F':
            if (y > 50){
               amount = calculate(y); // if the weight is > 50 it will call another method to calculate the amount
            }
            else{
               amount = (y-30)*10;
            }
            break;
         case 'B':
            amount = (y-25)*10;
            break;
         case 'E':
            amount = (y-20)*10;
            break;
         default:
      }
      if (amount < 0) // for the case that the user enters a value less than or equal to the limit it will be free of charge hence, the amount is zero
         amount = 0;
      return amount;
   }//end of calculate
   
   public static double calculate(double y){
      double amount = ((y-30)*10)*0.95;
      return amount;
   }//end of calculate
   
   public static void printBill(String str, String str2, char x, double y1){
      System.out.printf("*********SAUDIA AIRLINES*********%nPassenger name: %s%nMembership: %s%nClass: %c%nTotal charge: %.1f",capitalize(str),str2,x, y1 );
   }//end of printBill

   public static String capitalize(String str){
      String a = Character.toUpperCase(str.charAt(0))+"";
      String str1 = a.concat(str.substring(1,str.indexOf(' ')));
      String b = str.substring((str.indexOf(' ')+1),str.indexOf(' ')+2).toUpperCase();
      String str2 = b.concat(str.substring((str.indexOf(' ')+2)));
      String str3 = str1+" " +str2;
      return str3; 
   }//end of capitalize
 
   public static boolean isValidMembership(String str){
      boolean is_valid = false; 
      if (str.length() == 5){ // tests if the length is = 5 
         if (str.charAt(0) >= 65 && str.charAt(0)<=90){ //tests if the character is capital using ascii unicode for capital letters, we can use Character.isUppeddrCase() also
            for (int i = 1; i < str.length(); i++){ // tests each character after the first if its a digit or not
               if (Character.isDigit(str.charAt(i)))
                  is_valid = true;
               else {
                  is_valid = false;
                  break; // if one of them happens to be false it will exist the loop
               }}}}
      return is_valid;         
   }//end of isValidMembership
   
   public static boolean isValidClass(String x){
      switch(Character.toUpperCase(x.charAt(0))){
         case 'F':
         case 'B':
         case 'E':
            return true;
         default:
            return false;
      }
   }//end of isValidClass
}//end of class