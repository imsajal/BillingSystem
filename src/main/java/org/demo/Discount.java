package org.demo;

public class Discount {
    private Long value;
    private DiscountType discountType;

    public Discount(Long value, DiscountType discountType) {
        this.value = value;
        this.discountType = discountType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
