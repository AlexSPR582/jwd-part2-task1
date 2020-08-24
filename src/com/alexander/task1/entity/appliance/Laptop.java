package com.alexander.task1.entity.appliance;

public class Laptop extends Appliance{
	private double batteryCapacity;
	private String os;
	private int memoryRom;
	private int systemMemory;
	private double cpu;
	private int displayInches;

    public Laptop(double batteryCapacity, String os, int memoryRom, int systemMemory, double cpu, int displayInches) {
        super("LAPTOP");
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryRom == laptop.memoryRom &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.cpu, cpu) == 0 &&
                displayInches == laptop.displayInches &&
                os.equals(laptop.os);
    }

    @Override
    public int hashCode() {
        int hash = Double.hashCode(batteryCapacity);
        hash += os.hashCode();
        hash += 31 * memoryRom;
        hash += 31 * systemMemory;
        hash += 31 * displayInches;
        hash += Double.hashCode(cpu);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", os='").append(os).append('\'');
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", systemMemory=").append(systemMemory);
        sb.append(", cpu=").append(cpu);
        sb.append(", displayInches=").append(displayInches);
        sb.append('}');
        return sb.toString();
    }
}
