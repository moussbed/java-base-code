package org.mb.base.internationalization;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class HandlingVariablesInsideResourceBundles {

    public static void main(String[] args) {

        /*
          In Java, we can read in the value normally. After that, we can run it through the MessageFormat class to substitute the parameters
         */
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo");
        String format = resourceBundle.getString("hello.name");
        System.out.println(format); // Hello , {0}
        String formatted = MessageFormat.format(format, "Bedril"); // Hello , Bedril
        System.out.println(formatted);
    }
}
