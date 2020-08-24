package com.alexander.task1.service;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.exception.ServiceException;

import java.util.List;

public interface ApplianceService {
	List<Appliance> find(Criteria criteria) throws ServiceException;
}
