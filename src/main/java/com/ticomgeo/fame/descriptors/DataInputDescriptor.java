package com.ticomgeo.fame.descriptors;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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

	static Builder builder(boolean required, String multiplicty) {
		return new Builder(required, multiplicty);
	}

	class Builder {
		private Builder(boolean required, String multiplicty) {
			this.required = required;
			this.multiplicty = multiplicty;
		}
		public Builder addAccessDescriptors(DataInputAccessDescriptor...descriptors) {
			inputDescriptors.addAll(Arrays.asList(descriptors));
			return this;
		}
		public Builder addAccessDescriptor(DataProductType dataProductType,
										   DataProductionType dataProductionType,
										   ApiProtocolType apiProtocolType) {
			inputDescriptors.add(
					DataInputAccessDescriptor.of(dataProductType, dataProductionType, apiProtocolType)
			);
			return this;
		}
		public DataInputDescriptor build() {
			return new DataInputDescriptor() {
				@Override
				public Collection<DataInputAccessDescriptor> getAccessTypes() {
					return inputDescriptors;
				}

				@Override
				public Boolean isRequired() {
					return required;
				}

				@Override
				public String getMultiplicity() {
					return multiplicty;
				}
			};
		}
		private final boolean required;
		private final String multiplicty;
		private final List<DataInputAccessDescriptor> inputDescriptors = newArrayList();
	}
}