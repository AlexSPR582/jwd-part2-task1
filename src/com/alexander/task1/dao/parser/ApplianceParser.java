package com.alexander.task1.dao.parser;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.exception.DaoException;

public interface ApplianceParser {
    Appliance parse(String line) throws DaoException;
}
