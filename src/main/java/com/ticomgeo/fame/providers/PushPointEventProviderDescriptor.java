package com.ticomgeo.fame.providers;

import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.InitializationParameter;
import com.ticomgeo.fame.descriptors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

// A.K.A. Node J
public class PushPointEventProviderDescriptor
        implements
        ServiceProviderDescriptor<PushPointEventProvider>,
        ServiceConsumerDescriptor<PushPointEventProvider> {
    @SuppressWarnings("unused")
    private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

    @SuppressWarnings("unused")
    private static final String NEWLINE = System.getProperty("line.separator");

    @Override
    public DataProductType getType() {
        return DataProductType.PUSHPOINT;
    }

    @Override
    public DataProductionType getProduction() {
        return DataProductionType.NON_CHRONOLOGICAL_EVENT;
    }

    @Override
    public ApiProtocolType getAccessProtocol() {
        return ApiProtocolType.FAME;
    }

    @Override
    public Collection<DataProductFormat> getProductFormats() {
        return Arrays.asList(DataProductFormat.FAME);
    }

    @Override
    public String getId() {
        return PushPointEventProvider.ID;
    }

    @Override
    public PushPointEventProvider getInstance(Collection<InitializationParameter> params) {
        // no params for this guys
        return new PushPointEventProvider();
    }

    @Override
    public Collection<FameDesignator> getDesignators() {
        // Should this be per-instance, or per-type?
        return Arrays.asList(FameDesignator.of("ProviderName", "PushPointEventProvider"));
    }

    @Override
    public Collection<InitializationParameterDescriptor> getParameters() {
        return Collections.emptyList();
    }

    @Override
    public Collection<DataInputDescriptor> getInputs() {
        // review the match-ups here...
        return newArrayList(
                DataInputDescriptor.builder(true, "Multiple")
                        .addAccessDescriptor(DataProductType.TIP, DataProductionType.NON_CHRONOLOGICAL_EVENT, ApiProtocolType.FAME)
                        .addAccessDescriptor(DataProductType.TIP, DataProductionType.APERIODIC_CHRONOLOGICAL_EVENT, ApiProtocolType.FAME)
                        .addAccessDescriptor(DataProductType.TIP, DataProductionType.STREAM, ApiProtocolType.FAME)
                        .build()
        );
    }
}
