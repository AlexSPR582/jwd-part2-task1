package com.alexander.task1.view;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.ApplianceType;
import com.alexander.task1.exception.ViewException;

public class ViewProvider {
    private static ViewProvider provider;

    public static ViewProvider getInstance() {
        if (provider == null) {
            provider = new ViewProvider();
        }
        return provider;
    }

    private ViewProvider() {}

    public ApplianceView defineView(Appliance appliance) throws ViewException {
        if (appliance == null) {
            throw new ViewException("appliance is null");
        }
        return ApplianceType.valueOf(appliance.getApplianceName().toUpperCase()).getView();
    }
}
