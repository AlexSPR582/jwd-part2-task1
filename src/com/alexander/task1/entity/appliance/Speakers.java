package com.alexander.task1.entity.appliance;

public class Speakers extends Appliance{
	private int powerConsumption;
	private int numberOfSpeakers;
	private double minFrequency;
	private double maxFrequency;
	private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, double minFrequency, double maxFrequency, int cordLength) {
        super("SPEAKERS");
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(double minFrequency) {
        this.minFrequency = minFrequency;
    }

    public double getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(double maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption &&
                numberOfSpeakers == speakers.numberOfSpeakers &&
                Double.compare(speakers.minFrequency, minFrequency) == 0 &&
                Double.compare(speakers.maxFrequency, maxFrequency) == 0 &&
                cordLength == speakers.cordLength;
    }

    @Override
    public int hashCode() {
        int hash = 31 * powerConsumption;
        hash += 31 * numberOfSpeakers;
        hash += 31 * cordLength;
        hash += Double.hashCode(minFrequency);
        hash += Double.hashCode(maxFrequency);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Speakers{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", numberOfSpeakers=").append(numberOfSpeakers);
        sb.append(", minFrequency=").append(minFrequency);
        sb.append(", maxFrequency=").append(maxFrequency);
        sb.append(", cordLength=").append(cordLength);
        sb.append('}');
        return sb.toString();
    }
}
