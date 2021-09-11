import java.util.Scanner;
public class sheet_three_two {
   public static Scanner input = new Scanner(System.in);
   public static void main(String args[]) {
      int num,sum=0, divisor, average=0; //average is usually a double, for this program it will be an integer
      System.out.println("enter the number of integers you would like to calculate -->");
      divisor = input.nextInt();
      for(int i=1;i<=divisor;i++){
         System.out.println("enter an integer -->");
         num = input.nextInt();
         if(num>0) //checks if the value entered is positive
            sum+=num;
         else{ // if the value is negative or zero the iteration will skip it
            i--;
            continue;
         }}
      average = sum/divisor;
      System.out.print("the average of the " +divisor+ " numbers you entered is "+average);
   }}