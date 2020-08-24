package com.alexander.task1.entity.appliance;

public class TabletPC extends Appliance{
	private int batteryCapacity;
	private int displayInches;
	private int memoryRom;
	private int flashMemoryCapacity;
	private String color;

    public TabletPC(int batteryCapacity, int displayInches, int memoryRom, int flashMemoryCapacity, String color) {
        super("TabletPC");
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TabletPC tabletPC = (TabletPC) o;
        return batteryCapacity == tabletPC.batteryCapacity &&
                displayInches == tabletPC.displayInches &&
                memoryRom == tabletPC.memoryRom &&
                flashMemoryCapacity == tabletPC.flashMemoryCapacity &&
                color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int hash = 31 * batteryCapacity;
        hash += 31 * displayInches;
        hash += 31 * memoryRom;
        hash += 31 * flashMemoryCapacity;
        hash += color.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TabletPC{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", displayInches=").append(displayInches);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", flashMemoryCapacity=").append(flashMemoryCapacity);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
