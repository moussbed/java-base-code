package org.mb.base.comparator.with.comparator.multifield;

import org.mb.base.comparator.with.comparator.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMultiField implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        // It first compares id after name
        Comparator<Person> comparator = Comparator.comparing(person -> person.getId());
        comparator = comparator.thenComparing(person -> person.getName());

        return comparator.compare(o1, o2);
    }

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person(5, "Aicha"), new Person("Dominique"), new Person(5, "Aïcha"), new Person(4, "Kone"));
        System.out.println(personList); // [Person{id=5, name='Aicha'}, Person{id=0, name='Dominique'}, Person{id=5, name='Aïcha'}, Person{id=4, name='Kone'}]
        Collections.sort(personList, new ComparatorMultiField());
        System.out.println(personList); // [Person{id=0, name='Dominique'}, Person{id=4, name='Kone'}, Person{id=5, name='Aicha'}, Person{id=5, name='Aïcha'}]


    }
}
