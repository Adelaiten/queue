public class Queue {
    private Node firstNode;
    private Node lastNode;
    private int queueSize;


    public Queue() {
        this.firstNode = null;
        this.lastNode = null;
        this.queueSize = 0;
    }


    public void enqueue(String value) {
        if(queueSize == 0) {
            this.firstNode = new Node(value);
            this.lastNode = this.firstNode;
        }else {
            Node tempNode = new Node(value);
            lastNode.setNextNode(tempNode);
            lastNode = tempNode;
        }
        queueSize++;

    }


    public String peek() {
        return null;
    }


    public String dequeue() {
        return null;
    }


    public int getQueueSize() {
        return this.queueSize;
    }


    public boolean isEmpty() {
        return true;
    }
}
