package com.alexander.task1.service;

import com.alexander.task1.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {
	private static ServiceFactory instance;
	private static ApplianceService applianceService = new ApplianceServiceImpl();

	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}

	private ServiceFactory() {}

	public ApplianceService getApplianceService() {
		return applianceService;
	}
}
