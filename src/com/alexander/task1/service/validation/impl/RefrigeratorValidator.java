package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;

public class RefrigeratorValidator implements ApplianceValidator {
    private static final int MIN_POWER_CONSUMPTION = 10;
    private static final int MAX_POWER_CONSUMPTION = 10000;

    private static final int MIN_WEIGHT = 5;
    private static final int MAX_WEIGHT = 1000;

    private static final int MIN_FREEZER_CAPACITY = 1;
    private static final int MAX_FREEZER_CAPACITY = 1000;

    private static final double MIN_OVERALL_CAPACITY = 10;
    private static final double MAX_OVERALL_CAPACITY = 1000;

    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 1000;

    private static final double MIN_WIDTH = 10;
    private static final double MAX_WIDTH = 200;

    @Override
    public boolean validate(Criteria criteria) {
        if (criteria == null) {
            return false;
        }
        Map<String, String> parameters = criteria.getParameters();
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
        if (parameters.containsKey("FREEZER_CAPACITY")) {
            String freezerCapacity = parameters.get("FREEZER_CAPACITY");
            if (!validateFreezerCapacity(freezerCapacity)) {
                return false;
            }
        }
        if (parameters.containsKey("OVERALL_CAPACITY")) {
            String overallCapacity = parameters.get("OVERALL_CAPACITY");
            if (!validateOverallCapacity(overallCapacity)) {
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
        return parameters.isEmpty();
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

    private boolean validateFreezerCapacity(String value) {
        if (value == null) {
            return false;
        }
        int freezerCapacity;
        try {
            freezerCapacity = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return freezerCapacity >= MIN_FREEZER_CAPACITY && freezerCapacity <= MAX_FREEZER_CAPACITY;
    }

    private boolean validateOverallCapacity(String value) {
        if (value == null) {
            return false;
        }
        double overallCapacity;
        try {
            overallCapacity = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return overallCapacity >= MIN_OVERALL_CAPACITY && overallCapacity <= MAX_OVERALL_CAPACITY;
    }

    private boolean validateHeight(String value) {
        if (value == null) {
            return false;
        }
        double height;
        try {
            height = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }

    private boolean validateWidth(String value) {
        if (value == null) {
            return false;
        }
        double width;
        try {
            width = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return width >= MIN_WIDTH && width <= MAX_WIDTH;
    }
}
