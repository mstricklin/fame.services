package com.ticomgeo.fame.descriptors;

/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-DataInputAccessDescriptor
 */
public interface DataInputAccessDescriptor {
	// When "unlimited", any number of providers of
	// this type of input data can be included in an
	// instantiation of the service containing the consumer for this input
	DataProductType getType();

	// The way in which the data must be produced (e.g., event, query, etc.)
	DataProductionType getProduction();

	// The API protocol requirement for a provider of this data input
	ApiProtocolType getProtocol();
}
