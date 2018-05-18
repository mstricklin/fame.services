package com.ticomgeo.fame.mcs;

import com.google.inject.Guice;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.Collections;

/**
 * @author mstricklin
 * @version 1.0
 */
public class PeriodicEvenProviderDescriptor2 implements ServiceProviderDescriptor2 {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");

	public static PeriodicEvenProviderDescriptor2 instance() {
		// TODO: double lock
		if (null == INSTANCE) {
			INSTANCE = new PeriodicEvenProviderDescriptor2();
		}
//		Guice.createInjector()
		return INSTANCE;
	}

	private static PeriodicEvenProviderDescriptor2 INSTANCE = null;

	@Override
	public String getId() {
		return "PeriodicEvenProviderDescriptor2";
	}

	@Override
	public Class<?> getRealization() {
		return PeriodicEventProvider2.class;
	}

	@Override
	public Collection<String> getDesignators() {
		return Collections.emptyList();
	}

	@Override
	public Collection<String> getParameters() {
		return Collections.emptyList();
	}

	@Override
	public String getType() {
		return "";
	}

	@Override
	public String getProduction() {
		return "";
	}

	@Override
	public String getAccessProtocol() {
		return "";
	}

	@Override
	public Collection<String> getProductFormats() {
		return Collections.emptyList();
	}
}