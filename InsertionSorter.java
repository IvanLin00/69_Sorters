/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {

    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
      sort the user's data, implementing insertion sort
     */
    public void mySort() {
	for (int currentSortIndex = 1;
	     currentSortIndex < elements.size();
	     currentSortIndex ++) insert1(elements, currentSortIndex);
    }

    public void insert1(ArrayList<String> unsortedList, int startingIndex){
	String sortElement = unsortedList.get(startingIndex);
	
    }
}
