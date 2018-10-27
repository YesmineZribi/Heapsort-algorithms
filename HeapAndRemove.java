import java.util.Arrays;

public class HeapAndRemove {
	private int capacity = 10;
	private int size; 
	private int[] items = new int[capacity];
	
	
	public void add(int element) {
		items[++size] = element;
	}
	
	/**
	 * Max Heapify the current array 
	 */
	public void maxHeap(int k) {
		int tmp = items[k];
		int j;
		while (k <= size/2) { //start at last internal node
			j = 2*k; //left child
			if ((j < size) && (items[j+1] > items[j])) { //if j is strictly less than size for sure we have a brother
				j++;
			}
			if (tmp > items[j]) {
				break; //Here we are good
			} else { //oh oh...located a bigger child
				items[k] = items[j];
				k = j;
			}
			
		}
		items[k] = tmp;
	}
	
	/**
	 * Min Heapify the current array 
	 */
	public void minHeap(int k) {
		int tmp = items[k];
		int j;
		while (k <= size/2) { //Start at last internal node
			j = 2*k; //grab the left child;
			if ((j < size) && (items[j+1] < items[j])) {
				j++; //locate the right child if he's smaller
			}
			if(tmp < items[j]) {
				break; //Here we're good. 
			} else { //oh oh...there is a smaller child
				//1. replace the parent with the child immediatly
				items[k] = items[j];
				
				//2. Place hold the kid's place for parent
				k = j;
			}
			
		}
		items[k] = tmp;
		
		
	}
	
	/**
	 * Build heap by calling min or max heap on all internal nodes
	 * Takes O(n)
	 */
	
	public void buildMinHeap() {
		for (int i = size/2; i >=1; i--) {
			minHeap(i);
		}
	}
	
	public void buildMaxHeap() {
		for (int i = size/2; i >= 1; i--) {
			maxHeap(i);
		}
	}
	/**
	 * use min heap to sort in ascending order 
	 * Remember tip: smallest number from heap is placed first in sorted array
	 */
	public int[] heapSortAscendingOrder() {
		//Sorted array: 
		int[] sortedArray = new int[size];
		int sortedArraySize = 0;
		
		//build heap
		buildMinHeap();
		
		//remove root and put it in clean array - do until one element left in heap
		while (size > 1) {
			int tmp = items[1];
			items[1] = items[size];
			sortedArray[sortedArraySize++] = tmp;
			size--;
			minHeap(1);
		}
		sortedArray[sortedArraySize++] = items[1];
		
		return sortedArray;
	
	}
	
	/**
	 * use max heap to sort in ascending order 
	 * Remember tip: biggest number from heap is placed first in sorted array
	 */
	public int[] heapSortDescendingOrder() {
		int[] sortedArray = new int[size];
		int sortedArraySize = 0;
		//build heap 
		buildMaxHeap();
		
		//remove root and put it in clean array - do until one element left in heap
		while(size > 1) {
			int tmp = items[1];
			items[1] = items[size];
			sortedArray[sortedArraySize++] = tmp;
			size--;
			maxHeap(1);
			
		}
		sortedArray[sortedArraySize++] = items[1];
		return sortedArray;
	}
	public String toString() {
		String array = "[";
		for (int i = 1; i <= size; i++) {
			array += items[i]+", ";
		}
		array += "]";
		return array;
	}
	
	public static void main(String[] args) {
		HeapAndRemove heap = new HeapAndRemove();
		int[] array = new int[] {4,10,3,5,1};
		for (int i = 0; i < array.length; i++) {
			heap.add(array[i]);
		}
		
		int[] sortedArrayAscend = heap.heapSortAscendingOrder();
		System.out.println(Arrays.toString(sortedArrayAscend));
		//Output: [1, 3, 4, 5, 10]
		
		HeapAndRemove heap1 = new HeapAndRemove();
		int[] array1 = new int[] {4,10,3,5,1};
		for (int i = 0; i < array.length; i++) {
			heap1.add(array1[i]);
		}

		
		int[] sortedArrayDescend = heap1.heapSortDescendingOrder();
		System.out.println(Arrays.toString(sortedArrayDescend));
		//Output: [10, 5, 4, 3, 1]
		
	}

}
