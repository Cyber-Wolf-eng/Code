import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.util.*;
//import CollegeDataComparator;
//import CollegeData();


public class CollegeBook
{
    int pg = -1;
    
private ArrayList<CollegeData> addressBook;

public CollegeBook()
{
    // OG info
     addressBook = new ArrayList<CollegeData>();
    CollegeData info1 = new CollegeData();
    CollegeData info2 = new CollegeData();
    CollegeData info3= new CollegeData();
    // first entry 
            info1.setName("Troy University");
            info1.setZip(36082);
            info1.setFound(1887);
            info1.setPrice(13257);
            info1.setAccept(92);
            info1.setGrad(34);
            info1.setCity("Troy");
            info1.setState("AL");
            info1.setSelectedItemSize("Small");
            info1.setSelectedItemType("Public");
            addressBook.add(info1);
        // second entry    
            info2.setName("Texas Christan University");
            info2.setZip(76129);
            info2.setFound(1873);
            info2.setPrice(57220);
            info2.setAccept(52.6);
            info2.setGrad(79);
            info2.setCity("Forth Worth");
            info2.setState("TX");
            info2.setSelectedItemSize("Medium");
            info2.setSelectedItemType("Private");
            addressBook.add(info2);
         // 3rd entry    
            info3.setName("Stanford University");
            info3.setZip(94305);
            info3.setFound(1885);
            info3.setPrice(58416);
            info3.setAccept(4);
            info3.setGrad(96);
            info3.setCity("Stanford");
            info3.setState("CA");
            info3.setSelectedItemSize("Medium");
            info3.setSelectedItemType("Private");
            addressBook.add(info3);
            
}    
public void printAllUniversities(){ // tester
    //java lambda
    addressBook.forEach((n) -> System.out.println(n.getName()));
}

public CollegeData getNextPage(){// moeves it thru adressbook and updates pg number 
    int currentSize = addressBook.size();
    
    System.out.println("Array List size:" + currentSize + " Current Page Number:" + pg);
    
    if((pg < currentSize -1)) {
        pg++;
    }
          //  System.out.println(pg);   
        //System.out.println(addressBook.get(pg).getName());
         return addressBook.get(pg);

}
public CollegeData getPrePage(){// gets previous page
    int currentSize = addressBook.size();
    System.out.println(pg);
    
    if(pg < currentSize){
         pg--;
    }
         return addressBook.get(pg);

}

public CollegeData getFirstPage()
{
    pg = 0;
    return addressBook.get(pg);
}
public CollegeData getLastPage(){
     pg = addressBook.size()-1;
    return addressBook.get(pg);
}

public int getCurrentIndex(){ // gets current index
    return pg;
}

public CollegeData getPG(){
    return addressBook.get(pg);
}
    
 //this method will be used to add an entry into the address book
 public void addEntry(CollegeData cd) {
     addressBook.add(cd);
 }
 //this method will be used delete an entry in the address book
 public CollegeData deleteEntry(){
     CollegeData returnCD = new CollegeData();
     
     if(pg == -1) {
        return null;
     }
     //I am on the first page and there is only 1 entry
     if(pg == 0 && addressBook.size() == 1){
                     addressBook.remove(pg);
                     pg = -1;
     }
     //if my address book  is on page 0 or greater and we are not on the last page

     //if I am on the first page and there are multiple entries
     if(addressBook.size() > 1){
         
         //we are on the last page
         if(pg == (addressBook.size() - 1)){
            returnCD = addressBook.get(pg - 1);
              //delete the last entry
            addressBook.remove(pg);
            pg--;
        }
        else{
            returnCD = addressBook.get(pg + 1);
            addressBook.remove(pg);
            
        }
        
     }
        return returnCD;
 
 }
  //this method will be used to modify an entry in the address book - ignore went with a different route
 public void addAtIndexEntry(int num,CollegeData cd){
     if(addressBook.size() > num ) {
        addressBook.add(cd);
     }
 }
 


 public void mySort(){ // sorts the array based off of the sortbyprice comparitor
     Collections.sort(addressBook,new SortByPrice());
 }
 
public int getAddressBookSize(){
    return addressBook.size();
}
 
}