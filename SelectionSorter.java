/**
  Implement an selection sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter {

    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
      sort the user's data, implementing insertion sort
     */
	 /*
	 pre-condition: a list with a sorted region and a sorted region
	 
	 Finds the index of the smallest index and swaps the values 
	 between that index and index 0. 
	 
	 post-condition: a list with a one bigger sorted region and 
					 a one smaller unsorted region.
	*/
    public void mySort() {
		ArrayList<String> unordered = elements;
		for (int i = 0; i< unordered.size() - 1; i++){
			 int index = champIndex(unordered,i);
			 String small = unordered.get(index);
			 unordered.set(index,unordered.get(i));
			 unordered.set(i,small);
			 System.out.println( 
				 "Change this to report on progress."
				 + unordered
			 );
		 }
		 elements = unordered;
	}
	
	private int champIndex(ArrayList<String> list, int beginning) {
		 String minValue = "Z";
		 int smallestIndex =  0;
		 for (int i = beginning; i < list.size(); i++){
			 if (minValue.compareTo(list.get(i))>0){
				 smallestIndex = i;
				 minValue = list.get(i);
			 }
		 }
		 return smallestIndex;
	}

}
