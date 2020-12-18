package org.mb.base.predicat;

import org.mb.base.override.Product;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class TestPredicat {

    public static void order (Product product,Predicate<Product> predicate){
        if(predicate.test(product)) System.out.println("Order this product");

    }

    public static void main(String[] args) {
        Predicate<String> emptyPredicate = String::isEmpty;
        System.out.println(emptyPredicate.test("M"));

        Product product = new Product("Juice",new BigDecimal(10.05));
        order(product,(product1 -> product.isAvailable())); // Order this product
        order(product,(product1 -> product.isPromotion()));


    }
}
