package com.alexander.task1.entity.appliance;

import com.alexander.task1.dao.parser.ApplianceParser;
import com.alexander.task1.dao.parser.impl.*;
import com.alexander.task1.service.validation.ApplianceValidator;
import com.alexander.task1.service.validation.impl.*;
import com.alexander.task1.view.ApplianceView;
import com.alexander.task1.view.impl.*;

public enum ApplianceType {
    OVEN (new OvenValidator(), new OvenParser(), new OvenView()),
    LAPTOP (new LaptopValidator(), new LaptopParser(), new LaptopView()),
    REFRIGERATOR (new RefrigeratorValidator(), new RefrigeratorParser(), new RefrigeratorView()),
    VACUUMCLEANER (new VacuumCleanerValidator(), new VacuumCleanerParser(), new VacuumCleanerView()),
    TABLETPC (new TabletPCValidator(), new TabletPCParser(), new TabletPCView()),
    SPEAKERS (new SpeakersValidator(), new SpeakersParser(), new SpeakersView());

    private ApplianceValidator validator;
    private ApplianceParser parser;
    private ApplianceView view;

    ApplianceType(ApplianceValidator validator, ApplianceParser parser, ApplianceView view) {
        this.validator = validator;
        this.parser = parser;
        this.view = view;
    }

    public ApplianceValidator getValidator() {
        return validator;
    }

    public ApplianceParser getParser() {
        return parser;
    }

    public ApplianceView getView() {
        return view;
    }
}
