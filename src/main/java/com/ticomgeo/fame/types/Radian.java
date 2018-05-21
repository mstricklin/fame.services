package com.ticomgeo.fame.types;

public class Radian implements Type<Double> {
    public Radian(double radian) {
        this.radian = radian % (2. * Math.PI);
    }
    public Radian(Degree degree) {
        this.radian = Math.toRadians(degree.value()) % (2. * Math.PI);
    }
    @Override
    public Double value() {
        return radian;
    }

    @Override
    public String toString() {
        return Double.toString(radian);
    }

    double radian;
}
