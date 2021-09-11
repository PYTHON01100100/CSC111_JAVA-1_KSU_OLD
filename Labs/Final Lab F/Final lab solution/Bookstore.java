import java.util.*;
import java.io.*;
public class Bookstore implements Serializable{
private String location;
private int noBook;
private String [] sections;
private int nbS;
public Bookstore(String loc , int n , int size){
while(true){
try{
if(n<0 || n>5000)
throw new InvalidNumberofBook("Invalid Number of Books");
break;
}
catch(InvalidNumberofBook e){
Scanner in = new Scanner(System.in);
System.out.println(e.getMessage()+" re-enter it again");
n= in.nextInt();
}
}
location=loc;
noBook=n;
sections = new String[size];
nbS=0;
}
public String toString(){
String str = "\nlocation: "+location+"\nnumber of Books: "+noBook+"\nnumber of sections: "+nbS+"\nsections names:\n";
for(int i=0; i<nbS;i++)
str += sections[i]+"\n";
return str;
}

public boolean addSection(String s){
if(sections.length==nbS)
return false;
sections[nbS++]=s;
return true;
}

public String getLoc(){
return location;}

public int getNum(){
return noBook;}
}