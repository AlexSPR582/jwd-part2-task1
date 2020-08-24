package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.Laptop;
import com.alexander.task1.view.ApplianceView;

public class LaptopView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        Laptop laptop = (Laptop) appliance;
        StringBuilder sb = new StringBuilder("Laptop : ");
        sb.append("BATTERY_CAPACITY=").append(laptop.getBatteryCapacity()).append(", ");
        sb.append("OS=").append(laptop.getOs()).append(", ");
        sb.append("MEMORY_ROM=").append(laptop.getMemoryRom()).append(", ");
        sb.append("SYSTEM_MEMORY=").append(laptop.getSystemMemory()).append(", ");
        sb.append("CPU=").append(laptop.getCpu()).append(", ");
        sb.append("DISPLAY_INCHES=").append(laptop.getDisplayInches());
        System.out.println(sb.toString());
    }
}
