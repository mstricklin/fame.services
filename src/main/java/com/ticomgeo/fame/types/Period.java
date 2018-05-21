package com.ticomgeo.fame.types;

public class Period implements Type<java.time.Duration> {
    public Period(long seconds, long nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }
    public Period(java.time.Duration d) {
        this.seconds = d.getSeconds();
        this.nanos = d.getNano();
    }
    @Override
    public java.time.Duration value() {
        return java.time.Duration.ofSeconds(seconds).plusNanos(nanos);
    }
    @Override
    public String toString() {
        return value().toString();
    }
    private final long seconds;
    private final long nanos;
}
