package com.ticomgeo.fame.types;

import static com.google.common.base.Preconditions.checkState;

public class Degree implements Type<Double> {
    public Degree(double degree) {
        this.degree = degree % 360.d;
    }
    public Degree(Radian rad) {
        this.degree = Math.toDegrees(rad.value()) % 360.0;
    }
    @Override
    public Double value() {
        return degree;
    }

    @Override
    public String toString() {
        return Double.toString(degree);
    }

    double degree;
}
