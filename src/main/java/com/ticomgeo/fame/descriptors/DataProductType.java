package com.ticomgeo.fame.descriptors;

import java.util.Arrays;
import java.util.Collection;

import static com.ticomgeo.fame.descriptors.DataProductType.ProcessingActivityType.PROSECUTE;
import static com.ticomgeo.fame.descriptors.DataProductType.ProcessingActivityType.SEARCH;

/**
 * @author mstricklin
 * @version 1.0

 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-DataProductType
 */
public interface DataProductType {
	enum ProcessingActivityType {
		SEARCH, PROSECUTE
	}

	String getName();
	Collection<ProcessingActivityType> getProcessingActivities();

	// ...
	// Required system-defined parameters
	//   Single signal, One or more frequency range,
	//
	// Optional system-defined parameters
	//   Area of Interest

	// instances...in the "real" world, would we load these from configuration?
	DataProductType AUDIO = new DataProductTypeImpl("audio", PROSECUTE);
	DataProductType DETECT = new DataProductTypeImpl("detect", SEARCH, PROSECUTE);
	DataProductType GEOLOCATION = new DataProductTypeImpl("geolocation", PROSECUTE);
	DataProductType IMAGE = new DataProductTypeImpl("image", SEARCH, PROSECUTE);
	DataProductType LOB = new DataProductTypeImpl("lob", SEARCH, PROSECUTE);
	DataProductType MEASUREMENT = new DataProductTypeImpl("measurement", SEARCH, PROSECUTE);
	DataProductType METRIC = new DataProductTypeImpl("metric", PROSECUTE);
	DataProductType NAVIGATION = new DataProductTypeImpl("navigation", PROSECUTE);
	DataProductType IQ = new DataProductTypeImpl("iq", PROSECUTE);
	DataProductType PSD = new DataProductTypeImpl("psd", SEARCH, PROSECUTE);
	DataProductType TIP = new DataProductTypeImpl("tip", SEARCH, PROSECUTE);
	DataProductType TIMESTAMP = new DataProductTypeImpl("timestamp", SEARCH, PROSECUTE);

	// In the "real" world, there would be a registry of product types
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<DataProductType> PRODUCT_TYPES = Arrays.asList(AUDIO, DETECT, GEOLOCATION, IMAGE, LOB, MEASUREMENT,
	                                                          METRIC, NAVIGATION, IQ, PSD, TIP, TIMESTAMP);


	class DataProductTypeImpl implements DataProductType {
		DataProductTypeImpl(String name_, ProcessingActivityType... activityTypes_) {
			this.name = name_;
			this.activityTypes = Arrays.asList(activityTypes_);
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Collection<ProcessingActivityType> getProcessingActivities() {
			return activityTypes;
		}

		private final String name;
		private final Collection<ProcessingActivityType> activityTypes;

	}
}
