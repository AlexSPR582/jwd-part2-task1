package com.alexander.task1.dao.parser.impl;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.entity.appliance.Speakers;
import com.alexander.task1.exception.DaoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeakersParser implements ApplianceParser {
    private static final String POWER_CONSUMPTION_REGEX = "POWER_CONSUMPTION=([\\p{Digit}]+)";
    private static final String NUMBER_OF_SPEAKERS_REGEX = "NUMBER_OF_SPEAKERS=([\\p{Digit}]+)";
    private static final String FREQUENCY_RANGE_REGEX = "FREQUENCY_RANGE=([\\p{Digit}]+(\\.[\\p{Digit}]+)?)-([\\p{Digit}]+(\\.[\\p{Digit}]+)?)";
    private static final String CORD_LENGTH_REGEX = "CORD_LENGTH=([\\p{Digit}]+)";

    @Override
    public Speakers parse(String line) throws DaoException {
        int powerConsumption = parsePowerConsumption(line);
        int numberOfSpeakers = parseNumberOfSpeakers(line);
        double[] frequencyRange = parseFrequencyRange(line);
        double minFrequency = frequencyRange[0];
        double maxFrequency = frequencyRange[1];
        int cordLength = parseCordLength(line);
        return new Speakers(powerConsumption, numberOfSpeakers, minFrequency, maxFrequency, cordLength);
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

    private int parseNumberOfSpeakers(String line) throws DaoException {
        Pattern pattern = Pattern.compile(NUMBER_OF_SPEAKERS_REGEX);
        Matcher matcher = pattern.matcher(line);
        int numberOfSpeakers;
        if (matcher.find()) {
            numberOfSpeakers = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return numberOfSpeakers;
    }

    private double[] parseFrequencyRange(String line) throws DaoException {
        Pattern pattern = Pattern.compile(FREQUENCY_RANGE_REGEX);
        Matcher matcher = pattern.matcher(line);
        double[] frequencyRange = new double[2];
        if (matcher.find()) {
            frequencyRange[0] = Double.parseDouble(matcher.group(1));
            frequencyRange[1] = Double.parseDouble(matcher.group(3));
        } else {
            throw new DaoException("parse exception");
        }
        return frequencyRange;
    }

    private int parseCordLength(String line) throws DaoException {
        Pattern pattern = Pattern.compile(CORD_LENGTH_REGEX);
        Matcher matcher = pattern.matcher(line);
        int cordLength;
        if (matcher.find()) {
            cordLength = Integer.parseInt(matcher.group(1));
        } else {
            throw new DaoException("parse exception");
        }
        return cordLength;
    }
}
