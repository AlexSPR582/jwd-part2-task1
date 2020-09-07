package com.alexander.task1.main;

import com.alexander.task1.entity.appliance.*;
import com.alexander.task1.entity.criteria.Criteria;
import com.alexander.task1.exception.ServiceException;
import com.alexander.task1.exception.ViewException;
import com.alexander.task1.service.ApplianceService;
import com.alexander.task1.service.ServiceFactory;
import com.alexander.task1.view.ApplianceListView;

import java.util.List;

public class Main {
	public static void main(String[] args) throws ServiceException, ViewException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add("CAPACITY", "33");

		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
		criteriaOven.add("BATTERY_CAPACITY", "1.5");

		Criteria criteriaRefrigerator = new Criteria(Refrigerator.class.getSimpleName());
		criteriaOven.add("OVERALL_CAPACITY", "350.5");

		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaOven.add("COLOR", "red");

		Criteria criteriaSpeakers = new Criteria(Speakers.class.getSimpleName());
		criteriaOven.add("FREQUENCY_RANGE", "2-3.5");

		Criteria criteriaVacuumCleaner = new Criteria(VacuumCleaner.class.getSimpleName());
		criteriaOven.add("BAG_TYPE", "AA-89");

		List<Appliance> ovenList = service.find(criteriaOven);
		List<Appliance> laptopList = service.find(criteriaLaptop);
		List<Appliance> refrigeratorList = service.find(criteriaRefrigerator);
		List<Appliance> tabletPCList  = service.find(criteriaTabletPC);
		List<Appliance> vacuumCleanerList = service.find(criteriaVacuumCleaner);
		List<Appliance> speakersList = service.find(criteriaSpeakers);

		ApplianceListView view = new ApplianceListView();
		view.printInfo(ovenList);
		view.printInfo(laptopList);
		view.printInfo(refrigeratorList);
		view.printInfo(tabletPCList);
		view.printInfo(vacuumCleanerList);
		view.printInfo(speakersList);
	}
}
