package org.demo.service.impl;

import org.demo.*;
import org.demo.service.BillingService;
import org.demo.service.DiscountStrategy;
import org.demo.service.DiscountStrategyFactory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BillingServiceImpl implements BillingService {

    public BillingServiceImpl() {

    }

    @Override
    public Bill generateBill(Map<CartItem, Discount> itemsAndDiscount, User user) {
        Long finalAmount = 0L;
        for(Map.Entry<CartItem, Discount>  entry: itemsAndDiscount.entrySet()){
            CartItem cartItem = entry.getKey();
            Discount discount = entry.getValue();

            if(discount != null && discount.getValue() != 0){
                DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(discount.getDiscountType());
                finalAmount+= ((cartItem.getPrice() * cartItem.getQuantity())
                                - discountStrategy.calculateDiscount(cartItem, discount));
            }
            else{
                finalAmount += (cartItem.getPrice() * cartItem.getQuantity());
            }
        }
        return new Bill(UUID.randomUUID().toString(), itemsAndDiscount.keySet(), finalAmount, user);
    }
}
