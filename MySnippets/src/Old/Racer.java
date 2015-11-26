package Old;

import java.util.LinkedList;
import java.util.List;

class Racer {

	  public int id;

	  public long start;

	  public long end;

	  public int score;

	  public Racer(String[] data) {
	    this.id = Integer.parseInt(data[0]);
	    this.start = Long.parseLong(data[1]);
	    this.end = Long.parseLong(data[2]);
	  }

	  @Override
	  public String toString() {
	    return id + " " + score;
	  }
	  
	  public List<Racer> subList = new LinkedList();

	}
