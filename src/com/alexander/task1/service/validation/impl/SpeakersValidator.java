package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeakersValidator implements ApplianceValidator {
    private static final int MIN_POWER_CONSUMPTION = 10;
    private static final int MAX_POWER_CONSUMPTION = 10000;

    private static final int MIN_NUMBER_OF_SPEAKERS = 5;
    private static final int MAX_NUMBER_OF_SPEAKERS = 1000;

    private static final double MIN_CORD_LENGTH = 10;
    private static final double MAX_CORD_LENGTH = 1000;

    private static final double MIN_FREQUENCY = 50;
    private static final double MAX_FREQUENCY = 1000;
    private static final String FREQUENCY_RANGE_REGEX = "^([\\p{Digit}]+(\\.[\\p{Digit}]+)?)-([\\p{Digit}]+(\\.[\\p{Digit}]+)?)$";

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
        if (parameters.containsKey("NUMBER_OF_SPEAKERS")) {
            String numberOfSpeakers = parameters.get("NUMBER_OF_SPEAKERS");
            if (!validateNumberOfSpeakers(numberOfSpeakers)) {
                return false;
            }
        }
        if (parameters.containsKey("CORD_LENGTH")) {
            String cordLength = parameters.get("CORD_LENGTH");
            if (!validateCordLength(cordLength)) {
                return false;
            }
        }
        if (parameters.containsKey("FREQUENCY_RANGE")) {
            String frequencyRange = parameters.get("FREQUENCY_RANGE");
            if (!validateFrequencyRange(frequencyRange)) {
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

    private boolean validateNumberOfSpeakers(String value) {
        if (value == null) {
            return false;
        }
        int numberOfSpeakers;
        try {
            numberOfSpeakers = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return numberOfSpeakers >= MIN_NUMBER_OF_SPEAKERS &&
                numberOfSpeakers <= MAX_NUMBER_OF_SPEAKERS;
    }

    private boolean validateCordLength(String value) {
        if (value == null) {
            return false;
        }
        int cordLength;
        try {
            cordLength = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return cordLength >= MIN_CORD_LENGTH && cordLength <= MAX_CORD_LENGTH;
    }

    private boolean validateFrequencyRange(String frequencyRange) {
        if (frequencyRange == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(FREQUENCY_RANGE_REGEX);
        Matcher matcher = pattern.matcher(frequencyRange);
        boolean isValid = false;
        if (matcher.find()) {
            double min = Double.parseDouble(matcher.group(1));
            double max = Double.parseDouble(matcher.group(2));
            isValid = min >= MIN_FREQUENCY && max <= MAX_FREQUENCY;
        }
        return isValid;
    }
}
