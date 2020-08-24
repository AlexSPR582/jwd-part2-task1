package com.alexander.task1.service.validation.impl;

import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.service.validation.ApplianceValidator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LaptopValidator implements ApplianceValidator {
    private static final double MIN_BATTERY_CAPACITY = 1;
    private static final double MAX_BATTERY_CAPACITY = 100;

    private static final int MIN_MEMORY_ROM = 100;
    private static final int MAX_MEMORY_ROM = 100000;

    private static final int MIN_SYSTEM_MEMORY = 100;
    private static final int MAX_SYSTEM_MEMORY = 100000;

    private static final double MIN_CPU = 0.1;
    private static final double MAX_CPU = 1000;

    private static final int MIN_DISPLAY_INCHES = 1;
    private static final int MAX_DISPLAY_INCHES = 1000;

    private static final String OS_REGEX = "^[\\p{Alpha}]+$";

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
        if (parameters.containsKey("SYSTEM_MEMORY")) {
            String systemMemory = parameters.get("SYSTEM_MEMORY");
            if (!validateSystemMemory(systemMemory)) {
                return false;
            }
        }
        if (parameters.containsKey("CPU")) {
            String cpu = parameters.get("CPU");
            if (!validateCpu(cpu)) {
                return false;
            }
        }
        if (parameters.containsKey("DISPLAY_INCHES")) {
            String displayInches = parameters.get("DISPLAY_INCHES");
            if (!validateDisplayInches(displayInches)) {
                return false;
            }
        }
        if (parameters.containsKey("OS")) {
            String os = parameters.get("OS");
            if (!validateOS(os)) {
                return false;
            }
        }
        return parameters.isEmpty();
    }

    private boolean validateBatteryCapacity(String value) {
        if (value == null) {
            return false;
        }
        double batteryCapacity;
        try {
            batteryCapacity = Double.parseDouble(value);
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

    private boolean validateSystemMemory(String value) {
        if (value == null) {
            return false;
        }
        int systemMemory;
        try {
            systemMemory = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return systemMemory >= MIN_SYSTEM_MEMORY && systemMemory <= MAX_SYSTEM_MEMORY;
    }

    private boolean validateCpu(String value) {
        if (value == null) {
            return false;
        }
        double cpu;
        try {
            cpu = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return cpu >= MIN_CPU && cpu <= MAX_CPU;
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

    private boolean validateOS(String os) {
        if (os == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(OS_REGEX);
        Matcher matcher = pattern.matcher(os);
        return matcher.find();
    }
}
