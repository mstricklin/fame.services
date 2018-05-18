package com.ticomgeo.fame.descriptors;

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
	DataProductFormat APP_GEO = new DataProductFormatImpl("AppGeo", "2.3.0.0");
	DataProductFormat FAME = new DataProductFormatImpl("Fame", "1.0.0");
	DataProductFormat TRS = new DataProductFormatImpl("Trs", "1.3.8");
	DataProductFormat U_FORMAT = new DataProductFormatImpl("uFormat", "???");

	// In the "real" world, there would be a registry of product formats
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<DataProductFormat> FORMATS = Arrays.asList(APP_GEO, FAME, TRS, U_FORMAT);


	// an implementation, stuck here for convenience.
	class DataProductFormatImpl implements DataProductFormat {
		private DataProductFormatImpl(String name_, String... apiVersions_) {
			this.name = name_;
			this.apiVersions = Arrays.asList(apiVersions_);
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Collection<String> getApiVersions() {
			return apiVersions;
		}

		private final String name;
		private final Collection<String> apiVersions;
	}
}
