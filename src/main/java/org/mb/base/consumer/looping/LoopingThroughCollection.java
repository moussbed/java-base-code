package org.mb.base.consumer.looping;

import org.mb.base.override.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LoopingThroughCollection {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Juice", new BigDecimal(14),true,true));
        products.add(new Product("Ananas", new BigDecimal(35)));
        products.add(new Product("Banana", new BigDecimal(20)));

        Consumer<Product> consumer = System.out::println;

        products.forEach(consumer);
    }
}
