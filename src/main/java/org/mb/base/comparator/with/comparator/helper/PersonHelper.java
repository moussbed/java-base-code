package org.mb.base.comparator.with.comparator.helper;

import org.mb.base.comparator.with.comparator.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonHelper {

    public static Comparator<Person> comparatorMultiField;

    static {
        comparatorMultiField = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // It first compare the name after id
                Comparator<Person> comparator = Comparator.comparing(person -> person.getName());
                comparator = comparator.thenComparingLong(person -> person.getId());
                return comparator.compare(o1, o2);
            }
        };

    }

    public static int compareById(Person p1, Person p2) {
        return Long.compare(p1.getId(), p2.getId());
    }

    public static int compareByName(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }


    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person(5, "Aicha"), new Person("Dominique"), new Person(5, "Aïcha"),new Person(20, "Aïcha"), new Person(4, "Kone"));
        System.out.println(personList); // [Person{id=5, name='Aicha'}, Person{id=0, name='Dominique'}, Person{id=5, name='Aïcha'}, Person{id=20, name='Aïcha'}, Person{id=4, name='Kone'}]

        // Sort by id using lambda expression
        Collections.sort(personList,(p1, p2) -> PersonHelper.compareById(p1,p2));
        System.out.println(personList); // [Person{id=0, name='Dominique'}, Person{id=4, name='Kone'}, Person{id=5, name='Aicha'}, Person{id=5, name='Aïcha'}, Person{id=20, name='Aïcha'}]

        // Sort by name using method reference
        Collections.sort(personList,PersonHelper::compareByName);
        System.out.println(personList); // [Person{id=5, name='Aicha'}, Person{id=5, name='Aïcha'}, Person{id=20, name='Aïcha'}, Person{id=0, name='Dominique'}, Person{id=4, name='Kone'}]

        // Sort using multifield without Collections Api
        personList.sort(PersonHelper.comparatorMultiField);
        System.out.println(personList);// [Person{id=5, name='Aicha'}, Person{id=5, name='Aïcha'}, Person{id=20, name='Aïcha'}, Person{id=0, name='Dominique'}, Person{id=4, name='Kone'}]


    }
}
