package com.fm.multisource;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		logger.debug("my debug is working");
	}

}
