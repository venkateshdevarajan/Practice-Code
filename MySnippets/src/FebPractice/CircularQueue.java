package FebPractice;

/**
 * Created by venkatesh.d on 06/04/16.
 */
public class CircularQueue {

    int[] queue;
    int front = 0;
    int rear = 0 ;
    int size;

    public CircularQueue(int size){
        this.size = size;
        queue = new int[size];
    }

    public boolean isFull(){
        int diff = rear - front;
        if(diff == -1 || diff == (size))
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(rear==front)
            return true;
        return false;
    }

    public int size(){
        int s;
        if(rear > front){
            s = rear - front;
        }
        else{
            s = size - (rear+front);
        }
        System.out.println("Size of the queue: "+s);
        return s;
    }

    public void enqueue(int item){
        if(!isFull()){
            queue[rear]=item;
            rear = (rear+1)%size;
        }
        else{
            System.out.println("Stack is full");
        }
    }

    public void dequeue(){
        int item;
        if(!isEmpty()){
            item = queue[front];
            front = (front+1) % size;
            System.out.println("Item getting popped : " + item);
        }
        else{
            System.out.println("Stack is already empty");
        }
    }

    public static void main(String[] args){
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        System.out.println(cq.size());
        cq.dequeue();
        cq.enqueue(5);
        System.out.println(cq.size());
        cq.enqueue(6);
        cq.dequeue();
        System.out.println(cq.size());

    }
}
