package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.Oven;
import com.alexander.task1.view.ApplianceView;

public class OvenView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        Oven oven = (Oven) appliance;
        StringBuilder sb = new StringBuilder("Oven : ");
        sb.append("POWER_CONSUMPTION=").append(oven.getPowerConsumption()).append(", ");
        sb.append("WEIGHT=").append(oven.getWeight()).append(", ");
        sb.append("CAPACITY=").append(oven.getCapacity()).append(", ");
        sb.append("DEPTH=").append(oven.getDepth()).append(", ");
        sb.append("HEIGHT=").append(oven.getHeight()).append(", ");
        sb.append("WIDTH=").append(oven.getWidth());
        System.out.println(sb.toString());
    }
}
