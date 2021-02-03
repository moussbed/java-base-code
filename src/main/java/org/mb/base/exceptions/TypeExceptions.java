package org.mb.base.exceptions;

public class TypeExceptions {

    public static void main(String[] args) {

        // -------------Checked Exceptions-------------------
        /*
        * ArithmeticException:  Thrown by the JVM when code attempts to divide by zero.
        * ArrayIndexOutOfBoundsException :  Thrown by the JVM when code uses an illegal index to access an array.
        * ClassCastException: Thrown by the JVM when an attempt is made to cast an object to a subclass of which it is not an instance.
        * IllegalArgumentException: Thrown by the program to indicate that a method has been passed an illegal or inappropriate argument.
        * NullPointerException: Thrown by the JVM when there is a null reference where an object is required.
        * NumberFormatException: Thrown by the program when an attempt is made to convert a string to a numeric type, but the string doesn’t have an appropriate format.
        * ParseException : Converting a String to a number.
        * java.io.IOException, java.io.FileNotFoundException,java.io.NotSerializableException : Dealing with IO
        * and NIO.2 issues. IOException is the parent class. There are a number of subclasses. You can assume any java. io exception is checked.
        * java.sql.SQLException: Dealing with database issues. SQLException is the parent class. Again, you can assume any java.sql exception is checked.
        */


        // -------------Unchecked Exceptions-------------------
        /*
        * java.lang.ArrayStoreException: Trying to store the wrong data type in an array.
        * java.time.DateTimeException: Receiving an invalid format string for a date.
        * java.util.MissingResourceException: Trying to access a key or resource bundle that does not exist.
        * java.lang.IllegalStateException, java.lang. UnsupportedOperationException: Attempting to run an invalid operation in collections and concurrency.
        */

    }
}
