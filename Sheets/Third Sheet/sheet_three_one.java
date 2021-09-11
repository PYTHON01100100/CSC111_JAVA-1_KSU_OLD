import java.util.Scanner;
public class sheet_three_one {
   public static Scanner input = new Scanner(System.in);
   public static void main(String args[]) {
      int num; //number will be read from the user
      System.out.println("enter your five numbers --> ");
      for(int i=1;i<=5;i++){//iterates each number until the fifth one 
         num=input.nextInt();
         for(int j=1;j<=num;j++){ //iterates each asterisk (num) times
            System.out.print('*');
         }
         System.out.println();
      }
   }}