import java.util.NoSuchElementException;
public class PrintManager extends Object{
    private PrintJobQueue printQueue; // reference to the print job queue
    private PrintJobStack printHistoryStack; // reference to the print job stack
    public PrintManager() {
        printQueue = new PrintJobQueue(); // initialize the print job queue
        printHistoryStack = new PrintJobStack(); // initialize the print job stack
    }

    public boolean submitJob(PrintJob print) {
        if (print == null) {
            return false; // invalid print job
        }
        if (printQueue.contains(print)) {
            return false; // print job already exists in the queue
        }
        printQueue.enqueue(print); // add the print job to the queue
        return true; // print job submitted successfully
    }

    public int getJobCount() {
        return printQueue.size(); // return the number of print jobs in the queue
    }

    public PrintJob printNextJob() {
        if (printQueue.isEmpty()) {
            throw new NoSuchElementException("No print jobs in the queue"); // no print jobs in the queue
        }
        PrintJob print = printQueue.dequeue(); // get the next print job from the queue
        printHistoryStack.push(print); // add the print job to the history stack
        return print; // return the next print job
    }

    public void reprintLastJob() {
        if (printHistoryStack.isEmpty()) {
            throw new NoSuchElementException("No print jobs in the history stack"); // no print jobs in the history stack
        }
        PrintJob print = printHistoryStack.pop(); // get the last print job from the history stack
        printQueue.enqueue(print); // add the print job back to the queue
    }

    public void resetPrinting() {
        printQueue.clear(); // clear the print job queue
    }

    public void clearPrintHistory() {
        printHistoryStack.clear(); // clear the print job history stack
    }

    public boolean containsJob(PrintJob print) {
        if (print == null) {
            throw new IllegalArgumentException("Invalid print job"); // invalid print job
        }
        return printQueue.contains(print); // check if the print job exists in the queue
    }

    public String viewPendingJobs() {
        PrintJob [] jobs = printQueue.getList(); 
        if (jobs == null) {
            return ""; // no print jobs in the queue
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jobs.length; i++) {
            sb.append(jobs[i].toString()); // or customize this
            if (i < jobs.length - 1) {
                sb.append("\n"); // only add newline between elements, not after last
            }
        }
        String result = sb.toString(); 
        return result;
    }

    public String viewCompletedJobs() {
        PrintJob [] jobs = printHistoryStack.getList(); 
        if (jobs == null) {
            return ""; // no print jobs in the queue
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jobs.length; i++) {
            sb.append(jobs[i].toString()); // or customize this
            if (i < jobs.length - 1) {
                sb.append("\n"); // only add newline between elements, not after last
            }
        }
        String result = sb.toString(); 
        return result;
    }
}
