package com.alexander.task1.view;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.exception.ViewException;

import java.util.List;

public class ApplianceListView {
    public void printInfo(List<Appliance> appliances) throws ViewException {
        ViewProvider provider = ViewProvider.getInstance();
        for (Appliance appliance: appliances) {
            ApplianceView view = provider.defineView(appliance);
            view.print(appliance);
        }
    }
}
