package com.ticomgeo.fame.providers;

import com.ticomgeo.fame.ConsumerDescriptorTag;
import com.ticomgeo.fame.FamePipelineNode;
import com.ticomgeo.fame.ProviderDescriptorTag;
import com.ticomgeo.fame.descriptors.FameNodeDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A.K.A. Node J
@ConsumerDescriptorTag(id="PeriodicEventProvider",
        descriptor=PushPointEventProviderDescriptor.class)
@ProviderDescriptorTag(id="PeriodicEventProvider",
        descriptor=PushPointEventProviderDescriptor.class)
public class PushPointEventProvider implements FamePipelineNode {

    @SuppressWarnings("unused")
    private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

    @SuppressWarnings("unused")
    private static final String NEWLINE = System.getProperty("line.separator");

    public static final String ID = "f57ac3ba-5ca2-11e8-9c2d-fa7ae01bbebc";


    @Override
    public FameNodeDescriptor getDescriptor() {
        return null;
    }
}
