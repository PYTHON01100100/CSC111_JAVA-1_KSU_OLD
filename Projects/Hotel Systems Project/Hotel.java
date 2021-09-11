import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.* ; 

public class Hotel {
	
/* Attributes */
   static Scanner sc = new Scanner (System.in); 
   static final int MAX_SIZE = 100 ;
   static Reservation[] rList= new Reservation [MAX_SIZE]; 

/* Main */
   public static void main (String[] args){
      String typeOfUser ;
      do{
         System.out.println("Welcome to Hotel system, please select your option (guest or clerk) or END to end the program") ;
         typeOfUser = sc.next();
         if (!typeOfUser.toUpperCase().equals("END"))
            logIn(typeOfUser);
      }
         while (!typeOfUser.toUpperCase().equals("END"));
   }
	
	   
/* Methods */
   public static void logIn (String typeOfUser){
      int option;
      typeOfUser = typeOfUser.toLowerCase();
      if(typeOfUser.equals("guest")){
         System.out.println("Guest Menu\nYou have the following options\nAdd Reservation");
         if (AddReservation()){
            System.out.println("Reservation added succefully.. you can perform the following opertaions on your reservation");
            do{
               System.out.println("1-Cancel Reservation\n2-Display Reservation\n3-Exit\nEnter your option.");
               option = sc.nextInt() ;
               switch(option){
                  case 1 :System.out.println("Cancel Reservation"); CancelMyReservation(); 
                     continue;
                  case 2 :System.out.println("Display Reservation"); DisplayMyReservation(); 
                     continue;
                  case 3 : System.out.println("Exit"); 
                     break;
                  default: System.out.println("Enter the correct data please.");
               }
            }
              while(option!=3);
         }
      }
          
      if(typeOfUser.equals("clerk")){
         do{
            System.out.println("Clerk Menu\nYou have the following options\n1- Find reservation\n2- Display all Confirmed reservations\n3- Modify reservation\n4- Cancel reservation\n5- Count the number of reservations\n6- Display all due reservations\n7- Exit\nEnter your option") ;
            option = sc.nextInt() ;
            switch (option){
               case 1 : System.out.println("Find reservation\nEnter reservation number");
                  int index = Find(sc.next()) ;
                  if(index!=-1)
                     System.out.println("Index of reservation is "+ index );
                  else
                     System.out.println("Reservation doesn't exist");
                  continue;
               case 2 :System.out.println("Display all Confirmed reservations"); Display();
                  continue ;
               case 3 :System.out.println("Modify reservation\nEnter reservation number");
                  if (Modify(sc.next()))
                     System.out.println("reservation is found and updated");
                  else
                     System.out.println("reservation is not found and failed to update");
                  continue ;
               case 4 :System.out.println("Cancel reservation\nEnter reservation number");
                  if(Cancel(sc.next()))
                     System.out.println("reservation is found and updated");
                  else
                     System.out.println("reservation is not found and failed to update");
                  continue ;
               case 5 :System.out.println("Count the number of reservations\nSelect a reservation status");
                  System.out.println("total number of the selected reservation status is "+ CountReservations(sc.next()));
                  continue ;
               case 6 :System.out.println("Display all due reservations"); DisplayDueReservations();
               case 7 :System.out.println("Exit"); 
                  break;
               default: System.out.println("Enter the correct data please.");
            }
         }
           while(option!=7);
      }
   }
	   
	   
   public static boolean AddReservation(){
      boolean done ; 
      if(Reservation.resCount != MAX_SIZE) {//if array is full returns false
         System.out.println("Enter your reservation information");
         System.out.println("Enter your room type (S single, T twin, F family): ");
         char roomtype = Character.toUpperCase(sc.next().charAt(0));
         while(!(roomtype == 'S' || roomtype == 'F' || roomtype == 'T')){ //user input validation
            System.out.println("Please enter a correct room type.");
            roomtype = Character.toUpperCase(sc.next().charAt(0));
         }
         System.out.println("Enter your credit card number: "); 
         long c = sc.nextLong();
         System.out.println("Enter your check in date (in the format DD-MM): ");
         String checkin = sc.next();
         int inday = Integer.parseInt(checkin.substring(0,checkin.indexOf('-')));
         int inmonth = Integer.parseInt(checkin.substring(checkin.indexOf('-')+1));
         while(!(inday > 0 && inday < 32 && inmonth < 13 && inmonth > 0)){ //user input validation
            System.out.println("Please enter a correct date.");
            checkin = sc.next();
            inday = Integer.parseInt(checkin.substring(0,checkin.indexOf('-')));
            inmonth = Integer.parseInt(checkin.substring(checkin.indexOf('-')+1));
         }
         System.out.println("Enter your check out date (in the format DD-MM): ");
         String checkout = sc.next();
         int outday = Integer.parseInt(checkout.substring(0, checkout.indexOf('-')));
         int outmonth = Integer.parseInt(checkout.substring(checkout.indexOf('-')+1));
         while(!(outday > 0 && outday < 32 && outmonth < 13 && outmonth > 0 && inday < outday)){ //user input validation
            System.out.println("Please enter a correct checkout date.");
            checkout = sc.next();
            outday = Integer.parseInt(checkout.substring(0, checkout.indexOf('-')));
            outmonth = Integer.parseInt(checkout.substring(checkout.indexOf('-')+1));
         }
         rList[Reservation.resCount] = new Reservation(roomtype, checkin, checkout, c);
         done = true ;
      }
      else done = false ;
      return done ; 
   }  
	   
