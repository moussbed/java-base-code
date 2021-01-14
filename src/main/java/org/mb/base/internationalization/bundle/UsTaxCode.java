package org.mb.base.internationalization.bundle;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UsTaxCode {
    private int tva ;

    public UsTaxCode() {
        this(0);
    }

    public UsTaxCode(int tva) {
        this.tva = tva;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("tva", tva)
                .toString();
    }
}
