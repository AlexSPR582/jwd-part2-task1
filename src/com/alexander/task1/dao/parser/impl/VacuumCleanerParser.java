package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.VacuumCleaner;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VacuumCleanerParser implements ApplianceParser {
    private static final String POWER_CONSUMPTION_REGEX = "POWER_CONSUMPTION=([\\p{Digit}]+)";
    private static final String FILTER_TYPE_REGEX = "FILTER_TYPE=([\\p{Upper}])";
    private static final String BAG_TYPE_REGEX = "BAG_TYPE=([\\p{Alnum}\\-]+)";
    private static final String WAND_TYPE_REGEX = "WAND_TYPE=([\\p{Lower}\\-]+)";
    private static final String MOTOR_SPEED_REGULATION_REGEX = "MOTOR_SPEED_REGULATION=([\\p{Digit}]+)";
    private static final String CLEANING_WIDTH_REGEX = "CLEANING_WIDTH=([\\p{Digit}]+)";

    @Override
    public VacuumCleaner parse(String line) throws DaoException {
        int powerConsumption = parsePowerConsumption(line);
        String filterType = parseFilterType(line);
        String bagType = parseBagType(line);
        String wandType = parseWandType(line);
        int motorSpeedRegulation = parseMotorSpeedRegulation(line);
        int cleaningWidth = parseCleaningWidth(line);
        return new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
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

    private String parseFilterType(String line) throws DaoException {
        Pattern pattern = Pattern.compile(FILTER_TYPE_REGEX);
        Matcher matcher = pattern.matcher(line);
        String filterType;
        if (matcher.find()) {
            filterType = matcher.group(1);
        } else {
            throw new DaoException("parse exception");
        }
        return filterType;
    }

    private String parseBagType(String line) throws DaoException {
        Pattern pattern = Pattern.compile(BAG_TYPE_REGEX);
        Matcher matcher = pattern.matcher(line);
        String bagType;
        if (matcher.find()) {
            bagType = matcher.group(1);
        } else {
            throw new DaoException("parse exception");
        }
        return bagType;
    }

    private String parseWandType(String line) throws DaoException {
        Pattern pattern = Pattern.compile(WAND_TYPE_REGEX);
        Matcher matcher = pattern.matcher(line);
        String wandType;
        if (matcher.find()) {
            wandType = matcher.group(1);
        } else {
            throw new DaoException("parse exception");
        }
        return wandType;
    }

    private int parseMotorSpeedRegulation(String line) throws DaoException {
        Pattern pattern = Pattern.compile(MOTOR_SPEED_REGULATION_REGEX);
        Matcher matcher = pattern.matcher(line);
        int motorSpeedRegulation;
        if (matcher.find()) {
            motorSpeedRegulation = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return motorSpeedRegulation;
    }

    private int parseCleaningWidth(String line) throws DaoException {
        Pattern pattern = Pattern.compile(CLEANING_WIDTH_REGEX);
        Matcher matcher = pattern.matcher(line);
        int cleaningWidth;
        if (matcher.find()) {
            cleaningWidth = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return cleaningWidth;
    }
}
