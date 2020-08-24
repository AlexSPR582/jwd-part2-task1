package com.alexander.task1.dao;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.exception.DaoException;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria) throws DaoException;
}
