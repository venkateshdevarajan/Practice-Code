package Old;

import java.util.Comparator;

class ScoreComparator implements Comparator<Racer> {

	  @Override
	  public int compare(Racer o1, Racer o2) {
	    if (o1.score == o2.score) {
	      return (int) (o1.id - o2.id);
	    } else {
	      return (int) (o1.score - o2.score);
	    }
	  }

}

