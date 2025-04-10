public class PrintJobStack extends Object implements StackADT<PrintJob> {

    private LinkedNode<PrintJob> top; // reference to the top of the stack
    private int size; // number of elements in the stack

    public PrintJobStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && top == null;
    }

    @Override
    public void push(PrintJob value) {
        LinkedNode<PrintJob> newNode = new LinkedNode<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public PrintJob pop() {
        if (isEmpty()) {
            return null;
        }
        PrintJob result = top.getData();
        top = top.getNext();
        size--;
        return result;
    }

    @Override
    public PrintJob peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(PrintJob value) {
        LinkedNode<PrintJob> current = top;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

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
