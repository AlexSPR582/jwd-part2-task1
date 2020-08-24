package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.TabletPC;
import com.alexander.task1.view.ApplianceView;

public class TabletPCView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        TabletPC tabletPC = (TabletPC) appliance;
        StringBuilder sb = new StringBuilder("Refrigerator : ");
        sb.append("BATTERY_CAPACITY=").append(tabletPC.getBatteryCapacity()).append(", ");
        sb.append("DISPLAY_INCHES=").append(tabletPC.getDisplayInches()).append(", ");
        sb.append("MEMORY_ROM=").append(tabletPC.getMemoryRom()).append(", ");
        sb.append("FLASH_MEMORY_CAPACITY=").append(tabletPC.getFlashMemoryCapacity()).append(", ");
        sb.append("COLOR=").append(tabletPC.getColor());
        System.out.println(sb.toString());
    }
}
