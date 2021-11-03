package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lab2.*;
import comparators.*;

public class Program {

    static List<Worker> sortByCompareTo(List<Worker> c) {
        c.sort(Worker::compareTo);
        return c;
    }

    static List<Worker> sortByAge(Company c) {
        c.getWorkers().sort(new WorkerAgeComparator());
        return c.getWorkers();
    }

    static List<Worker> sortByAgeAndName(Company c) {
        Comparator<Worker> tcomp = new WorkerAgeComparator().thenComparing(new WorkerNameComparator());
        c.getWorkers().sort(tcomp);
        return c.getWorkers();
    }
//
//    static Worker[] greaterThan(Company c, int age) {
//        List<Worker> list = new ArrayList<>();
//        for (Worker a : c.getWorkers()) {
//            if (a.getAge() > age) {
//                list.add(a);
//            }
//        }
//        return list.toArray(new Worker[0]);
//    }
//
//    static Worker[] greaterThanStream(Company c, int age) {
//        return c.getWorkers()
//                .stream()
//                .filter((a) -> a.getAge() > age)
//                .toArray(Worker[]::new);
//    }
//
//    static Worker[] lessThan(Company c, int age) {
//        List<Worker> list = new ArrayList<>();
//        for (Worker a : c.getWorkers()) {
//            if (a.getAge() < age) {
//                list.add(a);
//            }
//        }
//        return list.toArray(new Worker[0]);
//    }
//
//
//    static Worker[] lessThanStream(Company c, int age) {
//        return c.getWorkers()
//                .stream()
//                .filter((a) -> a.getAge() < age)
//                .toArray(Worker[]::new);
//    }
//
//    static String[] filterSteam(Company c, String name) {
//        return c.getWorkers()
//                .stream()
//                .filter((a) -> a.getLastName().equals(name))
//                .toArray(String[]::new);
//    }
//
//    static String[] filter(Company c, String name) {
//        List<Worker> list = new ArrayList<>();
//        for (Worker a : c.getWorkers()) {
//            if (a.getLastName().equals(name)) {
//                list.add(a);
//            }
//        }
//        return list.toArray(new String[0]);
//    }

    public static void main(String[] args) {

        List<Worker> School = Arrays.asList(
                new Worker(25, "Daniluk", "Bonny"),
                new Worker(23, "Ken", "Fluffy"),
                new Worker(31, "Marsel", "Endy"),
                new Worker(35, "Lem", "Luna"),
                new Worker(41, "Chase", "Jasper")
        );
        Company company = new Company(1, "Collapse", School);
        company.sortByCompareTo();
        System.out.println("Sorted list of \"Collapse\" workers:");
        sortByCompareTo(company.getWorkers()).forEach(a -> System.out.println("\t" + a));

        List<Worker> Flock = Arrays.asList(
                new Teacher(34, "Luna", "Charlie", 1, 23000, "math"),
                new Teacher(30, "Lersew", "Caroline", 1, 24000, "literature"),
                new Teacher(28, "Charlie", "Gradmaster", 2, 20000, "math"),
                new Teacher(35, "Sheles", "Dan", 2, 24000, "biology"),
                new Teacher(38, "Melnuk", "John", 1, 29000, "biology")
        );
        Company company2 = new Company(2, "Kalista", Flock);
        System.out.println("Sorted list of \"Kalista\" teachers:");
        sortByAge(company2).forEach(a -> System.out.println("\t" + a));

        List<Worker> Enclosure = Arrays.asList(
                new Assistant(24, "Brown", "Charlie", 1, 13000, "math", 2.6),
                new Assistant(21, "Black", "Caroline", 1, 14000, "literature", 4.6),
                new Assistant(22, "Boo", "Faer", 2, 10000, "math", 7),
                new Assistant(25, "Boo", "Dandy", 2, 14000, "biology", 1.5),
                new Assistant(24, "Willow", "Jonson", 1, 19000, "biology", 3.4)
        );
        Company company3 = new Company(3, "Black Pearl", Enclosure);
        System.out.println("Sorted list of \"Black Pearl\" Assistants:");
        sortByAgeAndName(company3).forEach(a -> System.out.println("\t" + a));

        System.out.println("\n\nWorkers with age less than 27:");
        Arrays.stream(company.lessThan( 27)).forEach(System.out::println);

        System.out.println("\n\nWorkers with age greater than 27:");
        Arrays.stream(company.greaterThan( 27)).forEach(System.out::println);

        System.out.println("\n\nWorkers filtered by name \"Boo\"");
        Arrays.stream(company3.filter( "Boo")).forEach(System.out::println);

        System.out.println("\n\nWorkers with age less than 27 (Steam):");
        Arrays.stream(company.lessThanStream( 27)).forEach(System.out::println);

        System.out.println("\n\nWorkers with age greater than 27 (Steam):");
        Arrays.stream(company.greaterThanStream( 27)).forEach(System.out::println);

        System.out.println("\n\nWorkers filtered (Steam) by name \"Boo\"");
        Arrays.stream(company3.filterSteam( "Boo")).forEach(System.out::println);



        List<Worker> All = new ArrayList<Worker>();
        All.addAll(School);
        All.addAll(Flock);
        All.addAll(Enclosure);
        System.out.println("List of all workers:");
        All.forEach(a -> System.out.println("\t" + a));

        System.out.println("\n\n1)Sorted list of all workers:");
        All.stream().sorted().forEach(System.out::println);

        System.out.println("\n\n2)List of workers whose Last names start with \'B\':");
        All.stream().filter((a) -> a.getLastName().startsWith("B")).forEach(System.out::println);

        int countOfAssist = (int) All.stream().filter(a -> a instanceof Assistant).count();
        System.out.println("\n\n3)Count of Assistants in list : " + countOfAssist);
    }
}