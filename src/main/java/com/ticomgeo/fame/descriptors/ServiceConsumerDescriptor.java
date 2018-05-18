package com.ticomgeo.fame.descriptors;

import com.ticomgeo.fame.FamePipelineNode;

import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 *
 * An instance of a consumer is a pipeline node.
 *
 * See:
 * https://confluence.ticom-geo.com:8443/display/~jsneary/Fabric+Automated+Mission+Engine?focusedCommentId=56787391#FabricAutomatedMissionEngine-ServiceConsumerDescriptor
 */
public interface ServiceConsumerDescriptor<T extends FamePipelineNode> extends FameNodeDescriptor<T> {
	Collection<DataInputDescriptor> getInputs();
}
