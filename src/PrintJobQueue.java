//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Queue Structure Implementation
// Course:   CS 300 Spring 2025
//
// Author:   Pranav Krovi
// Email:    pkrovi@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    x
// Partner Email:   x
// Partner Lecturer's Name: x
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   x Write-up states that pair programming is allowed for this assignment.
//   x We have both read and understand the course Pair Programming Policy.
//   x We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         Mouna Kacem
//                  - slides helped with understanding the stack structure and its implementation
// Online Sources:  W3 schools
//                  - https://www.w3schools.com/dsa/dsa_data_queues.php
//
///////////////////////////////////////////////////////////////////////////////
// Imports 
import java.util.NoSuchElementException;
/*
 * This class implements a queue of PrintJob objects using a linked list.
 */
public class PrintJobQueue extends Object implements QueueADT<PrintJob> {
    private LinkedNode<PrintJob> front; // reference to the front of the queue
    private LinkedNode<PrintJob> back; // reference to the rear of the queue
    private int size; // number of elements in the queue
    /*
     * Constructor initializes an empty queue.
     * The front and back references are set to null, and the size is set to 0.
     */
    public PrintJobQueue() {
        front = null;
        back = null;
        size = 0;
    }
    /*
     * Add a new element to the back of the queue, assumed to be a non null value.
     * If the queue is empty, the new element becomes both the front and back of the queue.
     * @param value the PrintJob object to be added to the queue
     * @override enqueue method from QueueADT interface
     */
    @Override
    public void enqueue(PrintJob value) {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_queues.php
        // how to enqueue a value in a queue
        LinkedNode<PrintJob> newNode = new LinkedNode<>(value);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
            size++;
        } else {
            back.setNext(newNode);
            back = newNode;
            size++;
        }
    }
    /*
     * Remove and return the front element of the queue.
     * If the queue is empty, throw a NoSuchElementException.
     * @return the PrintJob object at the front of the queue
     * @override dequeue method from QueueADT interface
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public PrintJob dequeue() {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_queues.php
        // how to dequeue a value in a queue
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        PrintJob result = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            back = null;
        }
        return result;
    }
    /*
     * Return the front element of the queue without removing it.
     * If the queue is empty, throw a NoSuchElementException.
     * @return the PrintJob object at the front of the queue
     * @override peek method from QueueADT interface
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public PrintJob peek() {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_queues.php
        // how to peek a value in a queue
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        return front.getData();
    }
    /*
     * Check if the queue is empty.
     * @return true if the queue is empty, false otherwise
     * @override isEmpty method from QueueADT interface
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /*
     * Return the size of the queue.
     * @return the number of elements in the queue
     * @override size method from QueueADT interface
     */
    @Override
    public int size() {
        return size;
    }   
    /*
     * Check if the queue contains a specific PrintJob object.
     * @param value the PrintJob object to check for
     * @return true if the queue contains the specified PrintJob, false otherwise
     * @override contains method from QueueADT interface
     */
    @Override
    public boolean contains(PrintJob value) {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_queues.php
        // how to run contains on a value in a queue
        LinkedNode<PrintJob> current = front;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    /*
     * Remove all elements from the queue.
     * The front and back references are set to null, and the size is set to 0.
     * @override clear method from QueueADT interface
     */
    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    /*
     * Return a string representation of the queue, using a list
     * @return a list containing the elements of the queue
     */
    public PrintJob[] getList() {
        PrintJob[] result = new PrintJob[size];
        PrintJob[] r = new PrintJob[0];
        LinkedNode<PrintJob> current = front;
        if (current == null) {
            return r;
        }
        for (int i = 0; i < size; i++) {
            if (current == null) {
                break;
            }
            if (current.getData() == null) {
                break;
            }
            result[i] = current.getData();
            current = current.getNext();
        }
        return result;
    }
    /*
     * Check if two PrintJobQueue objects are equal.
     * Two queues are considered equal if they have the same size and contain the same elements in the same order.
     * @param head the head of the other queue to compare with
     * @param back the back of the other queue to compare with
     * @param size the size of the other queue to compare with
     * @return true if the two queues are equal, false otherwise
     */
    protected boolean equalsTo(LinkedNode<PrintJob> head, LinkedNode<PrintJob> back, int size) {
        // Check size
        if (this.size != size) {
            return false;
        }
        // compare each node
        LinkedNode<PrintJob> current1 = this.front;
        LinkedNode<PrintJob> current2 = head;
        while (current1 != null && current2 != null) {
            if (!current1.getData().equals(current2.getData())) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        // Check if both lists are null at the same time
        if (current1 != null || current2 != null) {
            return false;
        }
        // checks backs
        if (back != null && this.back != null) {
            if (!this.back.getData().equals(back.getData())) {
                return false;
            }
        } else if (back != null || this.back != null) {
            return false;
        }
        return true;
    }
}