   public static boolean CancelMyReservation(){
      return rList[Reservation.resCount-1].cancelReservation(); 
   }
	   
	   
   public static void DisplayMyReservation(){
      rList[Reservation.resCount-1].print();
   }
	   
   public static int Find(String resNumber){
      for (int i = 0; i < Reservation.resCount; i++)
         if(rList[i].getresNum().equals(resNumber))
            return i;
      return -1;
   }
	     
   public static void Display(){
      for (int i = 0; i < Reservation.resCount; i++){
         if(rList[i].getresState().equals("Confirmed"))
            rList[i].print();
         else
            System.out.print("");
      }
   } 
	     
   public static boolean Modify(String resNumber){
      char Uprtype;
      for (int i = 0; i < Reservation.resCount; i++){
         if(rList[i].getresState().equals("Confirmed") && Find(resNumber)!=-1){
            System.out.println("Enter room type:");
            Uprtype = sc.next().charAt(0);
            rList[Find(resNumber)].setRoom(Uprtype);
            rList[Find(resNumber)].setPrice(rList[Find(resNumber)].calculatePrice());
            return true;
         }
      }
      return false;
   }
	    
   public static boolean Cancel(String resNumber){
      int indexOfresNum = Find(resNumber);
      if(indexOfresNum != -1){
         rList[indexOfresNum].cancelReservation();
         return true;
      }
      return false; 
   }
	   
   public static int CountReservations(String status){
      int numOfres = 0;
      for(int i=0 ; i < Reservation.resCount; i++){
         if(status.toLowerCase().equals("confirmed")){
            if(rList[i].getresState().toLowerCase().equals("confirmed")){
               numOfres++;
            }
         }
       	   
         if(status.toLowerCase().equals("unconfirmed")){
            if(rList[i].getresState().toLowerCase().equals("unconfirmed")){
               numOfres++;
            }
         }
       	   
         if(status.toLowerCase().equals("canceled")){
            if(rList[i].getresState().toLowerCase().equals("canceled")){
               numOfres++;
            }
         }
      }
      return numOfres;
   }

	   
   public static void DisplayDueReservations(){
      String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
      int today = Integer.parseInt(date.substring(0,date.indexOf('-')));
      int thismonth = Integer.parseInt(date.substring(date.indexOf('-')+1, date.indexOf('-', date.indexOf('-')+1)));
      for(int i = 0; i < Reservation.resCount; i++) {
         if(thismonth == rList[i].getMonth() && rList[i].getDay()-today == 1)
            rList[i].print();
         else if(thismonth == 12 && today == 31 && rList[i].getMonth() == 1 && rList[i].getDay() == 1)
            rList[i].print();  
         else if(thismonth+1 == rList[i].getMonth() && rList[i].getDay() == 1 && today == 31)
            rList[i].print();
      }
   }
	               		  
}
	   
	    	   
