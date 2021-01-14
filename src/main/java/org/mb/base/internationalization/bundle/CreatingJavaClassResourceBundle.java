package org.mb.base.internationalization.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class CreatingJavaClassResourceBundle {

    /*
      Most of the time, a property file resource bundle is enough to meet the program’s needs.
      It does have a limitation in that only String values are allowed.
      Java class resource bundles allow any Java type as the value. Keys are strings regardless.

      To implement a resource bundle in Java, you create a class with the same name that you would use for a property file.
      Only the extension is different.

      There are two main advantages of using a Java class instead of a property file for a resource bundle:
      ■ You can use a value type that is not a String.
      ■ You can create the values of the properties at runtime.
     */



    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.mb.base.internationalization.bundle.Zoo", Locale.US);
        resourceBundle.keySet().stream()
                .map(k-> k + " : " + resourceBundle.getString(k))
                .forEach(System.out::println);

        // Line 30 shows that a resource bundle can be in a package.
        // If we put Local.UK, a exception(java.util.MissingResourceException : Can't find bundle for base name org.mb.base.internationalization.bundle.Tax, locale en_GB)
        // will throws, because we have specified country US on (Tax_en_US)
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("org.mb.base.internationalization.bundle.Tax", Locale.US);
        System.out.println(resourceBundle1.getObject("tax"));

        //

    }
}
