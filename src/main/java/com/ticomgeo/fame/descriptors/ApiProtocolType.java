package com.ticomgeo.fame.descriptors;

import com.google.common.base.Joiner;

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
	ApiProtocolType ANY = of("Any", "N/A");
	ApiProtocolType APP_GEO = of("AppGeo", "2.3.0.0");
	ApiProtocolType FAME = of("Fame", "1.0.0");
	ApiProtocolType TRS = of("Trs", "1.3.8");

	// In the "real" world, there would be a registry of protocol types
	// the universe of types is dynamic, but probably static across runs (?)
	Collection<ApiProtocolType> PROTOCOL_TYPES = Arrays.asList(ANY, APP_GEO, FAME, TRS);


	static ApiProtocolType of(String name, String... apiVersions) {
		return new ApiProtocolType() {
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
