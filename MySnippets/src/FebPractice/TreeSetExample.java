package FebPractice;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by venkatesh.d on 28/06/16.
 */
public class TreeSetExample {
    public static void main(String[] args){
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(32);
        ts.add(21);
        ts.add(15);
        ts.add(100);
        ts.add(43);

        Iterator<Integer> iterator = ts.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
