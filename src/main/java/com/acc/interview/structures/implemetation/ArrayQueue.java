package com.acc.interview.structures.implemetation;

import com.acc.interview.structures.interfaces.Queue;

/**
 * A simple finite queue implemetation
 * @author Alejandro Cardenas Campos
 * @date 26/11/2018
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
    // Variables de clase

    // Variables de instancia
    /**
     * Defines the maxumun size of the queue.
     */
    private int maxSize;

    /**
     * Holds the number of elemets in the queue.
     */
    private int size;

    /**
     * Pointer to the first of the queue.
     */
    private int top;

    /**
     * Pointer to the las element of the queue.
     */
    private int bottom;

    /**
     * Array that contains queue elements
     */
    private T[] elements;

    public ArrayQueue(){}

    public  ArrayQueue(int size){
        init(size);
    }

    @Override
    public void init(int size) {
        maxSize = size;
        elements = (T[]) new Object[maxSize];
        top = -1;
        bottom = 0;
        size = 0;
    }

    @Override
    public void enqueue(T data) {
        if(hasSpace()){
            int next = getNextTop();
            if(next > -1){
                top = next;
                elements[top] = data;
                size++;
            }
        }
    }

    @Override
    public T dequeue() {
        T data = null;
        if(!isEmpty()){
            data = elements[bottom];
            elements[bottom] = null;
            bottom = getNextBottom();
            size--;
        }
        return data;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return elements[bottom];
        }
        return null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private boolean hasSpace(){
        return hasSpaceFor(1);
    }

    private boolean hasSpaceFor(int elements){
        return elements <= maxSize && maxSize - elements > 0;
    }

    /**
     * Calculete the next possition of top pointer.
     * @return An integer between -1 and <code>maxSize</code>
     */
    private int getNextTop(){
        int next = top + 1;

        if(next >= maxSize){
            if(bottom > 0){
                next = 0;
            } else {
                next = -1;
            }
        }

        return next;
    }

    /**
     * Calculate the next pointer to the las element
     * @return An integer between -1 and <code>maxSize</code>
     */
    private int getNextBottom(){
        int next = bottom + 1;

        if(next >= maxSize){
            next = 0;
        }

        return next;
    }
}
