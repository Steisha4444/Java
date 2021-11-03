package lab2;
import com.fasterxml.jackson.annotation.JsonProperty;
import comparators.WorkerAgeComparator;
import comparators.WorkerNameComparator;

import java.sql.Array;
import java.util.*;
public class Company extends Worker{

    int id;

    String Name;

    List<Worker> workers  ;

    public Company(){};
    public Company(int id, String name , List<Worker> w) {
        this.id=id;
        this.Name=name;
        this.workers= w;
        //   for (int i=0 ; i <= w.length; i++) {
        //   this.workers.add(w[i]);
        //  }
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public List<Worker> getWorkers() {
        return workers;
    }
    public void setId(int id) {

        this.id = id;
    }
    public void setName(String Lname) {
        this.Name = Lname;

    }
    public void setWorkers(List<Worker> w) {
        this.workers = w;
    }
    @Override
    public String toString() {
        return "Company-Id " + id + " ,Name of Company " + Name +  " , Worker \n" +  workers.toString() ;
    }

    public void sortByCompareTo(){
        workers.sort(Worker::compareTo);

    }
    public void sortByAge(){
        workers.sort(new WorkerAgeComparator());

    }

    public void sortByAgeAndName(){
        Comparator<Worker> tcomp = new WorkerAgeComparator().thenComparing(new WorkerNameComparator());
        workers.sort(tcomp);
    }


    public Worker[] greaterThan(int age) {
        List<Worker> list = new ArrayList<>();
        for (Worker a : workers) {
            if (a.getAge() > age) {
                list.add(a);
            }
        }
        return list.toArray(new Worker[0]);
    }

    public Worker[] greaterThanStream( int age) {
        return workers
                .stream()
                .filter((a) -> a.getAge() > age)
                .toArray(Worker[]::new);
    }

    public Worker[] lessThan( int age) {
        List<Worker> list = new ArrayList<>();
        for (Worker a : workers) {
            if (a.getAge() < age) {
                list.add(a);
            }
        }
        return list.toArray(new Worker[0]);
    }


    public Worker[] lessThanStream( int age) {
        return workers
                .stream()
                .filter((a) -> a.getAge() < age)
                .toArray(Worker[]::new);
    }

    public Worker[] filterSteam( String name) {
        return workers
                .stream()
                .filter((a) -> a.getLastName().equals(name))
                .toArray(Worker[]::new);
    }

    public Worker[] filter(String name) {
        List<Worker> list = new ArrayList<>();
        for (Worker a : workers){
            if (a.getLastName().equals(name)) {
                list.add(a);
            }
        }
        return list.toArray(new Worker[0]);
    }
    public int compareTo( Company a) {
        if (id == a.id) {
                if (Name.length() == a.Name.length()) {
                    for (int i = 0; i < workers.size() - 1; i++) {
                        if ( (workers.get(i).compareTo(a.workers.get(i)))>0) {
                            return (workers.get(i).compareTo(a.workers.get(i)));
                        }
                    }
                    return Name.compareTo(a.Name);
                }
            return Name.length() - a.Name.length();
        }
        return id - a.id;
    }

}


