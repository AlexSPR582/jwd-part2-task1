package com.alexander.task1.dao;

import com.alexander.task1.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	private static DAOFactory instance;
	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}
}
