package com.ticomgeo.fame.descriptors;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

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
    DataProductType PUSHPOINT = of("pushpoint", PROSECUTE);
    DataProductType AUDIO = of("audio", PROSECUTE);
	DataProductType DETECT = of("detect", SEARCH, PROSECUTE);
	DataProductType GEOLOCATION = of("geolocation", PROSECUTE);
	DataProductType IMAGE = of("image", SEARCH, PROSECUTE);
	DataProductType LOB = of("lob", SEARCH, PROSECUTE);
	DataProductType MEASUREMENT = of("measurement", SEARCH, PROSECUTE);
	DataProductType METRIC = of("metric", PROSECUTE);
	DataProductType NAVIGATION = of("navigation", PROSECUTE);
	DataProductType IQ = of("iq", PROSECUTE);
	DataProductType PSD = of("psd", SEARCH, PROSECUTE);
	DataProductType TIP = of("tip", SEARCH, PROSECUTE);
    DataProductType TIMESTAMP = of("timestamp", SEARCH, PROSECUTE);
    DataProductType TIMER = of("timer", SEARCH, PROSECUTE);

	// In the "real" world, there would be a registry of product types
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<DataProductType> PRODUCT_TYPES = Arrays.asList(AUDIO, DETECT, GEOLOCATION, IMAGE, LOB, MEASUREMENT,
	                                                          METRIC, NAVIGATION, IQ, PSD, TIP, TIMESTAMP);

	static DataProductType of(String name, ProcessingActivityType... activityTypes) {
	    return new DataProductType() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public Collection<ProcessingActivityType> getProcessingActivities() {
                return Arrays.asList(activityTypes);
            }
            @Override
            public String toString() {
                return name + ": [" + COMMA_JOINER.join(activityTypes) + "]";
            }
        };
    }

    Joiner COMMA_JOINER = Joiner.on(", ").skipNulls();
}
