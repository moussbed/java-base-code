package org.mb.base.unaryoperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UpdatingAllElements {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(12);
        list.add(0);
        list.add(7);
        System.out.println(list); //[56, 12, 0, 7]
        UnaryOperator<Integer> operator = (number)->2*number;
        list.replaceAll(operator);
        System.out.println(list); //[112, 24, 0, 14]

    }
}
