package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.Oven;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OvenParser implements ApplianceParser {
    private static final String POWER_CONSUMPTION_REGEX = "POWER_CONSUMPTION=([\\p{Digit}]+)";
    private static final String WEIGHT_REGEX = "WEIGHT=([\\p{Digit}]+)";
    private static final String CAPACITY_REGEX = "CAPACITY=([\\p{Digit}]+)";
    private static final String DEPTH_REGEX = "DEPTH=([\\p{Digit}]+)";
    private static final String HEIGHT_REGEX = "HEIGHT=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";
    private static final String WIDTH_REGEX = "WIDTH=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";

    @Override
    public Oven parse(String line) throws DaoException {
        int powerConsumption = parsePowerConsumption(line);
        int weight = parseWeight(line);
        int capacity = parseCapacity(line);
        int depth = parseDepth(line);
        double height = parseHeight(line);
        double width = parseWidth(line);
        return new Oven(powerConsumption, weight, capacity, depth, height, width);
    }

    private int parsePowerConsumption(String line) throws DaoException {
        Pattern pattern = Pattern.compile(POWER_CONSUMPTION_REGEX);
        Matcher matcher = pattern.matcher(line);
        int powerConsumption;
        if (matcher.find()) {
            powerConsumption = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return powerConsumption;
    }

    private int parseWeight(String line) throws DaoException {
        Pattern pattern = Pattern.compile(WEIGHT_REGEX);
        Matcher matcher = pattern.matcher(line);
        int weight;
        if (matcher.find()) {
            weight = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return weight;
    }

    private int parseCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        int capacity;
        if (matcher.find()) {
            capacity = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return capacity;
    }

    private int parseDepth(String line) throws DaoException {
        Pattern pattern = Pattern.compile(DEPTH_REGEX);
        Matcher matcher = pattern.matcher(line);
        int depth;
        if (matcher.find()) {
            depth = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return depth;
    }

    private double parseHeight(String line) throws DaoException {
        Pattern pattern = Pattern.compile(HEIGHT_REGEX);
        Matcher matcher = pattern.matcher(line);
        double height;
        if (matcher.find()) {
            height = Double.parseDouble(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return height;
    }

    private double parseWidth(String line) throws DaoException {
        Pattern pattern = Pattern.compile(WIDTH_REGEX);
        Matcher matcher = pattern.matcher(line);
        double width;
        if (matcher.find()) {
            width = Double.parseDouble(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return width;
    }
}
