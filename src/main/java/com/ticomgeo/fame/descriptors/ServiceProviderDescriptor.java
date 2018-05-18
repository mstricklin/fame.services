package com.ticomgeo.fame.descriptors;

import com.ticomgeo.fame.FamePipelineNode;

import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * Each Service Provider serves up a single type of data for a single API protocol, using a single data production approach. If data can be acquired from a given
 * source using multiple API protocols, or multiple production patterns, each combination must be expressed through a different service provider. Similarly, if a given
 * source can provide multiple types of data, each type of data must be expressed through a different service provider. Each source can provide the data of the
 * specified type in one or more formats, but every source must provide data in the "Fame" format for that data type.
 *
 * An instance of a provider is a pipeline node.
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceProviderDescriptor
 */
public interface ServiceProviderDescriptor<T extends FamePipelineNode> extends FameNodeDescriptor<T> {
	DataProductType getType();
	DataProductionType getProduction();
	ApiProtocolType getAccessProtocol();
	Collection<DataProductFormat> getProductFormats();
}
