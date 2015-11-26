import java.util.concurrent.locks;
import java.util.List;
import java.util.LinkedList;

public final class ThreadPool {
  protected BlockingQueue tasks = null;
  private List<ThreadImpl> threads = new ArrayList<ThreadImpl>();
  private boolean isStopped = false;

  public ThreadPool(int threadSize, int maxTasks) {
    taskQueue = new BlockingQueue(maxTasks);

    for(int i=0; i<threadSize; i++){
      threads.add(new ThreadImpl(tasks));
    }
    for(ThreadImpl thread : threads){
      thread.start();
    }
  }

  public void synchronized execute(Runnable task) {
    if(this.isStopped) throw new IllegalStateException("ThreadPool is not running");
    tasks.enqueue(task);
  }

  public synchronized void stop() {
    this.isStopped = true;
    for(ThreadImpl thread : threads) {
      thread.stop();
    }
  }
}


public class ThreadImpl extends Thread {

  private BlockingQueue tasks = null;
  private boolean       isStopped = false;

  public ThreadImpl(BlockingQueue queue){
    tasks = queue;
  }

  public void run(){
    while(!isStopped()){
      try{
        Runnable runnable = (Runnable) tasks.dequeue();
        runnable.run();
      } catch(Exception e) {
      	System.err.println("Error occured: ");
      	e.printStackTrace();
      }
    }
  }
  public synchronized void stop() {
    isStopped = true;
    this.interrupt(); //break pool thread out of dequeue() call.
  }

  public synchronized void isStopped(){
    return isStopped;
  }
}



final class BlockingQueue<T> {
	
	//List that contains all the result.
	protected List list = new LinkedList<T>();
	
	//Max size of elements that the BlockingQueue can hold.
	protected final int max;

	//Create a fixed size of queue
	public BlockingQueue(int max) {
		max = max;
	}

	//Enqueue an element to the list
	public void enqueue(T t) {
    	try {
    		Lock.acquire();
	    	while(list.size() == max) {
    	  		wait();
    		}
	    	if(list.size() == 0) {
    			notifyAll();
    		}
	    	list.add(t);
		} finally {
			Lock.release();
		}
	}
	
	//Dequeue an element from list.
	public T dequeue() {
		try {
			Lock.acquire();
			while(list.size() == 0) {
				wait();
			}
			if(list.size() == max) {
				notifyAll();
			}
			//Remove and return the first element in the list.
			return list.remove(0);
		} finally {
			Lock.release();
		}
	}
}
