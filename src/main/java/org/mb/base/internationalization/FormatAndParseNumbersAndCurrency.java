package org.mb.base.internationalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatAndParseNumbersAndCurrency {
    public static void main(String[] args) throws ParseException {


        // ------------- Formatting --------------------
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        NumberFormat us = NumberFormat.getInstance(Locale.US);
        String formatUs = us.format(attendeesPerMonth);
        System.out.println(formatUs); // 266,666

        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        String formatG = g.format(attendeesPerMonth);
        System.out.println(formatG); // 266.666

        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        String formatCa = ca.format(attendeesPerMonth);
        System.out.println(formatCa);// 266 666

        double price = 48;
        NumberFormat mu = NumberFormat.getCurrencyInstance();
        String formatMur = mu.format(price);
        System.out.println(formatMur); //  48,00 MUR

        NumberFormat uS = NumberFormat.getCurrencyInstance(Locale.US);
        String formatUS = uS.format(price);
        System.out.println(formatUS); // $48.00

        NumberFormat fr = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String formatFr = fr.format(price);
        System.out.println(formatFr); // 48,00 €

        NumberFormat cA = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        String formatcA = cA.format(price);
        System.out.println(formatcA); // 48,00 $


        // --------------Parsing --------------
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fR = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";

        Number parseEn = en.parse(s);
        System.out.println(parseEn); // 40.45 In the United States, a dot is part of a number and the number is parsed how you might expect.
        Number parseFr = fR.parse(s);
        System.out.println(parseFr); // 40 France does not use a decimal point to separate numbers.


    }
}
