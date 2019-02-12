public class Queue {
    private Node firstNode;
    private Node lastNode;
    private int queueSize;
    private int priorityCounter;
    private int highestPriority;


    public Queue() {
        this.firstNode = null;
        this.lastNode = null;
        this.queueSize = 0;
        this.priorityCounter = 0;
        this.highestPriority = 1;
    }


    public void enqueue(String value) {
        if(queueSize == 0) {
            setFirstNode(value);
        }else {
            setNode(value);
        }

        this.queueSize++;
    }


    public void enqueue(String value, int priority) {

        if(priority > highestPriority) {
            setNodeWhenHighestPriority(value, priority);
        }

        if(queueSize == 0) {
            setFirstNodeWithPriority(value, priority);
        }else {
            setNodeWithPriority(value, priority);
        }

        this.priorityCounter++;
        this.queueSize++;
    }



    public String peek() {
        return this.firstNode.getValue();
    }


    public String dequeue() {
        String value = this.firstNode.getValue();
        int FIRST_NODE_PRIORITY = firstNode.getPriority();
        int SECOND_NODE_PRIORITY = firstNode.getNextNode().getPriority();

        if(FIRST_NODE_PRIORITY > SECOND_NODE_PRIORITY) {
            this.highestPriority = firstNode.getNextNode().getPriority();
        }

        if(FIRST_NODE_PRIORITY > 1) {
            priorityCounter--;
        }

        Node node = this.firstNode.getNextNode();
        this.firstNode = node;

        return value;
    }


    public int getQueueSize() {
        return this.queueSize;
    }


    public boolean isEmpty() {
        return this.queueSize > 0;
    }


    private void setNode(String value) {
        Node tempNode = new Node(value);
        this.lastNode.setNextNode(tempNode);
        this.lastNode = tempNode;
    }

    private void setFirstNode(String value) {
        this.firstNode = new Node(value);
        this.lastNode = this.firstNode;
    }


    private void setNodeWhenHighestPriority(String value, int priority) {
        this.highestPriority = priority;
        Node tempNode = firstNode;
        firstNode = new Node(value, priority);
        firstNode.setNextNode(tempNode);
    }


    private void setFirstNodeWithPriority(String value, int priority) {
        this.firstNode = new Node(value, priority);
        this.lastNode = this.firstNode;
    }

    private void setNodeWithPriority(String value, int priority) {
        Node node = firstNode;
        for(int i = 0; i < priorityCounter-1; i++) {
            if(node.getNextNode().getPriority() < priority) {
                Node tempNode = node.getNextNode();
                Node priorityNode = new Node(value, priority);
                priorityNode.setNextNode(tempNode);
                node.setNextNode(priorityNode);
                break;
            }
            node = node.getNextNode();
        }
    }
}
