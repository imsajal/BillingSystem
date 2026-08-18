package org.demo.service;

import org.demo.DiscountType;
import org.demo.ItemCategory;
import org.demo.service.impl.CategoryDiscountStrategy;
import org.demo.service.impl.FlatDiscountStrategy;
import org.demo.service.impl.PercentageDiscountStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory {

    private static Map<DiscountType, DiscountStrategy> discountStrategies = new HashMap<>();

    public static DiscountStrategy getDiscountStrategy(DiscountType discountType){

        switch (discountType){
            case FLAT:
                if(!discountStrategies.containsKey(DiscountType.FLAT)){
                    discountStrategies.put(discountType, new FlatDiscountStrategy());
                }
                break;
            case PERCENTAGE:
                if(!discountStrategies.containsKey(DiscountType.PERCENTAGE)){
                    discountStrategies.put(discountType, new PercentageDiscountStrategy());
                }
                break;
            case CATEGORY:
                if(!discountStrategies.containsKey(DiscountType.CATEGORY)){
                    discountStrategies.put(discountType, new CategoryDiscountStrategy());
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown Discount Type");
        }

        return discountStrategies.get(discountType);
    }



}
