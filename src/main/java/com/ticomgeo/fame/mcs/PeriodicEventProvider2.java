package com.ticomgeo.fame.mcs;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author mstricklin
 * @version 1.0
 */

@NodeTag(descriptor = PeriodicEvenProviderDescriptor2.class,
         id = "PeriodicEventProvider2")
public class PeriodicEventProvider2 {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");

	public static PeriodicEvenProviderDescriptor2 getDescriptor() {
		return PeriodicEvenProviderDescriptor2.instance();
	}
	PeriodicEventProvider2(int period) {
		this.period = period;
		this.duration = 0;
	}
	PeriodicEventProvider2(int period, int duration) {
		this.period = period;
		this.duration = duration;
	}
	private final int period;
	private final int duration;
}