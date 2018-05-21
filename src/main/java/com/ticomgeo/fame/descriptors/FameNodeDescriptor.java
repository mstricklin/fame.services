package com.ticomgeo.fame.descriptors;

import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.FamePipelineNode;
import com.ticomgeo.fame.InitializationParameter;
import com.ticomgeo.fame.providers.PeriodicEventProvider;

import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * Abstraction of common elements for Nodes
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceConsumerDescriptor
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceProviderDescriptor
 */
public interface FameNodeDescriptor<T extends FamePipelineNode> {
	String getId();
	T getInstance(Collection<InitializationParameter> params);
	Collection<FameDesignator> getDesignators();
	Collection<InitializationParameterDescriptor> getParameters();
}
