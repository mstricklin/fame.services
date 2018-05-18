package com.ticomgeo.fame.providers;

import com.google.common.base.Joiner;
import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.NodeDescriptorTag;
import com.ticomgeo.fame.descriptors.*;
import com.ticomgeo.fame.services.QService;

import java.util.Arrays;
import java.util.Collection;

@NodeDescriptorTag(service = QService.class,
        id = "PeriodicEventProvider",
        realization = PeriodicEventProvider.class)
public class PeriodicEventProviderDescriptor implements ServiceProviderDescriptor<PeriodicEventProvider> {
    @Override
    public String getId() {
        return "PeriodicEventProvider";
    }

    @Override
    public PeriodicEventProvider getRealization(Collection<InitializationParameterDescriptor> params) {
        // TODO: pass params to ctor...
        return new PeriodicEventProvider(10);
    }

    @Override
    public Collection<FameDesignator> getDesignators() {
        // Should this be per-instance, or per-type?
        return Arrays.asList(FameDesignator.of("ProviderName", "PeriodicEventProvider"));
    }

    @Override
    public Collection<InitializationParameterDescriptor> getParameters() {
        return Arrays.asList(InitializationParameterDescriptor.of("period", true, "UnsignedInt"),
                             InitializationParameterDescriptor.of("duration", false, "Duration")
                );
    }

    @Override
    public DataProductType getType() {
        return DataProductType.TIMESTAMP;
    }

    @Override
    public DataProductionType getProduction() {
        return DataProductionType.DISCRETE_PERIODIC_CHRONOLOGICAL_EVENT;
    }

    @Override
    public ApiProtocolType getAccessProtocol() {
        return ApiProtocolType.FAME;
    }

    @Override
    public Collection<DataProductFormat> getProductFormats() {
        return Arrays.asList(DataProductFormat.FAME);
    }


    Joiner COMMA_JOINER = Joiner.on(", ");
    @Override
    public String toString() {
        return getId() + " [" + COMMA_JOINER.join(getParameters()) + "]";
    }
}
