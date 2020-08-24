package com.alexander.task1.view.impl;

import com.alexander.task1.entity.appliance.Appliance;
import com.alexander.task1.entity.appliance.Speakers;
import com.alexander.task1.view.ApplianceView;

public class SpeakersView implements ApplianceView {
    @Override
    public void print(Appliance appliance) {
        Speakers speakers = (Speakers) appliance;
        StringBuilder sb = new StringBuilder("Speakers : ");
        sb.append("POWER_CONSUMPTION=").append(speakers.getPowerConsumption()).append(", ");
        sb.append("NUMBER_OF_SPEAKERS=").append(speakers.getNumberOfSpeakers()).append(", ");
        sb.append("FREQUENCY_RANGE=").append(speakers.getMinFrequency()).
                append("-").append(speakers.getMaxFrequency()).append(", ");
        sb.append("CORD_LENGTH=").append(speakers.getCordLength());
        System.out.println(sb.toString());
    }
}
