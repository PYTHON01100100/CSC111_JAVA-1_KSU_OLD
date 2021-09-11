
import java.io.*;
import java.util.*;
public class Application{
public static void main(String args[]){

Scanner in = new Scanner(System.in);

List BoSList = new List();

try{
for(int i=0;i<3;i++){

System.out.println("Enter book store location:");
String loc = in.next();
//loc = in.nextLine();

System.out.println("Enter number of books:");
int n = in.nextInt();

System.out.println("Enter the size:");
int size= in.nextInt();

Bookstore b = new Bookstore(loc, n ,size);

System.out.println("How many sections do you want to add?");
int s =  in.nextInt();

for(int j=0;j<s;j++){
System.out.println("Enter section name");
b.addSection(in.next());
}

BoSList.insertAtBack(b);
}

File f = new File("MoreBookstores.txt");
Scanner input = new Scanner(f);
while(input.hasNext()){
String loc=input.next();
int n=input.nextInt();
int size=input.nextInt();
Bookstore b = new Bookstore(loc, n ,size);
BoSList.insertAtBack(b);
}
input.close();
}
catch(IOException e){
System.out.println("ERROR!!");
}
catch(InputMismatchException e){
System.out.println("ERROR!!");
}
boolean flag = false;
for(int i=0;i<BoSList.size();i++){
Bookstore b = BoSList.removeFromfront();
if(b.getLoc().toUpperCase().equals("KSU")){
flag =true;
break;}
BoSList.insertAtBack(b);
}

if(flag)
System.out.println("The bookstore in KSU has been removed");
else
System.out.println("The is no bookstore in KSU to remove");


int count =0;

for(int i=0;i<BoSList.size();i++){

Bookstore b = BoSList.removeFromfront();

if(b.getNum()>=1000)
b.addSection("Computer");
else
count++;

BoSList.insertAtBack(b);
}

Bookstore [] RArray = new Bookstore [count];

int m=0;

for(int i=0;i<BoSList.size();i++){

Bookstore b = BoSList.removeFromfront();
if(b.getNum()<1000)
RArray[m++]=b;
BoSList.insertAtBack(b);

}

System.out.println("The number of regular bookstores is: "+count);

try{
File f1 = new File("RegularBookstores.dat");
ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(f1));
oo.writeObject(RArray);
oo.close();
}
catch(IOException e){
System.out.println("ERROR!!");
}

for(int i=0;i<BoSList.size();i++){
Bookstore b = BoSList.removeFromfront();
System.out.println(b);
BoSList.insertAtBack(b);
}

}//main
}//class
