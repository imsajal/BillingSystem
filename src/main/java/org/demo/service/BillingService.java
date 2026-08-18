package org.demo.service;

import org.demo.Bill;
import org.demo.CartItem;
import org.demo.Discount;
import org.demo.User;

import java.util.List;
import java.util.Map;

public interface BillingService {

     Bill generateBill(Map<CartItem, Discount> itemsAndDiscount, User user);
}
