package org.mb.base.internationalization.bundle.resource;

import org.mb.base.internationalization.bundle.UsTaxCode;

import java.util.ListResourceBundle;

public class Tax_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]  {
                {"tax" , new UsTaxCode(30)}
        };
    }
}
