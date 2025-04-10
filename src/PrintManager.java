//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Print Structure Management System
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
// Online Sources:  W3 schools, Simplilearn
//                  - https://www.w3schools.com/dsa/dsa_data_queues.php
//                  - https://www.w3schools.com/dsa/dsa_data_stacks.php
//                  - https://www.simplilearn.com/tutorials/java-tutorial/stringbuilder-in-java
//
///////////////////////////////////////////////////////////////////////////////
// imports
import java.util.NoSuchElementException;

/*
 * This class implements a print manager that manages print jobs using a queue and a stack.
 * The queue is used to store pending print jobs, while the stack is used to store completed print jobs.
 */
public class PrintManager extends Object{
    private PrintJobQueue printQueue; // reference to the print job queue
    private PrintJobStack printHistoryStack; // reference to the print job stack
    /*
     * Constructor initializes the print manager with an empty print job queue and stack.
     */
    public PrintManager() {
        printQueue = new PrintJobQueue(); // initialize the print job queue
        printHistoryStack = new PrintJobStack(); // initialize the completed job stack
    }
    /*
     * Submits a new print job to the print manager.
     * If the print job is null or already exists in the queue, it returns false.
     * Otherwise, it adds the print job to the queue and returns true.
     * @param print the PrintJob object to be submitted
     * @return true if the print job was successfully submitted, false otherwise
     */
    public boolean submitJob(PrintJob print) {
        // invalid job
        if (print == null) {
            return false;
        }
        // already contains
        if (printQueue.contains(print)) {
            return false;
        }
        // add to queue
        printQueue.enqueue(print);
        return true;
    }
    /*
     * Returns the number of print jobs in the queue.
     * @return the number of print jobs in the queue
     */
    public int getJobCount() {
        return printQueue.size();
    }
    /*
     * Prints the next print job in the queue.
     * If the queue is empty, it throws a NoSuchElementException.
     * Dequeues the next print job from the queue and adds it to the history stack.
     * @return the next print job in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public PrintJob printNextJob() {
        if (printQueue.isEmpty()) {
            throw new NoSuchElementException("No print jobs in the queue");
        }
        PrintJob print = printQueue.dequeue();
        printHistoryStack.push(print);
        return print;
    }
    /*
     * Reprints the last print job that was printed.
     * If there are no completed print jobs in the history stack, it throws a NoSuchElementException.
     * Pops the last print job from the history stack and adds it back to the queue.
     * @throws NoSuchElementException if there are no completed print jobs in the history stack
     */
    public void reprintLastJob() {
        if (printHistoryStack.isEmpty()) {
            throw new NoSuchElementException("No print jobs in the history stack"); 
        }
        PrintJob print = printHistoryStack.pop(); 
        printQueue.enqueue(print); 
    }
    /*
     * Resets the print manager by clearing the print job queue.
     * This method is used to reset the state of the print manager job queue.
     */
    public void resetPrinting() {
        printQueue.clear();
    }
    /*
     * Clears the print job history stack.
     * This method is used to reset the state of the print manager job history stack.
     */
    public void clearPrintHistory() {
        printHistoryStack.clear(); 
    }
    /*
     * Checks if the print job queue contains a specific print job.
     * @param print the PrintJob object to be checked
     * @return true if the queue contains the specified print job, false otherwise
     * @throws IllegalArgumentException if the print job is null
     */
    public boolean containsJob(PrintJob print) {
        if (print == null) {
            throw new IllegalArgumentException("Invalid print job"); 
        }
        return printQueue.contains(print); 
    }
    /*
     * Returns a string representation of the pending print jobs in the queue.
     * If there are no print jobs in the queue, it returns an empty string.
     * @return a string representation of the pending print jobs in the queue
     */
    public String viewPendingJobs() {
        PrintJob [] jobs = printQueue.getList(); 
        if (jobs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jobs.length; i++) {
            sb.append(jobs[i].toString()); 
            if (i < jobs.length - 1) {
                sb.append("\n"); 
            }
        }
        String result = sb.toString(); 
        return result;
    }
    /*
     * Returns a string representation of the completed print jobs in the history stack.
     * If there are no completed print jobs in the history stack, it returns an empty string.
     * @return a string representation of the completed print jobs in the history stack
     */
    public String viewCompletedJobs() {
        // Cite: Simplilearn - https://www.simplilearn.com/tutorials/java-tutorial/stringbuilder-in-java
        // how to use string builder
        PrintJob [] jobs = printHistoryStack.getList(); 
        if (jobs == null) {
            return ""; 
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jobs.length; i++) {
            sb.append(jobs[i].toString()); 
            if (i < jobs.length - 1) {
                sb.append("\n");
            }
        }
        String result = sb.toString(); 
        return result;
    }
}
