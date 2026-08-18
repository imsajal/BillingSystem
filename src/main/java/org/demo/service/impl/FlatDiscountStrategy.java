package org.demo.service.impl;

import org.demo.CartItem;
import org.demo.Discount;
import org.demo.service.DiscountStrategy;

public class FlatDiscountStrategy implements DiscountStrategy {
    @Override
    public Long calculateDiscount(CartItem cartItem, Discount discount) {
        return discount.getValue();
    }
}
