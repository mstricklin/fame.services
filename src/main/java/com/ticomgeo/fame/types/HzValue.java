package com.ticomgeo.fame.types;

import static com.google.common.base.Preconditions.checkState;

public class HzValue implements Type<Double> {

    public HzValue(double freq) {
        checkState(freq >= 0.0);
        this.freq = freq;
    }
    @Override
    public Double value() {
        return freq;
    }

    @Override
    public String toString() {
        return Double.toString(freq);
    }
    double freq;
}
