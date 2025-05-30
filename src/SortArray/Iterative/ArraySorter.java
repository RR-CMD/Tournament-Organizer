package SortArray.Iterative;

/**
   A class of static, iterative methods for sorting an array of
   Comparable objects from smallest to largest.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class ArraySorter
{
   // SELECTION SORT
   /** Sorts the first n objects in an array into ascending order.
       @param a  An array of Comparable objects.
       @param n  An integer > 0. */
   public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n)
   {
      for (int index = 0; index < n - 1; index++)
      {
         int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
         swap(a, index, indexOfNextSmallest);
         // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]
      } // end for
   } // end selectionSort
  
   // Finds the index of the smallest value in a portion of an array a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private static <T extends Comparable<? super T>>
           int getIndexOfSmallest(T[] a, int first, int last)
   {
      T min = a[first];
      int indexOfMin = first;
      for (int index = first + 1; index <= last; index++)
      {
         if (a[index].compareTo(min) < 0)
         {
            min = a[index];
            indexOfMin = index;
         } // end if
         // Assertion: min is the smallest of a[first] through a[index].
      } // end for

      return indexOfMin;
   } // end getIndexOfSmallest
  
// -------------------------------------------------------------------------------

// INSERTION SORT
	public static <T extends Comparable<? super T>> 
	       void insertionSort(T[] a, int n)
	{
		insertionSort(a, 0, n - 1);
	} // end insertionSort

	public static <T extends Comparable<? super T>> 
	       void insertionSort(T[] a, int first, int last)
	{
		for (int unsorted = first + 1; unsorted <= last; unsorted++)
		{   // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]
		
			T firstUnsorted = a[unsorted];
			
			insertInOrder(firstUnsorted, a, first, unsorted - 1);
		} // end for
	} // end insertionSort

	private static <T extends Comparable<? super T>> 
	        void insertInOrder(T anEntry, T[] a, int begin, int end)
	{
      int index = end;
      
		while ((index >= begin) && (anEntry.compareTo(a[index]) < 0))
		{
			a[index + 1] = a[index]; // Make room
         index--;
		} // end for
		
		// Assertion: a[index + 1] is available
		a[index + 1] = anEntry;  // Insert
	} // end insertInOrder

// -------------------------------------------------------------------------------

// SHELL SORT
	public static <T extends Comparable<? super T>>
	       void shellSort(T[] a, int n)
	{
		shellSort(a, 0, n - 1);
	} // end shellSort

	/** Sorts equally spaced elements of an array into
	    ascending order.
	    @param a      An array of Comparable objects.
	    @param first  An integer >= 0 that is the index of the first
	                  array element to consider.
	    @param last   An integer >= first and < a.length that is the
	                  index of the last array element to consider.
	    @param space  The difference between the indices of the
	                  elements to sort. */
   public static <T extends Comparable<? super T>>
          void shellSort(T[] a, int first, int last)
   {
      int n = last - first + 1; // Number of array entries
      int space = n / 2;
      while (space > 0)
      {
         for (int begin = first; begin < first + space; begin++)
         {
            incrementalInsertionSort(a, begin, last, space);
         } // end for
         space = space / 2;
      } // end while
   } // end shellSort
	
   // -------------------------------------------------------------------------------
   
   // BETTER SHELL SORT 
   
	/** Avoids even spacing */
	public static <T extends Comparable<? super T>>
	       void betterShellSort(T[] a, int n)
	{
		betterShellSort(a, 0, n - 1);
	} // end betterShellSort

	// Exercise 14, Chapter 8
	public static <T extends Comparable<? super T>>
	       void betterShellSort(T[] a, int first, int last)
	{
		int n = last - first + 1; // Number of array elements
		
	  for (int space = n / 2; space > 0; space = space / 2)
		{
			if (space % 2 == 0) // If space is even, add 1
				space++;
				
			for (int begin = first; begin < first + space; begin++)
				incrementalInsertionSort(a, begin, last, space);
		} // end for
	} // end betterShellSort
	
   //  Sorts equally spaced elements of an array into ascending order.
   //  Parameters:
   //     a      An array of Comparable objects.
   //     first  The integer index of the first array entry to
   //            consider; first >= 0 and < a.length.
   //     last   The integer index of the last array entry to
   //            consider; last >= first and < a.length.
   //     space  The difference between the indices of the
   //            entries to sort.
   private static <T extends Comparable<? super T>>
           void incrementalInsertionSort(T[] a, int first, int last, int space)
   {
      int unsorted, index;

      for (unsorted = first + space; unsorted <= last; 
          unsorted = unsorted + space)
      {
         T nextToInsert = a[unsorted];
         index = unsorted - space;
         while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0))
         {
            a[index + space] = a[index]; 
            index = index - space;
         } // end while

         a[index + space] = nextToInsert; 
      } // end for
   } // end incrementalInsertionSort
   // -------------------------------------------------------------------------------
	
   // BUBBLE SORT
   
	// Exercise 8, Chapter 8
	public static <T extends Comparable<? super T>> 
	       void bubbleSort(T[] a, int n)
	{
		for (int lastIndex = n - 1; lastIndex > 0; lastIndex--)
		{	
			for (int index = 0; index < lastIndex; index++)
				order(a, index, index + 1);
		}
	} // end bubbleSort
	
	private static <T extends Comparable<? super T>>
	        void order(T[] a, int i, int j)
	{
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
	    // Assertion: a[j] is larger 
	}  // end order 
   // -------------------------------------------------------------------------------
   
   // BETTER BUBBLE SORT
	
	// Exercise 10, Chapter 8
	public static <T extends Comparable<? super T>> 
	       void betterBubbleSort(T[] a, int n)
	{
		for (int lastIndex = n - 1; lastIndex > 0; lastIndex--)
		{
			int lastSwapIndex = 0;
			for (int index = 0; index < lastIndex; index++)
			{
				if (a[index].compareTo(a[index + 1]) > 0)
				{
					swap(a, index, index + 1);
					lastSwapIndex = index;
				} // end if
			} // end for
			
			lastIndex = lastSwapIndex + 1;
		} // end for
	}  // end betterBubbleSort
