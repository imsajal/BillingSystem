package org.demo.service.impl;

import org.demo.CartItem;
import org.demo.Discount;
import org.demo.service.DiscountStrategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public Long calculateDiscount(CartItem cartItem, Discount discount) {
        Long amount = cartItem.getPrice() * cartItem.getQuantity();
        return ((amount * discount.getValue()) / 100);
    }
}
