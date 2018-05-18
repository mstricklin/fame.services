package com.ticomgeo.fame.providers;

import com.ticomgeo.fame.FamePipelineNode;
import com.ticomgeo.fame.descriptors.FameNodeDescriptor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author mstricklin
 * @version 1.0
 */

public class PeriodicEventProvider implements FamePipelineNode {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");

	PeriodicEventProvider(int period) {
		this.period = period;
		this.duration = 0;
	}
	PeriodicEventProvider(int period, int duration) {
		this.period = period;
		this.duration = duration;
	}
	@Override
	public FameNodeDescriptor getDescriptor() {
		return null;
	}

	private final int period;
	private final int duration;
}