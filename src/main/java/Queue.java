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
            this.lastNode.setNextNode(tempNode);
            this.lastNode = tempNode;
        }
        queueSize++;

    }


    public String peak() {
        return firstNode.getValue();
    }


    public String dequeue() {
        String value = this.firstNode.getValue();
        Node node = this.firstNode.getNextNode();
        this.firstNode = node;
        return value;
    }


    public int getQueueSize() {
        return this.queueSize;
    }


    public boolean isEmpty() {
        return true;
    }
}
