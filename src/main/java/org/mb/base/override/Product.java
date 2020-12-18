package org.mb.base.override;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;

public class Product {

    private long id;

    private String designation;

    private BigDecimal price;

    private boolean available;

    private boolean promotion;

    private Date createdTimeStamp;

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(id, product.id)
                .append(available, product.available)
                .append(promotion, product.promotion)
                .append(designation, product.designation)
                .append(price, product.price)
                .append(createdTimeStamp, product.createdTimeStamp)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(designation)
                .append(price)
                .append(available)
                .append(promotion)
                .append(createdTimeStamp)
                .toHashCode();
    }
}
