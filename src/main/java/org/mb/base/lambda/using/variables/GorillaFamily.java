package org.mb.base.lambda.using.variables;


interface Gorilla {
    String move();
}


public class GorillaFamily {

    String walk = "walk";

    /*
    * Line 23 uses an instance variable in the lambda. Line 24 uses a method parameter.
    * We know it is effectively final since there are no reassignments to that variable.
    * Line 25 uses an effectively final local variable. If we uncomment lines 21 and 22,
    * there will be a reassignment and the variable will no longer be effectively final.
    * This would cause a compiler error on lines 24 and 25 when it tries to access a non–effectively final variable.
    */
    void everyonePlay(boolean baby) {
        //baby=false;
        String approach = "amble"; //approach = "run";
        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    private String play(Gorilla gorilla) {
       return gorilla.move();
    }

    public static void main(String[] args) {
        GorillaFamily gorillaFamily = new GorillaFamily();
        gorillaFamily.everyonePlay(true);
    }
}
