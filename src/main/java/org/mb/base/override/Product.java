package org.mb.base.override;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private long id;

    private String designation;

    private BigDecimal price;

    private boolean available;

    private boolean promotion;

    private Date createdTimeStamp;

    public Product(String designation, BigDecimal price ) {
        this(designation,price,true,false);
    }

    public Product(String designation, BigDecimal price, boolean available, boolean promotion) {
        this(0,designation,price,available,promotion,new Date());
    }

    public Product(long id, String designation, BigDecimal price, boolean available, boolean promotion, Date createdTimeStamp) {
        this.id = id;
        this.designation = designation;
        this.price = price;
        this.available = available;
        this.promotion = promotion;
        this.createdTimeStamp = createdTimeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
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
