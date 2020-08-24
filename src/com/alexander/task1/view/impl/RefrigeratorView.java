package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.Refrigerator;
import com.alexander.task1.view.ApplianceView;

public class RefrigeratorView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        Refrigerator refrigerator = (Refrigerator) appliance;
        StringBuilder sb = new StringBuilder("Refrigerator : ");
        sb.append("POWER_CONSUMPTION=").append(refrigerator.getPowerConsumption()).append(", ");
        sb.append("WEIGHT=").append(refrigerator.getWeight()).append(", ");
        sb.append("FREEZER_CAPACITY=").append(refrigerator.getFreezerCapacity()).append(", ");
        sb.append("OVERALL_CAPACITY=").append(refrigerator.getOverallCapacity()).append(", ");
        sb.append("HEIGHT=").append(refrigerator.getHeight()).append(", ");
        sb.append("WIDTH=").append(refrigerator.getWidth());
        System.out.println(sb.toString());
    }
}
