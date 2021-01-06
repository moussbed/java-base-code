package org.mb.base.streams.pipeline;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class CheckedExceptionsAndFunctionalInterfaces {

    /*
     *You might have noticed by now that the functional interfaces do not declare checked exceptions.
     *This is normally OK. However, it is a problem when working with methods that declare checked exceptions.
     * Suppose that we have a class with a method that throws a checked exception
     */

    private static List<String> create() throws IOException {
        throw new IOException();
    }

    private static List<String> createSafe(){
        try {
            return CheckedExceptionsAndFunctionalInterfaces.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // Now we use it in a stream:
        // Nothing new here. The create() method throws a checked exception
        long count = CheckedExceptionsAndFunctionalInterfaces.create().stream().count();
        System.out.println(count);


        // Now what about this one when i use reference method
        //  Supplier<List<String>> create = CheckedExceptionsAndFunctionalInterfaces::create;
        // DOES NOT COMPILE, The actual compiler error is :  Unhandled exception: java.io.IOException

        // The problem is that the lambda to which this method reference expands does declare an exception.
        // The Supplier interface does not allow checked exceptions.There are two approaches to get around this problem.

        // One is to catch the exception and turn it into an unchecked exception:
        // This works. But the code is ugly.
        // One of the benefits of functional programming is that the code is supposed to be easy to read and concise.
        Supplier<List<String>> supplier = () -> {
            try {
                return CheckedExceptionsAndFunctionalInterfaces.create();
            } catch (IOException e) {
               throw new RuntimeException();
            }
        };

        // Another alternative is to create a wrap- per method with the try/catch
        // Now we can use the safe wrapper in our Supplier without issue:
        Supplier<List<String>> createSafe = CheckedExceptionsAndFunctionalInterfaces::createSafe;


    }
}
