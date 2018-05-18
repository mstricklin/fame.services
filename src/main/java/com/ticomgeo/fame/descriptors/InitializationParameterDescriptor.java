package com.ticomgeo.fame.descriptors;


/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-InitializationParameterDescriptor
 */
public interface InitializationParameterDescriptor {

	// The name of the parameter. Used when instantiating a value for the parameter
	String getName();

	// When true, an instantiation of the parameter value is required
	Boolean isRequired();

	// The type of the data value for the instantiated parameter
	String getType();

	static InitializationParameterDescriptor of(String name, boolean required, String type) {
		return new InitializationParameterDescriptorImpl(name, required, type);
	}

	class InitializationParameterDescriptorImpl implements InitializationParameterDescriptor {
		private InitializationParameterDescriptorImpl(String name_, boolean required_, String type_) {
			this.name = name_;
			this.required = required_;
			this.type = type_;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Boolean isRequired() {
			return required;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public String toString() {
			return type
					+ ": "
					+ name
					+ (required ? "(req)" : "");
		}
		private final String name;
		private final boolean required;
		private final String type;
	}
}