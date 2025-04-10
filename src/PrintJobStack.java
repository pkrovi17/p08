//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Stack Structure Implementation
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
//                  - https://www.w3schools.com/dsa/dsa_data_stacks.php
//
///////////////////////////////////////////////////////////////////////////////

/*
 * This class implements a stack of PrintJob objects using a linked list.
 */
public class PrintJobStack extends Object implements StackADT<PrintJob> {

    private LinkedNode<PrintJob> top; // reference to the top of the stack
    private int size; // number of elements in the stack
    /*
     * Constructor initializes an empty stack.
     * The top reference is set to null, and the size is set to 0.
     */
    public PrintJobStack() {
        top = null;
        size = 0;
    }
    /*
     * Checks if the stack is empty.
     * Returns true if the stack is empty, false otherwise.
     * @override isEmpty method from StackADT interface
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && top == null;
    }
    /*
     * Adds a new element to the top of the stack.
     * The new element becomes the new top of the stack.
     * @param value the PrintJob object to be added to the stack
     * @override push method from StackADT interface
     */
    @Override
    public void push(PrintJob value) {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_stacks.php
        // how to push to stacks efficiently
        LinkedNode<PrintJob> newNode = new LinkedNode<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    /*
     * Removes and returns the top element of the stack.
     * If the stack is empty, returns null.
     * @return the PrintJob object at the top of the stack, null if none
     * @override pop method from StackADT interface
     */
    @Override
    public PrintJob pop() {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_stacks.php
        // how to pop elements from stacks efficiently
        if (isEmpty()) {
            return null;
        }
        PrintJob result = top.getData();
        top = top.getNext();
        size--;
        return result;
    }
    /*
     * Returns the top element of the stack without removing it.
     * If the stack is empty, returns null.
     * @return the PrintJob object at the top of the stack, null if none
     * @override peek method from StackADT interface
     */
    @Override
    public PrintJob peek() {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_stacks.php
        // how to push to peek efficiently
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }
    /*
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     * @override size method from StackADT interface
     */
    @Override
    public int size() {
        return size;
    }
    /*
     * Checks if the stack contains a specific element.
     * @param value the PrintJob object to be checked
     * @return true if the stack contains the element, false otherwise
     * @override contains method from StackADT interface
     */
    @Override
    public boolean contains(PrintJob value) {
        // Cite: W3 schools - https://www.w3schools.com/dsa/dsa_data_stacks.php
        // how to check for contains to stacks efficiently
        LinkedNode<PrintJob> current = top;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    /*
     * Clears the stack by removing all elements.
     * The top reference is set to null, and the size is set to 0.
     * @override clear method from StackADT interface
     */
    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    /*
     * Returns an list of PrintJob objects in the stack.
     * The list is created with the size of the stack.
     * @return a list of PrintJob objects in the stack
     */
    public PrintJob[] getList() {
        PrintJob[] result = new PrintJob[size];
        PrintJob[] r = new PrintJob[0];
        if (isEmpty()) {
            return r;
        }
        LinkedNode<PrintJob> current = top;
        for (int i = 0; i < size; i++) {
            if (current == null) {
                break;
            }
            result[i] = current.getData();
            current = current.getNext();
        }
        return result;
    }
}
