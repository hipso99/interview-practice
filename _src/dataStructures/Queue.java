package dataStructures;

import java.util.EmptyStackException;

// An implementation of a dataStructures.Queue using a circular array
public class Queue {
	
	private int[] array;
	private int head , tail, currentSize; 
	
	public Queue(int maxSize) {
		array = new int[maxSize];
		head = -1;
		tail = -1; 
	}
	
	// O(1)
	public void enqueue(int data) {
		if(this.isFull()) {
			throw new StackOverflowError();
		} else {
			tail = increment(tail);
			array[tail] = data; 
			currentSize++;			
		}
	}
	
	// O(1)
	public int dequeue() {
		if(this.isEmpty()) {
			throw new EmptyStackException(); 
		} else {
			head = increment(head);
			int item = array[head];
			currentSize--;
			return item;
		}
	}
	
	// O(1)
	public int peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException(); 
		} else {
			int item = array[increment(head)];
			return item;
		}
	}
	
	// O(1)
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	// O(1)
	public boolean isFull() {
		return currentSize == array.length;
	}
	
	public String toString() {
		String result = "{ ";
		int copySize = currentSize; 
		int headCopy = head; 
		
		while(copySize-- > 0) {
			headCopy = increment(headCopy);
			result += array[headCopy] + " ";
		}
		
		result += "}";
		return result; 
	}
	
	private int increment(int index) {
		if(++index == array.length) {
			index = 0; 
		}
		return index; 
	}
	
	
}
