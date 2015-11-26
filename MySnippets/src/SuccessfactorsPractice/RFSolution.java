import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class RFSolution {

  private static NavigableMap<Long, Racer> startTimeVsRacer = new TreeMap<Long, Racer>();

  private static List<Racer> sortedRacers = new LinkedList();

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    prepareDataSet();
    //System.out.println("DataSet Prepared - Length:" + startTimeVsRacer.size());

    long exeStartTime = System.currentTimeMillis();
    for (Entry<Long, Racer> entry : startTimeVsRacer.entrySet()) {
      NavigableMap<Long, Racer> map = startTimeVsRacer.tailMap(entry.getKey(), false);

      int score = 0;
      for (Entry<Long, Racer> subEntry : map.entrySet()) {
        if (entry.getValue().end > subEntry.getValue().end) {
          score++;
        }
      }
      entry.getValue().score = score;

    }
    Collections.sort(sortedRacers, new ScoreComparator());

    //System.out.println("ExecutionTime - " + (System.currentTimeMillis() - exeStartTime));
    for (Racer racer : sortedRacers) {
      System.out.println(racer);
    }
    
    //System.out.println("ExecutionTime - " + (System.currentTimeMillis() - exeStartTime));
  }

  private static void prepareDataSet() throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\venkateshd\\Desktop\\racer_test\\racer_test\\input03.txt"));

    String line;
    br.readLine();
    while ((line = br.readLine()) != null) {
      String[] data = line.split(" ");
      if (data.length != 3)
        continue;
      Racer racer = new Racer(data);
      startTimeVsRacer.put(racer.start, racer);
      sortedRacers.add(racer);
    }
    br.close();
  }
}

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
