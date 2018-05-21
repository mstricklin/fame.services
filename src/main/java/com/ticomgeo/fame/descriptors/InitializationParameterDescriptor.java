package com.ticomgeo.fame.descriptors;


import com.ticomgeo.fame.types.Type;

/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-InitializationParameterDescriptor
 */
public interface InitializationParameterDescriptor<T extends Type> {

	// The name of the parameter. Used when instantiating a value for the parameter
	String getName();

	// When true, an instantiation of the parameter value is required
	Boolean isRequired();

	// The type of the data value for the instantiated parameter
	Class<T> getType();

	static <T extends Type> InitializationParameterDescriptor of(String name, boolean required, Class<T> type) {
		return new InitializationParameterDescriptor() {
			@Override
			public String getName() {
				return name;
			}

			@Override
			public Boolean isRequired() {
				return required;
			}

			@Override
			public Class<T> getType() {
				return type;
			}

			@Override
			public String toString() {
				return type
						+ ": "
						+ name
						+ (required ? "(req)" : "");
			}
		};
	}
}