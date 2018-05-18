package com.ticomgeo.fame.descriptors;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * Although this is a system type, the possible values are dynamically changing. That is, this type cannot be changed into an enum.
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ApiProtocolType
 */
public interface ApiProtocolType {
	String getName();

	// should this be "Collection<String> getApiVersions()"?
	//    or "String getApiVersion()"?
	Collection<String> getApiVersions();

	// instances...in the "real" world, would we load these from configuration?
	ApiProtocolType ANY = new ApiProtocolTypeImpl("Any", "N/A");
	ApiProtocolType APP_GEO = new ApiProtocolTypeImpl("AppGeo", "2.3.0.0");
	ApiProtocolType FAME = new ApiProtocolTypeImpl("Fame", "1.0.0");
	ApiProtocolType TRS = new ApiProtocolTypeImpl("Trs", "1.3.8");

	// In the "real" world, there would be a registry of protocol types
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<ApiProtocolType> PROTOCOL_TYPES = Arrays.asList(ANY, APP_GEO, FAME, TRS);


	// an implementation, stuck here for convenience.
	class ApiProtocolTypeImpl implements ApiProtocolType {
		private ApiProtocolTypeImpl(String name_, String... apiVersions_) {
			this.name = name_;
			this.apiVersions = Arrays.asList(apiVersions_);
		}
		@Override
		public String getName() {
			return null;
		}

		@Override
		public Collection<String> getApiVersions() {
			return apiVersions;
		}
		private final String name;
		private final Collection<String> apiVersions;
	}

}
