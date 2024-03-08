package heap;

import java.util.ArrayList;

import data.structure.AbstractPriorityQueue;
import data.structure.Entry;
/**
 * Implementation of a priority Queue using an array based min heap
 * @author CYPRIAN
 *
 * @param <K>
 * @param <V>
 */
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	/**Collection of priority Queue entries*/
	private ArrayList<Entry<K,V>>heap = new ArrayList<Entry<K,V>>();
	
	public HeapPriorityQueue() {
		super();
	}
	//utiltity methods
	private int getParent(int entry) {
		return (entry-1)/2;
	}
	private int leftChild(int p) {
		return 2*p+1;
	}
	private int rightChild(int p) {
		return 2*p+2;
	}
	private boolean hasLeft(int i) {
		return leftChild(i) < heap.size();
	}
	private boolean hasRight(int i) {
		return rightChild(i)< heap.size();	
	}
	/**swaps entries at index i and j of the heap in the array*/
	private void swap(int i,int j) {
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	/**Heapifies the entry at index j  higher*/
	private void upHeap(int j) {
		while(j>0) {
			int p = getParent(j);
			//compare entry at j with parent
			if(compare(heap.get(j),heap.get(p))>=0) break; //heap property maintained
			swap(j,p);
			j= p;
		}
	}
	/**Moves the entry at index j lower if necessary to restore heap property*/
	private void downheap(int j) {
		while(hasLeft(j)) {
			int leftChild = leftChild(j);
			int min = leftChild;
			if(hasRight(j)) {
				int rightChild = rightChild(j);
				if(compare(heap.get(min),heap.get(rightChild))>0)
					min = rightChild; //right child is smaller
			}
			if(compare(heap.get(min),heap.get(j))>=0)
				break;
			swap(j,min);
			j = min;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public Entry<K, V> add(K key, V value) {
		// TODO Auto-generated method stub
		ckeckKey(key);
		Entry<K,V> newest = new PQEntry<K,V>(key,value);
		heap.add(newest); //add to the end of the list
		upHeap(heap.size()-1);
		
		return newest;
	}

	@Override
	public Entry<K, V> getMin() {
		// TODO Auto-generated method stub
		if(heap.isEmpty()) return null;
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(heap.isEmpty()) return null;
		Entry<K,V> entry = heap.get(0);
		
		swap(0,heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		
		return entry;
	}

}
