package com.ticomgeo.fame.descriptors;

import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-DataInputDescriptor
 */
public interface DataInputDescriptor {

	// Array of descriptors for the types of data that can be provided for
	// this data input
	Collection<DataInputAccessDescriptor> getAccessTypes();

	// When true, an instantiation of the service containing the consumer
	// for this input must include at least one provider of this type of input data
	Boolean isRequired();

	// When "unlimited", any number of providers of this type of input data
	// can be included in an instantiation of the service containing the
	// consumer for this input
	String getMultiplicity();
}