package com.ticomgeo.fame.descriptors;

/**
 * @author mstricklin
 * @version 1.0
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-DataProductionType
 */
public enum DataProductionType {
	STREAM("Stream", GenerationMode.EVENT),
	DISCRETE_PERIODIC_CHRONOLOGICAL_EVENT("DiscretePeriodicChronologicalEvent", GenerationMode.EVENT),
	APERIODIC_CHRONOLOGICAL_EVENT("AperiodicChronologicalEvent", GenerationMode.EVENT),
	NON_CHRONOLOGICAL_EVENT("NonChronologicalEvent", GenerationMode.EVENT),
	ARCHIVE_QUERY("ArchiveQuery", GenerationMode.QUERY_RESPONSE),
	AD_HOC_QUERY("AdHocQuery", GenerationMode.QUERY_RESPONSE);


	enum GenerationMode {
		EVENT, QUERY_RESPONSE
	};

	public String getName() {
		return this.name;
	}
	public GenerationMode getGenerationMode() {
		return this.generationMode;
	}

	DataProductionType(String name_, GenerationMode generationMode_) {
		this.name = name_;
		this.generationMode = generationMode_;
	}

	private final GenerationMode generationMode;
	private final String name;
}
