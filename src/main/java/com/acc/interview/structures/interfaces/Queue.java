
package com.acc.interview.structures.interfaces;

public interface Queue<T> {

    /**
     * Initialize the queue
     * @param size
     */
    void init(int size);

    /**
     * Add a element to the end of queue
     * @param data elemt to add
     */
    void enqueue(T data);

    /**
     * Remove and return the element on the front of queue.
     * @return the next <code>T<code/> element
     */
    T dequeue();

    /**
     * Get the the element on the front of queue without removing it from queue
     * @return Te next T element
     */
    T peek();

    /**
     * Get the actual size of the queue.
     * @return
     */
    int size();

    /**
     * Check if a queue is full
     * @return
     */
    boolean isFull();

    /**
     * Check if queue is empty
     * @return
     */
    boolean isEmpty();
}

//5579 2090 7112 4082
