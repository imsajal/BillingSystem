package org.demo.service;

import org.demo.CartItem;
import org.demo.Discount;

public interface DiscountStrategy {
    Long calculateDiscount(CartItem cartItem, Discount discount);
}
