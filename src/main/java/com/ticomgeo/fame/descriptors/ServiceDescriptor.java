package com.ticomgeo.fame.descriptors;

import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.FameService;

import java.util.Collection;

public interface ServiceDescriptor<T extends FameService> {

    String getId();
    T getRealization();
    Collection<FameDesignator> getDesignators();
    Collection<ServiceProviderDescriptor> getProviders();
    Collection<ServiceConsumerDescriptor> getConsumers();
}
