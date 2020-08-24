package com.alexander.task1.service.validation;

import com.alexander.task1.entity.appliance.ApplianceType;
import com.alexander.task1.exception.ServiceException;

public class ValidatorProvider {
    private static ValidatorProvider provider;

    public static ValidatorProvider getInstance() {
        if (provider == null) {
            provider = new ValidatorProvider();
        }
        return provider;
    }

    private ValidatorProvider() {}

    public ApplianceValidator defineValidator(String appliance) throws ServiceException {
        if (appliance == null) {
            throw new ServiceException("appliance is null");
        }
        try {
            return ApplianceType.valueOf(appliance.toUpperCase()).getValidator();
        } catch (IllegalArgumentException e) {
            throw new ServiceException("Invalid appliance", e);
        }
    }
}
