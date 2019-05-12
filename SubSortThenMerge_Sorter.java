import java.util.ArrayList;
public class SubSortThenMerge_Sorter extends Sorter{
	 ArrayList<String> localCopy;
	 
	 public SubSortThenMerge_Sorter(  ArrayList< String> usersData) {
         super(usersData);
     }
	
	 public void mySort(){
		 mySort(0,elements.size() - 1);
	 }
	 
	 public void mySort(int start, int end){
		 int middle = (start+end)/2;
		 if (start == end){ // Decision to go to base case or recursive case{
			 return; //base case
		 }
		 merge(start, (start + middle)/2, middle); // concatenator
		 mySort(start, middle);// recursive abstraction
		 merge(middle, (middle + end)/2 , end); // concatenator
		 mySort(middle,end);// recursive abstraction
	 }
		 
	 public void merge(
      // indexes of sub-list boundaries in usersData; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // index past end of list1
     ) {
        /* copy the user's data, so that its two lists
         can be merged into usersData */
         localCopy = new ArrayList<String>( end1 - start0);
        for( int iUserData = start0; iUserData < end1; iUserData++)
            localCopy.add( elements.get( iUserData));
        // temp for debugging
        System.out.println( "localCopy: " + localCopy);

        mergeRange( start0
                  , 0, start1 - start0
                  , start1 - start0, end1 - start0);
    }


    /**
      problem: Merge the user data from the given range in localCopy
        into the usersData.
     recursive abstraction: When I am asked to {problem statement}, 
       the recursive abstraction can merge the results of a range
       that is one item smaller.
     */
    private void mergeRange(
        int target // destination in usersData. Probably redundant.

        // boundaries of lists in localCopy, NOT usersData!
      , int localStart0  // index of first item in list0
      , int localEnd0    // just past end of list0
      , int localStart1  // index of first item in list1
      , int localEnd1    // just past end of list0
      ) {
        // temp for debugging
        System.out.println(
            " target = "      + target  
          + " localStart0 = " + localStart0
          + " localEnd0 = "   + localEnd0  
          + " localStart1 = " + localStart1
          + " localEnd1 = "   + localEnd1  
          );
          
        if( // both ranges are exhausted
            localStart0 == localEnd0 && localStart1 == localEnd1
          )
            // solution to base case
            return;  // merge is done
        else{ // there is at least 1 item remaining to merge
            if( // list0 exhausted
                localStart0 == localEnd0
              ) 
               // take an item from list1
                elements.set( target++, localCopy.get( localStart1++));

            // similarly for exhausted list1
            else if( localStart1 == localEnd1)
                elements.set( target++, localCopy.get( localStart0++));
            
            else // items remain in both lists
                // copy the smaller item
                if( localCopy.get( localStart0).compareTo( 
                    localCopy.get( localStart1)) < 0)
                    elements.set( target++, localCopy.get( localStart0++));
                else
                    elements.set( target++, localCopy.get( localStart1++));
            mergeRange( target, localStart0, localEnd0, localStart1, localEnd1);
        }
    
    }
}