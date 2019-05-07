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
    public void mySort(){
		 for(int currentSortIndex = 1; currentSortIndex < elements.size(); currentSortIndex++){
				 insert1(elements, currentSortIndex);
				 System.out.println( "    dbg: "
				 + "after inserting element " + currentSortIndex
				 + " elements: " + elements
				 );
			 }
	 }

    private void insert1(ArrayList<String> list, int alreadyInserted){
		 String insertValue = list.get(alreadyInserted);
		 int currentCompareIndex;
		 for (currentCompareIndex = alreadyInserted;
			  currentCompareIndex > 0 && list.get(currentCompareIndex - 1).compareTo(insertValue) > 0;
			  currentCompareIndex --){
				  list.set(currentCompareIndex,list.get(currentCompareIndex - 1));
				 }
			  
		 list.set(currentCompareIndex, insertValue);
		 
	}
	
}

