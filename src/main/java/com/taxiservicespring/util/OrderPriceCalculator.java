package com.taxiservicespring.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.math3.util.Precision;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class calculates order price considering selected car category and
 * discount availability for specified user.
 *
 * @author Maryna Lendiel
 */
public class OrderPriceCalculator {
    private static final Logger LOGGER = LogManager.getLogger(OrderPriceCalculator.class);
    private static final double PRICE = 20;
    private static Map<String, Double> priceList = new TreeMap<>();

    static {
        priceList.put("standard", 0.0);
        priceList.put("comfort", 15.0);
        priceList.put("minivan", 20.0);
    }

    public static double calculate(double distance, int isDiscount, String category) {
        double calc = distance * PRICE;
        double discount = 0;
        // order price depends on selected car category
        if (priceList.get(category) != null) {
            calc = calc + calc * priceList.get(category) / 100;
        }

        // if user has discount his order is 10% cheaper
        if (isDiscount == 1) {
            discount = calc * 10 / 100;
        }
        LOGGER.info(Precision.round(calc - discount, 2));
        return Precision.round(calc - discount, 2);
    }
}
