package org.mb.base.streams.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsToTheUnderlyingData {

    /*
    * Remember that streams are lazily evaluated
    * This means that the stream isn’t actually created on line 22.
    * An object is created that knows where to look for the data when it is needed.
    * On line 23, the List gets a new element. On line 34, the stream pipeline actually runs.
    */

    public static void main(String[] args) {

        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Pluto");

        Stream<String> stream = cats.stream();
        cats.add("Miaou");
        System.out.println(stream.count());//3



    }
}
