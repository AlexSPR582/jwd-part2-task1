package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.VacuumCleaner;
import com.alexander.task1.view.ApplianceView;

public class VacuumCleanerView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        StringBuilder sb = new StringBuilder("Refrigerator : ");
        sb.append("POWER_CONSUMPTION=").append(vacuumCleaner.getPowerConsumption()).append(", ");
        sb.append("FILTER_TYPE=").append(vacuumCleaner.getFilterType()).append(", ");
        sb.append("BAG_TYPE=").append(vacuumCleaner.getBagType()).append(", ");
        sb.append("WAND_TYPE=").append(vacuumCleaner.getWandType()).append(", ");
        sb.append("MOTOR_SPEED_REGULATION=").append(vacuumCleaner.getMotorSpeedRegulation()).append(", ");
        sb.append("CLEANING_WIDTH=").append(vacuumCleaner.getCleaningWidth());
        System.out.println(sb.toString());
    }
}
