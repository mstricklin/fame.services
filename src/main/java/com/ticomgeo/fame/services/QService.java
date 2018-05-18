package com.ticomgeo.fame.services;

import com.ticomgeo.fame.FameService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author mstricklin
 * @version 1.0
 */
public class QService implements FameService {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");


	@Override
	public String toString() {
		return "QService";
	}
}