package org.mb.base.internationalization.bundle;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class CreatingPropertyFileResourceBundle {

    public static void printProperties(Locale locale) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("open"));


    }

    public static void main(String[] args) {
        Locale fr = Locale.FRANCE; // new Locale("fr","FR");
        Locale en = Locale.US; // new Locale("en","US")

        printProperties(fr);
        System.out.println();
        printProperties(en);
        System.out.println();


        //   Print
        /*
        Bonjour
        Le zoo est ouvert

        Hello
        The zoo is open.
        */

        /*
         Since a resource bundle contains key/value pairs, you can even loop through them to list all of the pairs.
         The ResourceBundle class provides a method to get a set of all keys:
         */
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", Locale.getDefault());
        Set<String> strings = resourceBundle.keySet();
        strings.stream()
                .map(k -> k + ": " + resourceBundle.getString(k))
                .forEach(System.out::println);

        /* In addition to ResourceBundle, Java supports a class named Properties. It is like a Map
           Properties has some additional features, including being able to pass a default.
           Converting from ResourceBundle to Properties is easy:
         */

        Properties properties = new Properties();

        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("zoo",Locale.CANADA);
        Set<String> strings1 = resourceBundle1.keySet();
        strings1.forEach(k-> properties.put(k,resourceBundle1.getString(k)));

        System.out.println(properties.getProperty("notReallyAProperty")); // The first line prints null, since that property doesn’t exist.
        System.out.println(properties.getProperty("notReallyAProperty", "123")); // The second prints 123, since the property wasn’t found.
        System.out.println(properties.getProperty("name")); // Vancouver Zoo

       // Locale.setDefault(new Locale("hi"));
        ResourceBundle resourceBundle2 = ResourceBundle.getBundle("Zoo"); // Get default locale
        System.out.println(resourceBundle2.getString("hello")); // Bonjour
        System.out.println(resourceBundle2.getString("visitor"));


    }
}
