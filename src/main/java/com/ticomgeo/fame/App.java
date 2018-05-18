package com.ticomgeo.fame;

import com.google.common.io.Resources;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.net.URL;

/**
 * @author mstricklin
 * @version 1.0
 */
public class App {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");

	public static void main(String[] args) {


		URL servicesConfig = Resources.getResource("services.json");
		ServiceRegistry regis = new ServiceRegistry(servicesConfig);


		ServiceRegistry svcRegistry = new ServiceRegistry("com.ticomgeo.fame");
		svcRegistry.dump();

	}

}