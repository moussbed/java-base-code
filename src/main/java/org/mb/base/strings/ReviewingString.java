package org.mb.base.strings;

import java.util.Locale;

public class ReviewingString {

    /*
     * Since String is immutable, it is inefficient for when you are updating the value in a loop.
     * StringBuilder is better for that scenario. A StringBuilder is mutable,
     * which means that it can change value and increase in capacity.
     * If multiple threads are updating the same object, you should use StringBuffer rather than StringBuilder.
     */

    public static boolean isPalindrome(String woprd){
        return new StringBuilder(woprd).reverse().toString().equals(woprd);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("banaba")); // false
        System.out.println(isPalindrome("baab")); // true

        StringBuilder s = new StringBuilder("abcde");
        s.insert(1, '-').delete(3, 4);
        System.out.println(s); //a-bde
        System.out.println(s.substring(2, 4)); // bd
        
    }
}
