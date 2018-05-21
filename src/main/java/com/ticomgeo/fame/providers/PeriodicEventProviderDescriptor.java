package com.ticomgeo.fame.providers;

import com.google.common.base.Joiner;
import com.ticomgeo.fame.FameDesignator;
import com.ticomgeo.fame.InitializationParameter;
import com.ticomgeo.fame.descriptors.*;
import com.ticomgeo.fame.types.Duration;
import com.ticomgeo.fame.types.Period;
import com.ticomgeo.fame.types.UnsignedInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

// A.K.A. Node E
public class PeriodicEventProviderDescriptor implements ServiceProviderDescriptor<PeriodicEventProvider> {
    @SuppressWarnings("unused")
    private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

    @SuppressWarnings("unused")
    private static final String NEWLINE = System.getProperty("line.separator");

    @Override
    public String getId() {
        return PeriodicEventProvider.ID;
    }

    @Override
    public PeriodicEventProvider getInstance(Collection<InitializationParameter> params) {
        InstanceBuilder builder = of();
        for (InitializationParameter ip: params) {
            if ("period".equalsIgnoreCase(ip.getName()))
                builder.period( (Period) ip.getValue());
            else if ("duration".equalsIgnoreCase(ip.getName()))
                builder.duration( (Duration) ip.getValue());
        }
        return builder.build();
    }

    @Override
    public Collection<FameDesignator> getDesignators() {
        // Should this be per-instance, or per-type?
        return Arrays.asList(FameDesignator.of("ProviderName", "PeriodicEventProvider"));
    }

    @Override
    public Collection<InitializationParameterDescriptor> getParameters() {
        return Arrays.asList(InitializationParameterDescriptor.of("period", true, Period.class),
                InitializationParameterDescriptor.of("duration", false, Duration.class)
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

    // ================================
    public static InstanceBuilder of() {
        return new InstanceBuilder();
    }

    public static class InstanceBuilder {
        private InstanceBuilder() {
        }

        public InstanceBuilder period(Period period) {
            this.period = period;
            return this;
        }

        public InstanceBuilder duration(Duration duration) {
            this.duration = duration;
            return this;
        }

        public PeriodicEventProvider build() {
            // TODO: perform validation here...
            return new PeriodicEventProvider(period, duration);
        }

        private Period period;
        private Duration duration;
    }
    // ================================

    private static final Joiner COMMA_JOINER = Joiner.on(", ");

    @Override
    public String toString() {
        return getId() + " [" + COMMA_JOINER.join(getParameters()) + "]";
    }

}
