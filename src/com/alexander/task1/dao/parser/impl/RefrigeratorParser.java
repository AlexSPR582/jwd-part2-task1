package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.Refrigerator;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefrigeratorParser implements ApplianceParser {
    private static final String POWER_CONSUMPTION_REGEX = "POWER_CONSUMPTION=([\\p{Digit}]+)";
    private static final String WEIGHT_REGEX = "WEIGHT=([\\p{Digit}]+)";
    private static final String FREEZER_CAPACITY_REGEX = "FREEZER_CAPACITY=([\\p{Digit}]+)";
    private static final String OVERALL_CAPACITY_REGEX = "OVERALL_CAPACITY=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";
    private static final String HEIGHT_REGEX = "HEIGHT=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";
    private static final String WIDTH_REGEX = "WIDTH=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";

    @Override
    public Refrigerator parse(String line) throws DaoException {
        int powerConsumption = parsePowerConsumption(line);
        int weight = parseWeight(line);
        int freezerCapacity = parseFreezerCapacity(line);
        double overallCapacity = parseOverallCapacity(line);
        double height = parseHeight(line);
        double width = parseWidth(line);
        return new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
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

    private int parseFreezerCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(FREEZER_CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        int freezerCapacity;
        if (matcher.find()) {
            freezerCapacity = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return freezerCapacity;
    }

    private double parseOverallCapacity(String line) throws DaoException {
        Pattern pattern = Pattern.compile(OVERALL_CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(line);
        double overallCapacity;
        if (matcher.find()) {
            overallCapacity = Double.parseDouble(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return overallCapacity;
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
