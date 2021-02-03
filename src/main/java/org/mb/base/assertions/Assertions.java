package org.mb.base.assertions;

/*
 N'oubliez pas que les assertions concernent des situations
 où vous êtes certain de quelque chose et que vous souhaitez simplement le vérifier.

  Les assertions sont utilisées à des fins de débogage, vous permettant de vérifier
  que quelque chose que vous pensez être vrai pendant la phase de codage l'est réellement au moment de l'exécution.

 */
public class Assertions {

    public static void main(String[] args) {


        /*
        Presuming assertions are enabled, an assertion is a shorter/better way of writing the following:
        if (!boolean_expression) throw new AssertionError();

        The assert Statement
        The syntax for an assert statement has two forms:
        assert boolean_expression;
        assert boolean_expression: error_message;
        The boolean expression must evaluate to true or false. It can be inside optional parenthesis.
        The optional error message is a String used as the message for the AssertionError that is thrown.
        */


        int number = -5;
        assert number > 0;

        System.out.println(number); //  It print -5
        /*
         Enabling Assertions
         By default, assert statements are ignored by the JVM at runtime. To enable assertions,
         use the -enableassertions flag on the command line:

          $ java -enableassertions Assertions.class
          or
          $ java -ea Assertions

          We will have an exception throws :
          Exception in thread "main" java.lang.AssertionError
	      at org.mb.base.assertions.Assertions.main(Assertions.java:7)

          You can also enable assertions for a specific class or package.
          java -ea:com.wiley.demos.TestColors my.programs.Main
         */

    }
}
