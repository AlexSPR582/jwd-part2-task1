package com.alexander.task1.service.impl;

import com.alexander.task1.dao.ApplianceDAO;
import com.alexander.task1.dao.DAOFactory;
import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.exception.DaoException;
import com.alexander.task1.exception.ServiceException;
import com.alexander.task1.service.ApplianceService;
import com.alexander.task1.service.validation.ApplianceValidator;
import com.alexander.task1.service.validation.ValidatorProvider;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		ValidatorProvider provider = ValidatorProvider.getInstance();
		ApplianceValidator validator = provider.defineValidator(criteria.getGroupSearchName());
		if (!validator.validate(criteria)) {
			throw new ServiceException("Invalid request");
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		List<Appliance> appliances;
		try {
			appliances = applianceDAO.find(criteria);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return appliances;
	}
}
