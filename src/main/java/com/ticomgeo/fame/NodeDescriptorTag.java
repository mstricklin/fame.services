package com.ticomgeo.fame;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NodeDescriptorTag {
    String id();
    Class<? extends FameService> service();
    Class<? extends FamePipelineNode> realization();
}
