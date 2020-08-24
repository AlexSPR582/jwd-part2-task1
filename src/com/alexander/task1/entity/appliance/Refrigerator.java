package com.alexander.task1.entity.appliance;

public class Refrigerator extends Appliance{
	private int powerConsumption;
	private int weight;
	private int freezerCapacity;
	private double overallCapacity;
	private double height;
	private double width;

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity, double overallCapacity, double height, double width) {
        super("REFRIGERATOR");
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Refrigerator refrigerator = (Refrigerator) o;
        return powerConsumption == refrigerator.powerConsumption &&
                weight == refrigerator.weight &&
                freezerCapacity == refrigerator.freezerCapacity &&
                Double.compare(overallCapacity, refrigerator.overallCapacity) == 0  &&
                Double.compare(height, refrigerator.height) == 0 &&
                Double.compare(width, refrigerator.width) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 31 * powerConsumption;
        hash += 31 * weight;
        hash += 31 * freezerCapacity;
        hash += Double.hashCode(overallCapacity);
        hash += Double.hashCode(height);
        hash += Double.hashCode(width);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Refrigerator{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", weight=").append(weight);
        sb.append(", freezerCapacity=").append(freezerCapacity);
        sb.append(", overallCapacity=").append(overallCapacity);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
