import java.util.Scanner;
public class TestArray{

   static int count = 0; //to count the elements in the array
   static Scanner input = new Scanner(System.in);

   public static void main(String [] args){
      int size = 0; //the user can input 6 but enter 4 elements
      while(!(size <=30 && size > 0)){ //user input validation
         System.out.println("Enter Array size.. maximum is 30");
         size = input.nextInt();
      }
      char chArray [] = new char[size]; //either the user enters until array size is reached or presses '#'
      inputArray(chArray);
      System.out.println("Display Array: ");
      for(int i = 0; i < count; i++){
         System.out.println(chArray[i]);
      }
      System.out.println("Enter a character to display");
      displayArray(chArray, input.next().charAt(0), count);
      char chArray1 [] = reverseArray(chArray, count);
      System.out.println("\nReversed Array:");
      for(int i = 0; i < count; i++)
         System.out.println(chArray1[i]);
      System.out.println("Array in one line");
      displayArray(chArray, count);
   }
   public static int inputArray(char[] list){
      System.out.println("Enter a character or # to exit");
      for(int i = 0; i < list.length; i++){
         char ch = input.next().charAt(0);
         if(ch == '#')
            break;
         list[i] = ch;
         count++;
      }
      return count;
   }
   public static char[] reverseArray(char[] list, int numChars){
      char reverseArray [] = new char[numChars];
      for(int i = numChars-1; i >= 0; i--){ //to deep copy the elements in reverse order
         reverseArray[(count-1)-i] = list[i];
      }
      return reverseArray;
   }
   public static void displayArray(char[]list, int numChars){
      for(int i = 0; i < numChars; i++)
         System.out.print(list[i]);
   }
   public static void displayArray(char[]list, char ch , int numChars){
      for(int i = 0; i < numChars; i++){
         if(list[i] == ch){
            for(int j = 1; j <= i; j++)
               System.out.print(list[i]);
            return;
         }   
      }
      System.out.println("This character does not exist");
   }
}