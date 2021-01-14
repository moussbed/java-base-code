package org.mb.base.internationalization.bundle.resource;

import java.util.ListResourceBundle;

public class Zoo extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"visitor" , "Bedril"}
        };
    }
}
