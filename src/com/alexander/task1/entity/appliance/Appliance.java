package com.alexander.task1.entity.appliance;

public abstract class Appliance {
    private String applianceName;

    public Appliance(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getApplianceName() {
        return applianceName;
    }
}
