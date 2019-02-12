import exceptions.EmptyQueueException;
import exceptions.TooSmallPriorityException;

class Queue {
    private Node firstNode;
    private Node lastNode;
    private int queueSize;
    private int priorityCounter;
    private int highestPriority;
    private int SMALLEST_PRIORITY = 1;
    private int EMPTY_QUEUE;


    Queue() {
        this.firstNode = null;
        this.lastNode = null;
        this.queueSize = 0;
        this.priorityCounter = 0;
        this.highestPriority = 1;
        this.EMPTY_QUEUE = 0;
    }


    void enqueue(String value) {
        throwExceptionWhenValueNull(value);

        if(queueSize == EMPTY_QUEUE) {
            setFirstNode(value);
        }else {
            setNode(value);
        }

        this.queueSize++;
    }



    void enqueue(String value, int priority) throws TooSmallPriorityException {

        throwExceptionWhenValueNull(value);

        throwExceptionWhenPriorityTooLow(priority);

        setFirstNodeWhenHighestPriority(value, priority);

        if(queueSize == EMPTY_QUEUE) {
            setFirstNodeWithPriority(value, priority);
        }else {
            setNodeWithPriority(value, priority);
        }

        this.priorityCounter++;
        this.queueSize++;
    }


    String peek() throws EmptyQueueException {
        throwExceptionWhenQueueEmpty();
        return this.firstNode.getValue();
    }


    String dequeue() throws EmptyQueueException{
        throwExceptionWhenQueueEmpty();

        String value = this.firstNode.getValue();
        int FIRST_NODE_PRIORITY = firstNode.getPriority();
        int SECOND_NODE_PRIORITY = firstNode.getNextNode().getPriority();

        setNewHighestPriority(FIRST_NODE_PRIORITY, SECOND_NODE_PRIORITY);
        decreasePriorityCounter(FIRST_NODE_PRIORITY);

        this.firstNode = this.firstNode.getNextNode();
        queueSize--;
        return value;
    }



    int getQueueSize() {
        return this.queueSize;
    }


    boolean isEmpty() {
        return this.queueSize > EMPTY_QUEUE;
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


    private void throwExceptionWhenValueNull(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }


    private void throwExceptionWhenPriorityTooLow(int priority) throws TooSmallPriorityException {
        if(priority < SMALLEST_PRIORITY) {
            throw new TooSmallPriorityException("Too small priority!");
        }
    }


    private void setFirstNodeWhenHighestPriority(String value, int priority) {
        if(priority > highestPriority) {
            this.highestPriority = priority;
            Node tempNode = firstNode;
            firstNode = new Node(value, priority);
            firstNode.setNextNode(tempNode);
        }
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


    private void throwExceptionWhenQueueEmpty() throws EmptyQueueException {
        if(queueSize == EMPTY_QUEUE) {
            throw new EmptyQueueException("Empty queue");
        }
    }


    private void decreasePriorityCounter(int FIRST_NODE_PRIORITY) {

        if(FIRST_NODE_PRIORITY > SMALLEST_PRIORITY) {
            priorityCounter--;
        }
    }

    private void setNewHighestPriority(int FIRST_NODE_PRIORITY, int SECOND_NODE_PRIORITY) {
        if(FIRST_NODE_PRIORITY > SECOND_NODE_PRIORITY) {
            this.highestPriority = firstNode.getNextNode().getPriority();
        }
    }

}
