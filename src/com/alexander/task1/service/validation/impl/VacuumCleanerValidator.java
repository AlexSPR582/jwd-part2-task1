package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VacuumCleanerValidator implements ApplianceValidator {
    private static final int MIN_POWER_CONSUMPTION = 10;
    private static final int MAX_POWER_CONSUMPTION = 10000;

    private static final int MIN_MOTOR_SPEED_REGULATION = 100;
    private static final int MAX_MOTOR_SPEED_REGULATION = 100000;

    private static final int MIN_CLEANING_WIDTH = 1;
    private static final int MAX_CLEANING_WIDTH = 1000;

    private static final String FILTER_TYPE_REGEX = "^[\\p{Upper}]+$";
    private static final String BAG_TYPE_REGEX = "^[\\p{Alnum}\\-]+$";
    private static final String WAND_TYPE_REGEX = "^[\\p{Lower}\\-]+$";

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
        if (parameters.containsKey("MOTOR_SPEED_REGULATION")) {
            String motorSpeedRegulation = parameters.get("MOTOR_SPEED_REGULATION");
            if (!validateMotorSpeedRegulation(motorSpeedRegulation)) {
                return false;
            }
        }
        if (parameters.containsKey("CLEANING_WIDTH")) {
            String cleaningWidth = parameters.get("CLEANING_WIDTH");
            if (!validateCleaningWidth(cleaningWidth)) {
                return false;
            }
        }
        if (parameters.containsKey("FILTER_TYPE")) {
            String filterType = parameters.get("FILTER_TYPE");
            if (!validateFilterType(filterType)) {
                return false;
            }
        }
        if (parameters.containsKey("BAG_TYPE")) {
            String bagType = parameters.get("BAG_TYPE");
            if (!validateBagType(bagType)) {
                return false;
            }
        }
        if (parameters.containsKey("WAND_TYPE")) {
            String wandType = parameters.get("WAND_TYPE");
            if (!validateWandType(wandType)) {
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

    private boolean validateMotorSpeedRegulation(String value) {
        if (value == null) {
            return false;
        }
        int motorSpeedRegulation;
        try {
            motorSpeedRegulation = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return motorSpeedRegulation >= MIN_MOTOR_SPEED_REGULATION &&
                motorSpeedRegulation <= MAX_MOTOR_SPEED_REGULATION;
    }

    private boolean validateCleaningWidth(String value) {
        if (value == null) {
            return false;
        }
        int cleaningWidth;
        try {
            cleaningWidth = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return cleaningWidth >= MIN_CLEANING_WIDTH && cleaningWidth <= MAX_CLEANING_WIDTH;
    }

    private boolean validateFilterType(String filterType) {
        if (filterType == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(FILTER_TYPE_REGEX);
        Matcher matcher = pattern.matcher(filterType);
        return matcher.find();
    }

    private boolean validateBagType(String bagType) {
        if (bagType == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(BAG_TYPE_REGEX);
        Matcher matcher = pattern.matcher(bagType);
        return matcher.find();
    }

    private boolean validateWandType(String wandType) {
        if (wandType == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(WAND_TYPE_REGEX);
        Matcher matcher = pattern.matcher(wandType);
        return matcher.find();
    }
}