// -------------------------------------------------------------------------------

// MERGE SORT

	public static <T extends Comparable<? super T>> 
	       void iterativeMergeSort(T[] a, int n)
	{
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempArray = (T[])new Comparable<?>[a.length]; // unchecked cast
		int beginLeftovers = n;
		
		for (int segmentLength = 1; segmentLength <= n/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = mergeSegmentPairs(a, tempArray, n, segmentLength);

			// Two full segments do not remain at end; the following are possibilites:
			//   a. one full segment and a partial second segment
			//   b. one full segment only
			//   c. one partial segment
			//   d. nothing is left at end
			int endSegment = beginLeftovers + segmentLength - 1;
			
			if (endSegment < n - 1)
			// Case a: one full segment and a partial second segment exist, so merge them
				merge(a, tempArray, beginLeftovers, endSegment, n-1);

			// else Cases b, c, or d: only one full or partial segment is left (leave it in place)
			//                        or nothing is left
		} // end for

		// merge the sorted leftovers, if any, with the rest of the sorted array

		if (beginLeftovers < n)
			merge(a, tempArray, 0, beginLeftovers-1, n-1);
	} // end iterativeMergeSort

	// Merges pairs of segments of a given length within an array 
	// and returns the index after the last merged pair.
	private static <T extends Comparable<? super T>> 
	        int mergeSegmentPairs(T[] a, T[] tempArray, int n, int segmentLength)
	{
		int mergedPairLength = 2 * segmentLength; // Length of two merged segments
		int numberOfPairs = n / mergedPairLength;
		
		int beginSegment1 = 0;
		
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			
			merge(a, tempArray, beginSegment1, endSegment1, endSegment2);
			
			beginSegment1 = endSegment2 + 1;
		} // end for
		
		return beginSegment1; // Return index of element after last merged pair
	}  // end mergeSegmentPairs

	private static <T extends Comparable<? super T>> 
	        void merge(T[] a, T[] tempArray, int first, int mid, int last)
	{
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both subarrays are not empty, copy the
	   // smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
	   {  // Invariant: tempArray[beginHalf1..index-1] is in order
	   
	      if (a[beginHalf1].compareTo(a[beginHalf2]) < 0)
	      {  
	      	tempArray[index] = a[beginHalf1];
	         beginHalf1++;
	      }
	      else
	      {  
	      	tempArray[index] = a[beginHalf2];
	         beginHalf2++;
	      }  // end if
	   }  // end for

	   // Finish off the nonempty subarray

	   // Finish off the first subarray, if necessary
	   for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
	      // Invariant: tempArray[beginHalf1..index-1] is in order
	      tempArray[index] = a[beginHalf1];

	   // Finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
	      // Invariant: tempa[beginHalf1..index-1] is in order
	      tempArray[index] = a[beginHalf2];
		
	   // Copy the result back into the original array
	   for (index = first; index <= last; index++)
	      a[index] = tempArray[index];
	}  // end merge
// -------------------------------------------------------------------------------

// HEAP SORT

   public static <T extends Comparable<? super T>> 
          void heapSort(T[] array, int n)
   {
      // Create first heap
      for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
         reheap(array, rootIndex, n - 1);
       
      swap(array, 0, n - 1);

      for (int lastIndex = n - 2; lastIndex > 0; lastIndex--)
      {
         reheap(array, 0, lastIndex);
         swap(array, 0, lastIndex);
      } // end for
   } // end heapSort

	private static <T extends Comparable<? super T>>
	        void reheap(T[] heap, int rootIndex, int lastIndex)
	{
      boolean done = false;
      T orphan = heap[rootIndex];
      int leftChildIndex = 2 * rootIndex + 1;

      while (!done && (leftChildIndex <= lastIndex))
      {
         int largerChildIndex = leftChildIndex;
         int rightChildIndex = leftChildIndex + 1;
         if ( (rightChildIndex <= lastIndex) && 
               heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
         {
            largerChildIndex = rightChildIndex;
         } // end if

         if (orphan.compareTo(heap[largerChildIndex]) < 0)
         {
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex + 1;
         } 
         else
            done = true;
      } // end while

      heap[rootIndex] = orphan;
	} // end reheap
// -------------------------------------------------------------------------------

   // Swaps the array entries a[i] and a[j].
   private static void swap(Object[] a, int i, int j)
   {
      Object temp = a[i];
      a[i] = a[j];
      a[j] = temp; 
   } // end swap
} // end ArraySorter