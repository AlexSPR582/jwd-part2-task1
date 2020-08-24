package com.alexander.task1.entity.appliance;

public class Oven extends Appliance{
	private int powerConsumption;
	private int weight;
	private int capacity;
	private int depth;
	private double height;
	private double width;

    public Oven(int powerConsumption, int weight, int capacity, int depth, double height, double width) {
        super("OVEN");
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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
        Oven oven = (Oven) o;
        return powerConsumption == oven.powerConsumption &&
                weight == oven.weight &&
                capacity == oven.capacity &&
                depth == oven.depth &&
                Double.compare(height, oven.height) == 0 &&
                Double.compare(width, oven.width) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 31 * powerConsumption;
        hash += 31 * weight;
        hash += 31 * capacity;
        hash += 31 * depth;
        hash += Double.hashCode(height);
        hash += Double.hashCode(width);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oven{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", weight=").append(weight);
        sb.append(", capacity=").append(capacity);
        sb.append(", depth=").append(depth);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
