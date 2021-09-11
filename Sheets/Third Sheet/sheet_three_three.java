import java.util.Scanner;
public class sheet_three_three {
   public static Scanner input = new Scanner(System.in);
   public static void main(String args[]) {
      System.out.print("enter a statement to convert --> ");
      String str = input.nextLine();
      for(int i=0;i<str.length();i++) //iterates each index
      {
         String compare = str.substring(i,i+1); //goes through each letter to check wether it's a vowel or not
         switch (compare){ // if compare is a vowel it will print it 
            case "a":case "A":
               System.out.print("a");
               break;
            case "e":case "E":
               System.out.print("e");
               break;
            case "i":case "I":
               System.out.print("i");
               break;
            case "o":case "O":
               System.out.print("o");
               break;
            case "u":case "U":
               System.out.print("u");
               break;
            case " ":
               System.out.print(" ");
            default: // otherwise it will replace it with an asterisk
               System.out.print("*");
         }
      }}}