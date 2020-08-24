package com.alexander.task1.dao.parser;

import com.alexander.task1.entity.appliance.ApplianceType;
import com.alexander.task1.exception.DaoException;

public class ParserProvider {
    private static ParserProvider provider;

    public static ParserProvider getInstance() {
        if (provider == null) {
            provider = new ParserProvider();
        }
        return provider;
    }

    private ParserProvider() {}

    public ApplianceParser defineParser(String appliance) throws DaoException {
        if (appliance == null) {
            throw new DaoException("appliance is null");
        }
        try {
            return ApplianceType.valueOf(appliance.toUpperCase()).getParser();
        } catch (IllegalArgumentException e) {
            throw new DaoException("Invalid appliance", e);
        }
    }
}
