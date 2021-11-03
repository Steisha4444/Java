package comparators;


import lab2.Worker;

import java.util.Comparator;

public class WorkerAgeComparator implements Comparator<Worker>{

    @Override
    public int compare(Worker a1,  Worker a2) {
        return a1.getAge() - a2.getAge();
    }
}
