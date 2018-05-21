package com.ticomgeo.fame.descriptors;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * Although this is a system type, the possible values are dynamically changing.
 * That is, this type cannot be changed into an enum.
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-DataProductFormat
 */
public interface DataProductFormat {
	String getName();

	// should this be "Collection<String> getApiVersions()"?
	//    or "String getApiVersion()"?
	Collection<String> getApiVersions();


	// instances...in the "real" world, would we load these from configuration?
	DataProductFormat APP_GEO = of("AppGeo", "2.3.0.0");
	DataProductFormat FAME = of("Fame", "1.0.0");
	DataProductFormat TRS = of("Trs", "1.3.8");
	DataProductFormat U_FORMAT = of("uFormat", "???");

	// In the "real" world, there would be a registry of product formats
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<DataProductFormat> FORMATS = Arrays.asList(APP_GEO, FAME, TRS, U_FORMAT);

	static DataProductFormat of(String name, String... apiVersions) {
		return new DataProductFormat() {
			@Override
			public String getName() {
				return name;
			}

			@Override
			public Collection<String> getApiVersions() {
				return Arrays.asList(apiVersions);
			}

			@Override
			public String toString() {
				return name + " [" + COMMA_JOINER.join(apiVersions) + "]";
			}
		};
	}

	Joiner COMMA_JOINER = Joiner.on(", ").skipNulls();
}
