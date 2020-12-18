package org.mb.base.supplier;

import org.mb.base.override.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        Supplier<ArrayList<Product>> supplierRef = ArrayList::new;
        Supplier<ArrayList<? extends Product>> supplierLambda = ()-> new ArrayList<>();

        ArrayList<Product> products = supplierRef.get();
        products.add(new Product("Juice", new BigDecimal(14)));
        products.add(new Product("Ananas", new BigDecimal(35)));
        products.add(new Product("Banana", new BigDecimal(20)));
        System.out.println(products);

        Predicate<Product> predicate = (p)-> p.getDesignation().startsWith("Ju");
        products.removeIf(predicate);
        System.out.println(products);


    }
}
