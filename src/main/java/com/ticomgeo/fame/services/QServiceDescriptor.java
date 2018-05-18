package com.ticomgeo.fame.services;

import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.ServiceDescriptorTag;
import com.ticomgeo.fame.descriptors.ServiceConsumerDescriptor;
import com.ticomgeo.fame.descriptors.ServiceDescriptor;
import com.ticomgeo.fame.descriptors.ServiceProviderDescriptor;
import com.ticomgeo.fame.providers.PeriodicEventProviderDescriptor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


@ServiceDescriptorTag(id = "QService",
        realization = QService.class)
public class QServiceDescriptor implements ServiceDescriptor<QService> {
    @Override
    public String getId() {
        return "QService";
    }

    @Override
    public QService getRealization() {
        return new QService();
    }

    @Override
    public Collection<FameDesignator> getDesignators() {
        // Should this be per-instance, or per-type?
        return Arrays.asList(FameDesignator.of("ServiceName", "QService"));
    }
    @Override
    public Collection<ServiceProviderDescriptor> getProviders() {
        return Arrays.asList(new PeriodicEventProviderDescriptor());
    }

    @Override
    public Collection<ServiceConsumerDescriptor> getConsumers() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "QServiceDescriptor";
    }
}