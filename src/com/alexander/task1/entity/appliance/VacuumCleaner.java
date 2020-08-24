package com.alexander.task1.entity.appliance;

public class VacuumCleaner extends Appliance{
    private int powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner(int powerConsumption, String filterType, String bagType, String wandType, int motorSpeedRegulation, int cleaningWidth) {
        super("VacuumCleaner");
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacuumCleaner cleaner = (VacuumCleaner) o;
        return powerConsumption == cleaner.powerConsumption &&
                motorSpeedRegulation == cleaner.motorSpeedRegulation &&
                cleaningWidth == cleaner.cleaningWidth &&
                filterType.equals(cleaner.filterType) &&
                bagType.equals(cleaner.bagType) &&
                wandType.equals(cleaner.wandType);
    }

    @Override
    public int hashCode() {
        int hash = 31 * powerConsumption;
        hash += 31 * motorSpeedRegulation;
        hash += 31 * cleaningWidth;
        hash += filterType.hashCode();
        hash += bagType.hashCode();
        hash += wandType.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VacuumCleaner{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", filterType='").append(filterType).append('\'');
        sb.append(", bagType='").append(bagType).append('\'');
        sb.append(", wandType='").append(wandType).append('\'');
        sb.append(", motorSpeedRegulation=").append(motorSpeedRegulation);
        sb.append(", cleaningWidth=").append(cleaningWidth);
        sb.append('}');
        return sb.toString();
    }
}
