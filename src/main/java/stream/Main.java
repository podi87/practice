package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    static class AgeAdder {
        LongAdder total = new LongAdder();
        public void accept(Person p) {
            total.add(p.getAge());
        }
    }

    public static void method1() {
        Person a = new Person("First", "stream.Person", 15);
        Person b = new Person("Second", "stream.Person", 20);
        List<Person> ps = Arrays.asList(a, b);
        int totalAge = ps.stream()
                .mapToInt(p -> p.getAge())
                .sum();
        System.out.println(totalAge);
    }

    public static void method2() {
        AgeAdder ageAdder = new AgeAdder();
        Person a = new Person("First", "stream.Person", 15);
        Person b = new Person("Second", "stream.Person", 20);
        List<Person> ps = Arrays.asList(a, b);
        ps.stream()
                .parallel()
                .forEach(ageAdder::accept);
        System.out.println(ageAdder.total.longValue());
    }

    public static void main(String[] args) {
        method1();
        method2();

    }
}
