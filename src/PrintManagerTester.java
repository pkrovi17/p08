// TODO Add Complete File Header

import java.util.NoSuchElementException;
/**
 * Tester class for testing the functionality of the PrintJobQueue, PrintJobStack, and PrintManager
 * classes.
 */
public class PrintManagerTester {
  // TODO implement each of the tester methods

  /**
   * Test the behavior of adding one or more elements to a PrintJobStack.
   *
   * This tester ensures the correctness of PrintJobStack push, peek, isEmpty, size, and contains
   * operations.
   *
   * @return true if elements are correctly added to the stack, false otherwise
   */
  public static boolean testStackPushPeekIsEmptySizeContains() {
    // Test Case 1: Add one element to an empty stack (push and peek and is empty and size)
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob job1 = new PrintJob("Document1",  5);
      stack.push(job1);
      // Check if the stack is not empty
      if (stack.isEmpty()) {
        return false;
      }
      // Check if the size is 1
      if (stack.size() != 1) {
        return false;
      }
      // Check if the top element is job1
      if (!stack.peek().equals(job1)) {
        return false; 
      }
    }
    // Test Case 2: Add multiple elements to the stack (push and peek)
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      stack.push(job1);
      stack.push(job2);
      // Check if the stack is not empty
      if (stack.isEmpty()) {
        return false;
      }
      // Check if the size is 2
      if (stack.size() != 2) {
        return false;
      }
      // Check if the top element is job2
      if (!stack.peek().equals(job2)) {
        return false; 
      }
    }
    // Test Case 3: Check if the stack contains a specific element (push and contains)
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      stack.push(job1);
      stack.push(job2);

      // Check if the stack contains job1 and job2
      if (!(stack.contains(job1) && stack.contains(job2))) {
        return false; // Test passed
      }
    }
    // Test Case 4: Check if the stack does not contain an element not in the stack (contains)
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      stack.push(job1);

      // Check if the stack does not contain job2
      if (stack.contains(job2)) {
        return false; // Test passed
      }
    }
    return true;
  }

  /**
   * Test the behavior of removing one or more elements from the stack (PrintJobStack.pop)
   *
   * @return true if elements are correctly removed from the stack, false otherwise
   */
  public static boolean testStackPop() {
        // Test Case 5: Check if the stack is empty after clearing (clear)
        {
          PrintJobStack stack = new PrintJobStack();
          PrintJob job1 = new PrintJob("Document1", 5);
          stack.push(job1);
          stack.clear();
          // Check if the stack is empty
          if (!stack.isEmpty()) {
            return false; 
          }
        }
        // Test Case 6: Check if the stack size is 0 after clearing (clear)
        {
          PrintJobStack stack = new PrintJobStack();
          PrintJob job1 = new PrintJob("Document1", 5);
          stack.push(job1);
          stack.clear();
          // Check if the size is 0
          if (stack.size() != 0) {
            return false; 
          }
        }
        // Test Case 7: Check if the stack is empty after popping all elements (pop)
        {
          PrintJobStack stack = new PrintJobStack();
          PrintJob job1 = new PrintJob("Document1", 5);
          PrintJob job2 = new PrintJob("Document2", 10);
          stack.push(job1);
          stack.push(job2);
          stack.pop();
          stack.pop(); 
          // Check if the stack is empty
          if (!stack.isEmpty()) {
            return false; 
          }
        }
    return true; 
  }

  /**
   * Test the behavior of getting the list of elements in the stack (PrintJobStack.getList).
   *
   * @return true if this tester verifies a correct functionality, false otherwise.
   */
  public static boolean testGetListStack() {
    // Test Case 1: Get the list of elements in an empty stack
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob[] result = stack.getList();
      // Check if the result is an empty array
      if (result.length != 0) {
        return false;
      }
    }
    // Test Case 2: Get the list of elements in a non-empty stack
    {
      PrintJobStack stack = new PrintJobStack();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      stack.push(job1);
      stack.push(job2);
      // Get the list of elements
      PrintJob[] result = stack.getList();
      // Check if the result contains job1 and job2 in the correct order
      if (!(result.length == 2 && result[0].equals(job2) && result[1].equals(job1))) {
        return false;
      }
    }
    return true;
  }


  /**
   * Test the behavior of adding one or more elements to the queue (PrintJobQueue.enqueue).
   *
   * @return true if elements are correctly added to the queue, false otherwise
   */
  public static boolean testQueueEnqueue() {
    // Test Case 1: Add one element to an empty queue (enqueue and peek and is empty and size)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      queue.enqueue(job1);
      // Check if the queue is not empty
      if (queue.isEmpty()) {
        return false;
      }
      // Check if the size is 1
      if (queue.size() != 1) {
        return false;
      }
      // Check if the front element is job1
      if (!queue.peek().equals(job1)) {
        return false;
      }
    }
    // Test Case 2: Add multiple elements to the queue (enqueue and peek)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);
      queue.enqueue(job2);
      // Check if the queue is not empty
      if (queue.isEmpty()) {
        return false;
      }
      // Check if the size is 2
      if (queue.size() != 2) {
        return false;
      }
      // Check if the front element is job1
      if (!queue.peek().equals(job1)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Test the behavior of PrintJobQueue isEmpty, peek, size, and contains when considering an empty
   * and a non-empty queue.
   *
   * @return true if this tester verifies a correct functionality, false otherwise
   */
  public static boolean testQueueIsEmptyPeekSizeContains() {
    // Test Case 1: Check if the queue is empty (isEmpty)
    {
      PrintJobQueue queue = new PrintJobQueue();
      if (!queue.isEmpty()) {
        return false;
      }
    }
    // Test Case 2: Check if the queue is not empty (isEmpty)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      queue.enqueue(job1);
      // Check if the queue is not empty
      if (queue.isEmpty()) {
        return false;
      }
    }
    // Test Case 3: Check the size of the queue (size)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      queue.enqueue(job1);

      // Check if the size is 1
      if (queue.size() != 1) {
        return false;
      }
    }
    // Test Case 4: Check if the queue contains a specific element (contains)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);

      // Check if the queue contains job1 and does not contain job2
      if (!(queue.contains(job1) && !queue.contains(job2))) {
        return false;
      }
    }
    // Test Case 5: Check if the queue does not contain an element not in the queue (contains)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);

      // Check if the queue does not contain job2
      if (queue.contains(job2)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Test the behavior of removing one or more elements from the queue. Consider the case of
   * dequeuing from (1) an empty queue, (2) a queue that contains only one element, (3) a queue that
   * contains multiple elements.
   *
   * @return true if elements are correctly removed from the queue, false otherwise
   */
  public static boolean testQueueRemove() {
    // Test Case 1: Check if the queue is empty after clearing (clear)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      queue.enqueue(job1);
      queue.clear();
      // Check if the queue is empty
      if (!queue.isEmpty()) {
        return false;
      }
    }
    // Test Case 2: Check if the queue size is 0 after clearing (clear)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      queue.enqueue(job1);
      queue.clear();
      // Check if the size is 0
      if (queue.size() != 0) {
        return false;
      }
    }
    // Test Case 3: Check if the queue is empty after dequeuing all elements (dequeue)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);
      queue.enqueue(job2);
      queue.dequeue(); // dequeue job1
      queue.dequeue(); // dequeue job2
      // Check if the queue is empty
      if (!queue.isEmpty()) {
        return false;
      }
    }
    // Test Case 4: Check if the queue size is 0 after dequeuing all elements (dequeue)
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);
      queue.enqueue(job2);
      queue.dequeue(); // dequeue job1
      queue.dequeue(); // dequeue job2
      // Check if the size is 0
      if (queue.size() != 0) {
        return false;
      }
    }
    return true; 
  }

  /**
   * Test the behavior of getting the list of elements in the queue (PrintJobQueue.getList).
   *
   * @return true if this tester verifies a correct functionality, false otherwise.
   */
  public static boolean testGetListQueue() {
    // Test Case 1: Get the list of elements in an empty queue
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob[] result = queue.getList();
      // Check if the result is an empty array
      if (result.length != 0) {
        return false;
      }
    }
    // Test Case 2: Get the list of elements in a non-empty queue
    {
      PrintJobQueue queue = new PrintJobQueue();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      queue.enqueue(job1);
      queue.enqueue(job2);
      // Get the list of elements
      PrintJob[] result = queue.getList();
      // Check if the result contains job1 and job2 in the correct order
      if (!(result.length == 2 && result[0].equals(job1) && result[1].equals(job2))) {
        return false;
      }
    }
    return true;
  }


  /**
   * Test the submission of one or more new print jobs to the print queue.
   *
   * This tester verifies the correctness of PrintManager submitJob, getJobCount, containsJob, and
   * viewPendingJobs operations.
   *
   * @return true if this tester verifies a correct functionality, false otherwise.
   */
  public static boolean testSubmitJobGetJobCountContainsJobViewPendingJobs() {
    // Test Case 1: Submit one job to an empty queue (submitJob and getJobCount and containsJob)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      manager.submitJob(job1);
      // Check if the job count is 1
      if (manager.getJobCount() != 1) {
        return false;
      }
      // Check if the queue contains job1
      if (!manager.containsJob(job1)) {
        return false;
      }
    }
    // Test Case 2: Submit multiple jobs to the queue (submitJob and getJobCount and containsJob)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      manager.submitJob(job2);
      // Check if the job count is 2
      if (manager.getJobCount() != 2) {
        return false;
      }
      // Check if the queue contains job1 and job2
      if (!(manager.containsJob(job1) && manager.containsJob(job2))) {
        return false;
      }
    }
    // Test Case 3: Check if the queue does not contain a job not in the queue (containsJob)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      // Check if the queue does not contain job2
      if (manager.containsJob(job2)) {
        return false;
      }
    }
    // Test Case 4: View pending jobs in the queue (viewPendingJobs)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      manager.submitJob(job2);
      // Check if the viewPendingJobs returns the correct string representation
      String expectedOutput = "Document1: 5 pages\nDocument2: 10 pages";
      if (!manager.viewPendingJobs().equals(expectedOutput)) {
        return false;
      }
    }
    // Test Case 5: Check if the viewPendingJobs returns an empty string for an empty queue
    {
      PrintManager manager = new PrintManager();
      // Check if the viewPendingJobs returns an empty string
      if (!manager.viewPendingJobs().equals("")) {
        return false;
      }
    }
    return true; 
  }


  /**
   * Test processing and printing the next job in the queue.
   *
   * @return true if the job is successfully printed and added to the history, false otherwise.
   */
  public static boolean testPrintNextJobViewCompletedJobs() {
    // Test Case 1: Print the next job from an empty queue (printNextJob and viewCompletedJobs)
    {
      PrintManager manager = new PrintManager();
      try {
        manager.printNextJob(); // should throw an exception
        return false;
      } catch (NoSuchElementException e) {
        // Expected exception
      }
    }
    // Test Case 2: Print the next job from a non-empty queue (printNextJob and viewCompletedJobs)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      manager.submitJob(job1);
      manager.printNextJob(); // print job1
      // Check if the completed jobs contain job1
      String expectedOutput = "Document1: 5 pages";
      if (!manager.viewCompletedJobs().equals(expectedOutput)) {
        return false; 
      }
    }
    // Test Case 3: Check if the queue is empty after printing all jobs (printNextJob)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      manager.submitJob(job2);
      manager.printNextJob(); // print job1
      manager.printNextJob(); // print job2
      // Check if the queue is empty
      if (manager.getJobCount() != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Test reprinting the last completed job for a given document type.
   *
   * @return true if the last job is successfully moved back to the print queue, false otherwise.
   */
  public static boolean testReprintLastJob() {
    // Test Case 1: Reprint the last job from an empty history stack (reprintLastJob)
    {
      PrintManager manager = new PrintManager();
      try {
        manager.reprintLastJob(); // should throw an exception
        return false;
      } catch (NoSuchElementException e) {
        // Expected exception
      }
    }
    // Test Case 2: Reprint the last job from a non-empty history stack (reprintLastJob)
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      manager.submitJob(job1);
      manager.printNextJob(); // print job1
      manager.reprintLastJob(); // reprint job1
      // Check if the queue contains job1 again
      if (!manager.containsJob(job1)) {
        return false; 
      }
    }
    return true;
  }


  /**
   * Test clearing all pending print jobs from the queue.
   *
   * @return true if the print queue is empty after reset, false otherwise.
   */
  public static boolean testResetPrinting() {
    // Test Case 1: No pending print job (empty queue)
    {
      PrintManager manager = new PrintManager();
      manager.resetPrinting(); // reset printing
      // Check if the queue is empty
      if (manager.getJobCount() != 0) {
        return false; 
      }
    }
    // Test Case 2: clear a non-empty pending print job queue
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      manager.submitJob(job2);
      manager.resetPrinting(); // reset printing
      // Check if the queue is empty
      if (manager.getJobCount() != 0) {
        return false; 
      }
    }
    return true;
  }

  /**
   * Test clearing the print history for a specific document type.
   *
   * @return true if the history for the given type is successfully cleared, false otherwise.
   */
  public static boolean testClearPrintHistory() {
    // Test Case 1: No print history (empty stack)
    {
      PrintManager manager = new PrintManager();
      manager.clearPrintHistory(); // clear history
      // Check if the history stack is empty
      if (!manager.viewCompletedJobs().equals("")) {
        return false; 
      }
    }
    // Test Case 2: clear a non-empty print history stack
    {
      PrintManager manager = new PrintManager();
      PrintJob job1 = new PrintJob("Document1", 5);
      PrintJob job2 = new PrintJob("Document2", 10);
      manager.submitJob(job1);
      manager.submitJob(job2);
      manager.printNextJob(); // print job1
      manager.clearPrintHistory(); // clear history
      // Check if the history stack is empty
      if (!manager.viewCompletedJobs().equals("")) {
        return false; 
      }
    }
    return true;
  }


  /**
   * Main method to run the tester methods
   *
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    // Running and printing results for all the tests

    boolean test1 = testStackPushPeekIsEmptySizeContains();
    System.out.println("testStackAdd: " + (test1 ? "PASS" : "FAIL"));

    boolean test2 = testStackPop();
    System.out.println("testStackRemove: " + (test2 ? "PASS" : "FAIL"));

    boolean test3 = testGetListStack();
    System.out.println("testGetListStack: " + (test3 ? "PASS" : "FAIL"));

    boolean test4 = testQueueEnqueue();
    System.out.println("testQueueEnqueue: " + (test4 ? "PASS" : "FAIL"));

    boolean test5 = testQueueIsEmptyPeekSizeContains();
    System.out.println("testQueueIsEmptyPeekSizeContains: " + (test5 ? "PASS" : "FAIL"));

    boolean test6 = testQueueRemove();
    System.out.println("testQueueRemove: " + (test6 ? "PASS" : "FAIL"));

    boolean test7 = testGetListQueue();
    System.out.println("testGetListQueue: " + (test7 ? "PASS" : "FAIL"));

    boolean test8 = testSubmitJobGetJobCountContainsJobViewPendingJobs();
    System.out.println("testSubmitJobGetJobCountContainsJobViewPendingJobs: " + (test8 ? "PASS" : "FAIL"));

    boolean test9 = testPrintNextJobViewCompletedJobs();
    System.out.println("testPrintNextJobViewCompletedJobs: " + (test9 ? "PASS" : "FAIL"));

    boolean test10 = testReprintLastJob();
    System.out.println("testReprintLastJob: " + (test10 ? "PASS" : "FAIL"));

    boolean test11 = testResetPrinting();
    System.out.println("testResetPrinting: " + (test11 ? "PASS" : "FAIL"));

    boolean test12 = testClearPrintHistory();
    System.out.println("testClearHistory: " + (test12 ? "PASS" : "FAIL"));

    System.out.println(
        "ALL TESTS: " + (test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8 && test9 && test10 && test11 && test12 ?
            "PASS" :
            "FAIL"));
  }
}
