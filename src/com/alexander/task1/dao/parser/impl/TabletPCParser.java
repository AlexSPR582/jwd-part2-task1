package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.TabletPC;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabletPCParser implements ApplianceParser {
    private static final String BATTERY_CAPACITY_REGEX = "BATTERY_CAPACITY=([\\p{Digit}]+)";
    private static final String DISPLAY_INCHES_REGEX = "DISPLAY_INCHES=([\\p{Digit}]+)";
    private static final String MEMORY_ROM_REGEX = "MEMORY_ROM=([\\p{Digit}]+)";
    private static final String FLASH_MEMORY_CAPACITY_REGEX = "FLASH_MEMORY_CAPACITY=([\\p{Digit}]+)";
    private static final String COLOR_REGEX = "COLOR=([\\p{Lower}]+)";

    @Override
    public TabletPC parse(String line) throws DaoException {
        int batteryCapacity = parseBatteryCapacity(line);
        int displayInches = parseDisplayInches(line);
        int memoryRom = parseMemoryRom(line);
        int flashMemoryCapacity = parseFlashMemoryCapacity(line);
        String color = parseColor(line);
        return new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    private int parseBatteryCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(BATTERY_CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        int batteryCapacity;
        if (matcher.find()) {
            batteryCapacity = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return batteryCapacity;
    }

    private int parseDisplayInches(String line) throws DaoException {
        Pattern pattern = Pattern.compile(DISPLAY_INCHES_REGEX);
        Matcher matcher = pattern.matcher(line);
        int displayInches;
        if (matcher.find()) {
            displayInches = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return displayInches;
    }

    private int parseMemoryRom(String line) throws DaoException {
        Pattern pattern = Pattern.compile(MEMORY_ROM_REGEX);
        Matcher matcher = pattern.matcher(line);
        int memoryRom;
        if (matcher.find()) {
            memoryRom = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return memoryRom;
    }

    private int parseFlashMemoryCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(FLASH_MEMORY_CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        int flashMemoryCapacity;
        if (matcher.find()) {
            flashMemoryCapacity = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return flashMemoryCapacity;
    }

    private String parseColor(String line) throws DaoException {
        Pattern pattern = Pattern.compile(COLOR_REGEX);
        Matcher matcher = pattern.matcher(line);
        String color;
        if (matcher.find()) {
            color = matcher.group(1);
        } else {
            throw new DaoException("parse exception");
        }
        return color;
    }
}
