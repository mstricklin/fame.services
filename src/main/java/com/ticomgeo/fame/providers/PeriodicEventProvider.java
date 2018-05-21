package com.ticomgeo.fame.providers;

import com.ticomgeo.fame.FamePipelineNode;
import com.ticomgeo.fame.ProviderDescriptorTag;
import com.ticomgeo.fame.descriptors.FameNodeDescriptor;
import com.ticomgeo.fame.types.Duration;
import com.ticomgeo.fame.types.Period;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author mstricklin
 * @version 1.0
 */

// A.K.A. Node E
@ProviderDescriptorTag(id="PeriodicEventProvider",
		descriptor=PeriodicEventProviderDescriptor.class)
public class PeriodicEventProvider implements FamePipelineNode {

	@SuppressWarnings("unused")
	private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

	@SuppressWarnings("unused")
	private static final String NEWLINE = System.getProperty("line.separator");

	public static final String ID = "2b517da8-5ca3-11e8-9c2d-fa7ae01bbebc";

	PeriodicEventProvider(Period period) {
		this.period = period;
		this.duration = new Duration(0);
	}
	PeriodicEventProvider(Period period, Duration duration) {
		this.period = period;
		this.duration = duration;
	}
	@Override
	public FameNodeDescriptor getDescriptor() {
		return null;
	}

	private final Period period;
	private final Duration duration;
}