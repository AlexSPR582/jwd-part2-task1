package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabletPCValidator implements ApplianceValidator {
    private static final int MIN_BATTERY_CAPACITY = 1;
    private static final int MAX_BATTERY_CAPACITY = 1000;

    private static final int MIN_DISPLAY_INCHES = 1;
    private static final int MAX_DISPLAY_INCHES = 1000;

    private static final int MIN_MEMORY_ROM = 100;
    private static final int MAX_MEMORY_ROM = 1000000;

    private static final double MIN_FLASH_MEMORY_CAPACITY = 1;
    private static final double MAX_FLASH_MEMORY_CAPACITY = 1000;

    private static final String COLOR_REGEX = "^[\\p{Alpha}]+$";

    @Override
    public boolean validate(Criteria criteria) {
        if (criteria == null) {
            return false;
        }
        Map<String, String> parameters = criteria.getParameters();
        if (parameters.containsKey("BATTERY_CAPACITY")) {
            String batteryCapacity = parameters.get("BATTERY_CAPACITY");
            if (!validateBatteryCapacity(batteryCapacity)) {
                return false;
            }
        }
        if (parameters.containsKey("MEMORY_ROM")) {
            String memoryRom = parameters.get("MEMORY_ROM");
            if (!validateMemoryRom(memoryRom)) {
                return false;
            }
        }
        if (parameters.containsKey("FLASH_MEMORY_CAPACITY")) {
            String flashMemoryCapacity = parameters.get("FLASH_MEMORY_CAPACITY");
            if (!validateFlashMemoryCapacity(flashMemoryCapacity)) {
                return false;
            }
        }
        if (parameters.containsKey("COLOR")) {
            String color = parameters.get("COLOR");
            if (!validateColor(color)) {
                return false;
            }
        }
        if (parameters.containsKey("DISPLAY_INCHES")) {
            String displayInches = parameters.get("DISPLAY_INCHES");
            if (!validateDisplayInches(displayInches)) {
                return false;
            }
        }
        return parameters.isEmpty();
    }

    private boolean validateBatteryCapacity(String value) {
        if (value == null) {
            return false;
        }
        int batteryCapacity;
        try {
            batteryCapacity = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return batteryCapacity >= MIN_BATTERY_CAPACITY && batteryCapacity <= MAX_BATTERY_CAPACITY;
    }

    private boolean validateMemoryRom(String value) {
        if (value == null) {
            return false;
        }
        int memoryRom;
        try {
            memoryRom = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return memoryRom >= MIN_MEMORY_ROM && memoryRom <= MAX_MEMORY_ROM;
    }

    private boolean validateFlashMemoryCapacity(String value) {
        if (value == null) {
            return false;
        }
        int flashMemoryCapacity;
        try {
            flashMemoryCapacity = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return flashMemoryCapacity >= MIN_FLASH_MEMORY_CAPACITY &&
                flashMemoryCapacity <= MAX_FLASH_MEMORY_CAPACITY;
    }

    private boolean validateDisplayInches(String value) {
        if (value == null) {
            return false;
        }
        int displayInches;
        try {
            displayInches = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return displayInches >= MIN_DISPLAY_INCHES && displayInches <= MAX_DISPLAY_INCHES;
    }

    private boolean validateColor(String color) {
        if (color == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(COLOR_REGEX);
        Matcher matcher = pattern.matcher(color);
        return matcher.find();
    }
}
