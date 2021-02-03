package org.mb.base.assertions;


/*
 You assert the validity of an object’s state.
 Class invariants are typically private methods within the class that return a boolean
 */
public class ClassInvariants {

    private int width, height;

    public ClassInvariants(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        assert isValid() : "Not a valid Rectangle";
        return width * height;
    }

    private boolean isValid() {
        return (width >= 0 && height >= 0);
    }

    public static void main(String[] args) {
        ClassInvariants one = new ClassInvariants(12, 5);
        ClassInvariants two = new ClassInvariants(-4, 8);

        System.out.println(one.getArea());
        System.out.println(two.getArea());
    }

}
