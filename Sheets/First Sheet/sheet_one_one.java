/*Exercise one, a program that calculates and prints
the number of minutes in a year */

public class sheet_one_one 
{
   public static void main (String[] args)
   {
      int year = 365;
   // 365 days are approximately in a year
      final int days = 24;
   // 24 hours are in a day
      final int minutes = 60;
   // 60 minutes are in an hour
      int minutes_in_year = year*days*minutes;
      System.out.println("there are " + minutes_in_year + " minutes in a year!");
   }
}
