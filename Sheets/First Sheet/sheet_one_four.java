// Exercise four, a 10 percent discount
public class sheet_one_four 
{
   public static void main (String[] args)
   {
      double discount = 0.1; // the discount is not constant, it can be changed as needed
      double purchase = 69.5;
     /*price after discount would be the purchase -(0.1*purchase)
     an easier way of doing so is to multiply the purchase by 0.9 */
      double discounted_purchase = purchase*(1 - discount);
      System.out.println("the final price after a 10 percent discount is " + discounted_purchase);
   }
}