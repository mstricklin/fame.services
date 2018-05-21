package com.ticomgeo.fame.types;

public class Instant implements Type<java.time.Instant> {
    public Instant(long seconds, long nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }

    @Override
    public java.time.Instant value() {
        java.time.Instant.ofEpochSecond(seconds).plusNanos(nanos);
        return null;
    }

    @Override
    public String toString() {
        return value().toString();
    }

    private final long seconds;
    private final long nanos;
}
