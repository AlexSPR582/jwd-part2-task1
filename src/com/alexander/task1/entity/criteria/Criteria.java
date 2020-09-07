package com.alexander.task1.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private String groupSearchName;
	private Map<String, String> criteria = new HashMap<>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, int value) {
		criteria.put(searchCriteria, Integer.toString(value));
	}

	public void add(String searchCriteria, double value) {
		criteria.put(searchCriteria, Double.toString(value));
	}

	public void add(String searchCriteria, String value) {
		criteria.put(searchCriteria, value);
	}

	public Map<String, String> getParameters() {
		return criteria;
	}

	public String getValue(String parameter) {
		return criteria.get(parameter);
	}
}
