package org.mb.base.functionalinterfaces;

import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.function.*;

public class OtherFunctonalInterfaces {

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        List<Name> names = generator.generateNames(3);

        DoubleFunction<Person> doubleFunction = (double weight) -> {
            Name name1 = names.get(0);
            return new Person().setFirstname(name1.getFirstName()).setLastname(name1.getLastName()).setGenre(name1.getGender().name()).setWeight(weight);
        };
        Person person = doubleFunction.apply(90.9);
        System.out.println(person); // {"weight":90.9,"firstname":"Bobby","lastname":"Tyler","genre":"MALE","feet":0,"id":0}


        IntFunction<Person> intFunction = (int feet) -> {
            Name name2 = names.get(1);
            return new Person().setLastname(name2.getLastName()).setFirstname(name2.getFirstName()).setGenre(name2.getGender().name()).setFeet(feet);
        };
        Person person1 = intFunction.apply(2);
        System.out.println(person1); // {"weight":0.0,"firstname":"Suzanne","lastname":"Randall","genre":"FEMALE","feet":2,"id":0}


        LongFunction<Person> longFunction = (long id) -> {
            Name name3 = names.get(2);
            return new Person().setId(id).setFirstname(name3.getFirstName()).setLastname(name3.getLastName()).setGenre(name3.getGender().name());
        };
        Person person2 = longFunction.apply(123455);
        System.out.println(person2); // {"weight":0.0,"firstname":"Anna","lastname":"Browning","genre":"FEMALE","feet":0,"id":123455}


        IntUnaryOperator square = (int nombre) -> nombre * nombre;
        int i = square.applyAsInt(7);
        System.out.println(i); // 49

        DoubleUnaryOperator doble = (double nombre) -> nombre * 2;
        double v = doble.applyAsDouble(4);
        System.out.println(v); // 8.0

        LongUnaryOperator triple = (long nombre) -> nombre * 3;
        long l = triple.applyAsLong(12);
        System.out.println(l); // 36


        // IntBinaryOperator add = (int a, int b) -> a+b;
        IntBinaryOperator add = Integer::sum;
        int i1 = add.applyAsInt(2, 5);
        System.out.println(i1); // 7

        //LongBinaryOperator max = (long a, long b) -> Long.max(a,b);
        LongBinaryOperator max = Long::max;
        long l1 = max.applyAsLong(45, 16);
        System.out.println(l1); // 45


        DoubleBinaryOperator squared = (double a, double b) -> a * b;
        double v1 = squared.applyAsDouble(12, 4);
        System.out.println(v1); // 48.0


        ToIntFunction<Person> personIntegerFunction = (Person p) -> p.getFeet();
        int i2 = personIntegerFunction.applyAsInt(person1);
        System.out.println(i2); // 2

        ToDoubleFunction<Person> personDoubleFunction = (Person p) -> p.getWeight();
        double v2 = personDoubleFunction.applyAsDouble(person2);
        System.out.println(v2); // 0.0

        //  Function<Person, Long> personLongFunction = (Person p) -> p.getId();  it is the same like the next instruction
        ToLongFunction<Person> personLongFunction = Person::getId;
        long l2 = personLongFunction.applyAsLong(person);
        System.out.println(l2); // 0


        // BiFunction<Person, Person, Integer> biFunction = (Person p1, Person p2) -> p1.getFeet() + p2.getFeet();
        ToIntBiFunction<Person, Person> toIntBiFunctionr = (Person p1, Person p2) -> p1.getFeet() + p2.getFeet();
        int i3 = toIntBiFunctionr.applyAsInt(person1, person2);
        System.out.println(i3); // 2

       // BiFunction<Person, Person, Long> personPersonLongBiFunction = (Person p1, Person p2) -> p1.getId() - p2.getId();
        ToLongBiFunction<Person, Person> toLongBiFunction = (Person p1, Person p2) -> p1.getId() + p2.getId();
        long l3 = toLongBiFunction.applyAsLong(person1, person2);
        System.out.println(l3); // 123455

        DoubleToIntFunction integerDoubleFunction = (double nombre) -> (int) nombre;
        int i4 = integerDoubleFunction.applyAsInt(12.7);
        System.out.println(i4);// 12

        IntToDoubleFunction integerIntFunction = (int nombre) -> nombre;
        double v3 = integerIntFunction.applyAsDouble(45);
        System.out.println(v3); // 45


    }

    static class Person {
        private double weight;
        private String firstname;
        private String lastname;
        private String genre;
        private int feet;
        private long id;

        public Person() {
        }

        public double getWeight() {
            return weight;
        }

        public Person setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public String getFirstname() {
            return firstname;
        }

        public Person setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public String getLastname() {
            return lastname;
        }

        public Person setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public String getGenre() {
            return genre;
        }

        public Person setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public int getFeet() {
            return feet;
        }

        public Person setFeet(int feet) {
            this.feet = feet;
            return this;
        }

        public long getId() {
            return id;
        }

        public Person setId(long id) {
            this.id = id;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            return new EqualsBuilder()
                    .append(weight, person.weight)
                    .append(feet, person.feet)
                    .append(id, person.id)
                    .append(firstname, person.firstname)
                    .append(lastname, person.lastname)
                    .append(genre, person.genre)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(weight)
                    .append(firstname)
                    .append(lastname)
                    .append(genre)
                    .append(feet)
                    .append(id)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("weight", weight)
                    .append("firstname", firstname)
                    .append("lastname", lastname)
                    .append("genre", genre)
                    .append("feet", feet)
                    .append("id", id)
                    .toString();
        }
    }
}
