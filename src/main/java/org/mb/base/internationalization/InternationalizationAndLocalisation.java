package org.mb.base.internationalization;

import java.util.Locale;

public class InternationalizationAndLocalisation {


    /*
     * Internationalization is the process of designing your program so it can be adapted.
     * This involves placing strings in a property file and using classes like DateFormat
     * so that the right format is used based on user preferences.
     * You do not actually need to support more than one language or country to internationalize the program.
     * Internationalization just means that you can.
     *
     * Localization means actually supporting multiple locales.
     * Oracle defines a locale as “a specific geographical, political, or cultural region.”
     * You can think of a locale as being like a language and country pairing.
     * Localization includes translating strings to different languages.
     * It also includes outputting dates and numbers in the correct format for that locale.
     * You can go through the localization process many times in the same application as you add more languages and countries.
     *
     * Since internationalization and localization are such long words, they are often abbreviated as i18n and l10n.
     * The number refers to the number of characters between the first and last characters, in other words,
     * the number of characters that are replaced with a number.
     */

    public static void main(String[] args) {
        Locale locale = Locale.getDefault(); //  This default output tells us that our computers are using french and are sitting in the Mauritius.
        System.out.println(locale); // fr_MU
        System.out.println(Locale.CANADA); // en_CA
        System.out.println(Locale.CANADA_FRENCH); // fr_CA
        System.out.println(Locale.FRANCE); // fr
        System.out.println(Locale.FRENCH);// fr_FR
        System.out.println(new Locale("fr","CM")); // fr_CM

        Locale l1 = new Locale.Builder() .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(l1); // en_US
    }
}
