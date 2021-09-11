public class Reservation {

/* Attributes */
	
   private String inDate;
   private String outDate;
   private char RoomType;
   private String resNum;
   private String resState;
   private double Price;
   public static int resCount = 0;

/* Constructor */
	   
   Reservation(char room,String in, String out,long card){
      RoomType = room;
      inDate = in;
      outDate = out;
      if(verifyCard(card)){
         Price = calculatePrice();
         resNum = generateReservationNumber(); //generates only when the card is valid
      }
      else{
         Price = 0;
         resNum = "####";
      }
      resCount++;
   }


/* Setters */
	  
   void setRoom(char r){
      RoomType = r;
   }
	   
   void setPrice(double p){
      Price = p;
   }
	   
	      
/* Getters */
	   
   String getinDate(){
      return inDate;
   }
	   
   String getoutDate(){
      return outDate;
   }
	   
   char getRoomType(){
      return RoomType;
   }
	  
   String getresNum(){
      return resNum;
   }
	   
   String getresState(){
      return resState;
   }
	  
   double getPrice(){
      return Price;
   }


/* Methods */
	   
   boolean verifyCard(long l){
      /* we went with the explanation provided in the project file,
      *  even though the table was contrary to it
      */ 
      String c = l+"" ;
      int sum = 0;
      if(c.length()==10){//validating if it's a 10 digit number
         for (int i = c.length()-1; i >= 0; i--){ //to start from the rightmost digit
            int n = Integer.parseInt(c.charAt(i)+"");
            if (i%2==0) //even index will get doubled 
               n *= 2;
            if (n >= 10)
               n = (n-9);
            sum += n;
         }
         if(sum % 10 == 0){
            resState = "Confirmed";
            return true;
            }
         else 
            resState = "Unconfirmed";
      }
      else //if the length is not 10 it won't be valid
         resState = "Unconfirmed";
      return false;
   }
	   
   double calculatePrice(){
      double p = 0;
      switch (Character.toUpperCase(RoomType)){
         case 'S': p = 150*stayDuration(); 
            return p;
         case 'T': p = 220*stayDuration(); 
            return p;
         case 'F': p = 400*stayDuration(); 
            return p;
      }
      return p;
   }
	   
   String generateReservationNumber(){
      String str = "";
      str = resCount+"";
      str += (char)(((int)(Math.random()*26)+97))+"";
      str += (char)(((int)(Math.random()*10)+48))+"";
      str += (char)(((int)(Math.random()*10)+48))+"";
      str += (char)(((int)(Math.random()*26)+65))+"";
      return str;
   }
	   
   boolean cancelReservation(){
      boolean status = false;
      if(resState.equals("Canceled"))
         System.out.println("Your reservation has already been canceled");
      else{
         resState = "Canceled";
         status = true;
      }
      return status;
   }
	   
   void print(){ 
      String str = "";
      switch(Character.toUpperCase(RoomType)){
         case 'S': str = "Single"; 
            break;
         case 'T': str = "Twin"; 
            break;
         case 'F': str = "Family"; 
            break;
      }
      System.out.printf("Reservation Number: %-12sReservation Status: %s%nRoom Type: %-21sCheck In Date: %s%nPrice: %-12.2f%n",
          resNum, resState, str, inDate, Price);
   }

	   
/* Helper Methods */
	   
   private double stayDuration(){
      int x,y;
      x = Integer.parseInt(inDate.substring(0,inDate.indexOf('-')));
      y = Integer.parseInt(outDate.substring(0,outDate.indexOf('-')));
      return y-x;
   }
	   
   int getDay(){
      return Integer.parseInt(inDate.substring(0,inDate.indexOf('-')));
   }
  
   int getMonth(){
      return Integer.parseInt(inDate.substring(inDate.indexOf('-')+1));
   }

}
