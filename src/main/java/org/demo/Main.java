package org.demo;


import org.demo.service.BillingService;
import org.demo.service.impl.BillingServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        BillingService billingService = new BillingServiceImpl();

        User user = new User("abc", "sajal");
        CartItem cartItem1 = new CartItem(2L,
                ItemCategory.Clothing, 100L, UUID.randomUUID().toString());
        CartItem cartItem2 = new CartItem(2L,
                ItemCategory.Clothing, 100L, UUID.randomUUID().toString());
        CartItem cartItem3 = new CartItem(2L,
                ItemCategory.Clothing, 100L, UUID.randomUUID().toString());

        Discount percentageDiscount = new Discount(20L, DiscountType.PERCENTAGE);
        Discount flatDiscount = new Discount(50L, DiscountType.FLAT);
        Discount categoryDiscount = new Discount(10L, DiscountType.CATEGORY);

        Map<CartItem, Discount> itemsAndDiscount = new HashMap<>();

        itemsAndDiscount.put(cartItem1, flatDiscount);
        itemsAndDiscount.put(cartItem2, percentageDiscount);
        itemsAndDiscount.put(cartItem3, categoryDiscount);

        // 150 + 160 + 180 = 490

        System.out.println(billingService.generateBill(itemsAndDiscount, user).getAmount());

    }

    /*
    Improvements --

   -> Q1 : Map<CartItem,Discount>, others take List<Discount>.
     Caller has to remember a different shape per type = leaky abstraction, breaks polymorphism.
     We need to make the caller as simple as possible and support good abastraction

   -> Solution

    1. Every strategy still gets the same signature: calculateDiscount(List<CartItem> items,
     Discount discount). The filtering logic (by category, or by id-set, or both)
     lives inside each strategy — caller never changes.
     Long totalDiscount = 0L;

    2. for (Discount discount : discounts) {
        DiscountStrategy strategy = factory.getDiscountStrategy(discount.getDiscountType());
        totalDiscount += strategy.calculateDiscount(items, discount);
     }
     That's exactly right, and you don't need a separate type for it:

    3. FLAT discount, applicableItemIds = null → whole-cart flat coupon (e.g., "₹100 off order").
    FLAT discount, applicableItemIds = {id1, id2} → item-specific flat-off (e.g., "₹50 off this specific item").


    4. public class Discount {
    private Long value;
    private DiscountType discountType;
    private ItemCategory category;        // used only by CATEGORY
    private Set<String> applicableItemIds; // optional, used by any type if you want item-level restriction

    }


    * */
}