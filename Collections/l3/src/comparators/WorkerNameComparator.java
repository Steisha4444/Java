package comparators;
import lab2.Worker;

import java.util.Comparator;

public class WorkerNameComparator implements Comparator<Worker>{

    @Override
    public int compare(Worker a1,Worker a2) {
        return a1.getFirstName().compareTo(a2.getFirstName());
    }
}
