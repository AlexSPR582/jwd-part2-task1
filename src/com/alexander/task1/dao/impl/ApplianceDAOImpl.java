package com.alexander.task1.dao.impl;

import com.alexander.task1.dao.ApplianceDAO;
import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.dao.parser.ParserProvider;
import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.exception.DaoException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String PROPERTY_PATH = "resources/file.properties";

    @Override
	public List<Appliance> find(Criteria criteria) throws DaoException {
        List<Appliance> appliances = new ArrayList<>();
        ParserProvider provider = ParserProvider.getInstance();
        ApplianceParser parser = provider.defineParser(criteria.getGroupSearchName());
        try (FileReader fr = new FileReader(getAppliancesPath());
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (matchParameters(line, criteria)) {
                    Appliance appliance = parser.parse(line);
                    appliances.add(appliance);
                }
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
        return appliances;
	}

    private String getAppliancesPath() throws DaoException {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTY_PATH)) {
            properties.load(inputStream);
            return properties.getProperty("path");
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    private boolean matchParameters(String line, Criteria criteria) {
	    String name = criteria.getGroupSearchName();
	    if (!line.startsWith(name)) {
	        return false;
        }
	    if (criteria.getParameters().isEmpty()) {
	        return true;
        }
	    for (String parameter: criteria.getParameters().keySet()) {
	        if (!line.contains(parameter + "=" + criteria.getValue(parameter))) {
	            return false;
            }
        }
	    return true;
    }
}