package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;

public class OvenValidator implements ApplianceValidator {
    private static final int MIN_POWER_CONSUMPTION = 100;
    private static final int MAX_POWER_CONSUMPTION = 100000;

    private static final int MIN_WEIGHT = 1;
    private static final int MAX_WEIGHT = 1000;

    private static final int MIN_CAPACITY = 10;
    private static final int MAX_CAPACITY = 1000;

    private static final int MIN_DEPTH = 10;
    private static final int MAX_DEPTH = 1000;

    private static final double MIN_HEIGHT = 10;
    private static final double MAX_HEIGHT = 200;

    private static final double MIN_WIDTH = 10;
    private static final double MAX_WIDTH = 200;

    @Override
    public boolean validate(Criteria criteria) {
        if (criteria == null) {
            return false;
        }
        Map<String, String> parameters = criteria.getParameters();
        if (parameters.isEmpty()) {
            return true;
        }
        if (parameters.containsKey("POWER_CONSUMPTION")) {
            String powerConsumption = parameters.get("POWER_CONSUMPTION");
            if (!validatePowerConsumption(powerConsumption)) {
                return false;
            }
        }
        if (parameters.containsKey("WEIGHT")) {
            String weight = parameters.get("WEIGHT");
            if (!validateWeight(weight)) {
                return false;
            }
        }
        if (parameters.containsKey("CAPACITY")) {
            String capacity = parameters.get("CAPACITY");
            if (!validateCapacity(capacity)) {
                return false;
            }
        }
        if (parameters.containsKey("DEPTH")) {
            String depth = parameters.get("DEPTH");
            if (!validateDepth(depth)) {
                return false;
            }
        }
        if (parameters.containsKey("HEIGHT")) {
            String height = parameters.get("HEIGHT");
            if (!validateHeight(height)) {
                return false;
            }
        }
        if (parameters.containsKey("WIDTH")) {
            String width = parameters.get("WIDTH");
            if (!validateWidth(width)) {
                return false;
            }
        }
        return true;
    }

    private boolean validatePowerConsumption(String value) {
        if (value == null) {
            return false;
        }
        int powerConsumption;
        try {
            powerConsumption = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return powerConsumption >= MIN_POWER_CONSUMPTION && powerConsumption <= MAX_POWER_CONSUMPTION;
    }

    private boolean validateWeight(String value) {
        if (value == null) {
            return false;
        }
        int weight;
        try {
            weight = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return weight >= MIN_WEIGHT && weight <= MAX_WEIGHT;
    }

    private boolean validateCapacity(String value) {
        if (value == null) {
            return false;
        }
        int capacity;
        try {
            capacity = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY;
    }

    private boolean validateDepth(String value) {
        if (value == null) {
            return false;
        }
        int depth;
        try {
            depth = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return depth >= MIN_DEPTH && depth <= MAX_DEPTH;
    }

    private boolean validateHeight(String value) {
        if (value == null) {
            return false;
        }
        int height;
        try {
            height = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }

    private boolean validateWidth(String value) {
        if (value == null) {
            return false;
        }
        int width;
        try {
            width = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return width >= MIN_WIDTH && width <= MAX_WIDTH;
    }
}
