package com.ticomgeo.fame;

/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceConsumerDescriptor
 *
 * The collection of designators for this consumer. Generally,
 * each consumer that provides a value for a given name would
 * provide a distinct value for that name that does not conflict
 * with the value provided by another consumer for that name. This
 * is a suggestion, not a requirement.
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceProviderDescriptor
 *
 * The collection of designators for this provider. Generally, each
 * provider that provides a value for a given name would provide a
 * distinct value for that name that does not conflict with the value
 * provided by another provider for that name. This is a suggestion,
 * not a requirement.
 *
 */
public interface FameDesignator {
	String getDesignator();
	String getValue();

	static FameDesignator of(String designator, String value) {
		return new FameDesignator() {
			@Override
			public String getDesignator() {
				return designator;
			}

			@Override
			public String getValue() {
				return value;
			}

			@Override
			public String toString() {
			    return designator + ":" + value;
			}
		};
	}
}
