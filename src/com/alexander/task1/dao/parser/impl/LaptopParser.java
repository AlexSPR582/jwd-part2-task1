package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.Laptop;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LaptopParser implements ApplianceParser {
    private static final String BATTERY_CAPACITY_REGEX = "BATTERY_CAPACITY=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";
    private static final String OS_REGEX = "OS=([\\p{Alpha}]+)";
    private static final String MEMORY_ROM_REGEX = "MEMORY_ROM=([\\p{Digit}]+)";
    private static final String SYSTEM_MEMORY_REGEX = "SYSTEM_MEMORY=([\\p{Digit}]+)";
    private static final String CPU_REGEX = "CPU=([\\p{Digit}]+\\.?[\\p{Digit}]+)";
    private static final String DISPLAY_INCHES_REGEX = "DISPLAY_INCHES=([\\p{Digit}]+)";

    @Override
    public Laptop parse(String line) throws DaoException {
        double batteryCapacity = parseBatteryCapacity(line);
        String os = parseOS(line);
        int memoryRom = parseMemoryRom(line);
        int systemMemory = parseSystemMemory(line);
        double cpu = parseCpu(line);
        int displayInches = parseDisplayInches(line);
        return new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
    }

    private double parseBatteryCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(BATTERY_CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        double batteryCapacity;
        if (matcher.find()) {
            batteryCapacity = Double.parseDouble(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return batteryCapacity;
    }

    private String parseOS(String line) throws DaoException {
        Pattern pattern = Pattern.compile(OS_REGEX);
        Matcher matcher = pattern.matcher(line);
        String os;
        if (matcher.find()) {
            os = matcher.group(1);
        } else {
            throw new DaoException("parse exception");
        }
        return os;
    }

    private int parseMemoryRom(String line) throws DaoException {
        Pattern pattern = Pattern.compile(MEMORY_ROM_REGEX);
        Matcher matcher = pattern.matcher(line);
        int MemoryRom;
        if (matcher.find()) {
            MemoryRom = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return MemoryRom;
    }

    private int parseSystemMemory(String line) throws DaoException {
        Pattern pattern = Pattern.compile(SYSTEM_MEMORY_REGEX);
        Matcher matcher = pattern.matcher(line);
        int SystemMemory;
        if (matcher.find()) {
            SystemMemory = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return SystemMemory;
    }

    private double parseCpu(String line) throws DaoException {
        Pattern pattern = Pattern.compile(CPU_REGEX);
        Matcher matcher = pattern.matcher(line);
        double cpu;
        if (matcher.find()) {
            cpu = Double.parseDouble(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return cpu;
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
}
