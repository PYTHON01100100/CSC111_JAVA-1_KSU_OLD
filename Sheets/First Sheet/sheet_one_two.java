//Exercise two, BMI index

public class sheet_one_two
{
   public static void main (String[] args)
   {
      double weight = 55;
      double height = 1.6;
   // height is in meters and weight is in kilograms they are not constants, for they can be changed as needed
      double BMI = weight/(height*height);
   // to take the square of height it has to be multiplied by itself
      System.out.println("the BMI of a person having a weight of 55kg and a height of 160cm is " + BMI + "kg/m^2");
   }
}