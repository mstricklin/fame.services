package com.ticomgeo.fame.types;

import static com.google.common.base.Preconditions.checkState;

public class UnsignedInt implements Type<Integer> {

    public UnsignedInt(int val) {
        checkState(val >= 0);
        this.val = val;
    }
    public Integer value() {
        return val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    private final int val;
}
