package org.mb.base.comparator.with.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Duck implements Comparable<Duck> {
    private int id;
    private String name;

    public Duck(String name) {
        this(0, name);
    }

    public Duck(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Duck o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Duck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Duck> duckList = Arrays.asList(new Duck(12, "Manjo"), new Duck("Aamo"), new Duck(2, "Yes"));
        System.out.println(duckList); // [Duck{id=12, name='Manjo'}, Duck{id=0, name='Aamo'}, Duck{id=2, name='Yes'}]
        Collections.sort(duckList); //   Sort use implementation of compareTo() in the class Duck implementing Comparable interface
        System.out.println(duckList);//  [Duck{id=0, name='Aamo'}, Duck{id=12, name='Manjo'}, Duck{id=2, name='Yes'}]
    }
}
