import java.util.Arrays;

public class HeapInPlace {
	
	public static void minHeap(int[] items, int k, int size) {
		int tmp = items[k];
		int j;
		
		while (k <= size/2) {
			j = 2*k; //grab left child
			if ((j < size) && (items[j+1] < items[j])) { //meaning there has to be a right bro
				j++; 
			}
			if (tmp < items[j]) {
				break; //get out at this point we know everyting is in place 
			} else { //oh no parent is out of place...we gotta fix that
				items[k] = items[j]; //replace parent with child for now
				k = j; //place hold child index in case I'm putting the parent there
				//if my child is also a parent I will be comparing with grandchildren and they could be
				//smaller so...for now just place hold
				
			}

		}
		//At this point I compared my parent with all their descendants and I will put it 
		//in its placeholder
		items[k] = tmp;
		
	}
	
	public static void maxHeap(int[] items, int k, int size) {
		int tmp = items[k];
		int j;
		
		while (k <= size/2) {
			j = 2*k;
			if ((j < size) && (items[j+1] > items[j])) {
				j++;
			}
			if (tmp > items[j]) {
				break;
			} else {
				items[k] = items[j];
				k = j;
			}
		}
		items[k] = tmp;
	}
	
	public static void buildMaxHeap(int[] items) {
		int n = items.length-1;
		for (int i = n/2; i >= 1; i--) {
			HeapInPlace.maxHeap(items,i,n); 
		}
		
	}
	
	public static void buildMinHeap(int[] items) {
		int n = items.length-1;
		for (int i = n/2; i >= 1; i--) {
			HeapInPlace.minHeap(items,i,n);
		}
		
	}
	
	/**
	 * Heaping in place is done in opposite direction than heaping and removing
	 * in other words: the root is always placed at end of the array so if we want to
	 * have an ascending order we need biggest number last so here we have to have a max heap
	 */
	public static void heapSortAscend(int[] items) {
		//build heap from array 
		HeapInPlace.buildMaxHeap(items);
		
		//Remove first node and put it in the end
		int size = items.length-1;
		while (size > 1) {
			int tmp = items[1];
			items[1] = items[size];
			items[size] = tmp;
			HeapInPlace.maxHeap(items, 1, --size);
		}
	}
	/**
	 * Heaping in place is done in opposite direction than heaping and removing
	 * in other words: the root is always placed at end of the array so if we want to
	 * have an descending order we need smallest number last so here we have to have a min heap
	 */
	public static void heapSortDescend(int[] items) {
		//build heap from array 
		HeapInPlace.buildMinHeap(items);
		
		//Remove first note and put it in the end
		int size = items.length-1;
		while (size > 1) {
			int tmp = items[1];
			items[1] = items[size];
			items[size] = tmp;
			HeapInPlace.minHeap(items, 1, --size);
		}
		
	}
	
	public static void main(String[] args) {
		int[] items1 = new int[] {0,4,10,3,5,1}; //position 0 is ignored
		HeapInPlace.heapSortAscend(items1);
		System.out.println(Arrays.toString(items1));
		//Output [0, 1, 3, 4, 5, 10]
		
		HeapInPlace.heapSortDescend(items1);
		System.out.println(Arrays.toString(items1));
		//Output [0, 10, 5, 4, 3, 1]
	}
	
	
	
	
	
	
}
