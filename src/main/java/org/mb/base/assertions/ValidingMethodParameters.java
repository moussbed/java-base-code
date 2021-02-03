package org.mb.base.assertions;


/*
 Do not use assertions to check for valid arguments passed in to a method.
 Use an IllegalArgumentException instead.
 You cannot be certain that someone instantiating a Rectangle will pass in positive values.
 Cependant, avec le constructeur  défini de cette manière, vous devriez être en mesure d'affirmer
 avec beaucoup de certitude que l'invocation de isValid sur n'importe quel objet Rectangle retournera true.

*/
public class ValidingMethodParameters {
    private int width, height;

    public ValidingMethodParameters(int width, int height) {
        if(width < 0 || height < 0) throw new IllegalArgumentException() ;
        this.width = width;
        this.height = height;
    }
}
