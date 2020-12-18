package org.mb.base.comparator.with.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    private long id ;
    private String name ;

    public Person(String name) {
        this(0,name);
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person(10,"Nana"),new Person(2,"Henry"), new Person("Rick"));
        System.out.println(personList); // [Person{id=10, name='Nana'}, Person{id=2, name='Henry'}, Person{id=0, name='Rick'}]

        // As the person class does not implement the interface, we must provide a comparator to the Sort method, since we need a criterion to sort.
        //Otherwise the compilation will not work
        Comparator<Person> personComparator = (Person p1, Person p2) -> Long.compare(p1.getId(), p2.getId());
        Collections.sort(personList,personComparator); //
        System.out.println(personList);// [Person{id=0, name='Rick'}, Person{id=2, name='Henry'}, Person{id=10, name='Nana'}]


    }
}
