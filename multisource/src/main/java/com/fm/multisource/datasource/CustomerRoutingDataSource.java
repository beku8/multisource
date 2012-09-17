package com.fm.multisource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomerRoutingDataSource extends AbstractRoutingDataSource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected Object determineCurrentLookupKey() {
		Integer type = CustomerContextHolder.getCustomerType();
		logger.debug("returning type {}", type);
		return type;
	}

}
