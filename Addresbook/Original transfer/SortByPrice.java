import java.util.*;
// make so we can use the comparitor class
// holds one method 
// the methods will compare to prices and return a ordered respones 

public class SortByPrice implements Comparator<CollegeData>{
    public int compare (CollegeData a, CollegeData b){
        return Integer.compare(a.getPrice(),b.getPrice());
    }//
}