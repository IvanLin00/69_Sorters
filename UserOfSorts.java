/** 
  test types of sorts that are polymorphic variations of Sorter
 */
import java.util.Arrays;
import java.util.ArrayList;

public class UserOfSorts {
    public static void main(String[] commandLine) {
        // arrays to be sorted
        ArrayList< String> unsorted = new ArrayList< String>(
          /* Java's Arrays.asList provides a perspicuous
             way to build a Collection from literals,
             suitable for constructing an ArrayList */
          Arrays.asList(
              // one sorted sub-list
            "4", "5", "6", "9"

              // the other sorted sub-list
            , "2", "3", "4", "6", "7", "J", "Q", "K"
            ));

        // insertion sort                   
        oneTest( "insertion sort "
               , new SubSortThenMerge_Sorter( unsorted)
               );
    }


    /** 
     Run one test
     */
    private static void oneTest( String description
                               , Sorter sorter
                               ) {
        System.out.println( System.lineSeparator() + description);
        sorter.mySort();
        System.out.println( sorter);
        System.out.println( "sorted: " + sorter.isSorted());
     }
}
