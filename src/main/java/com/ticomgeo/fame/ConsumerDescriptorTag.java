package com.ticomgeo.fame;

import com.ticomgeo.fame.descriptors.FameNodeDescriptor;
import com.ticomgeo.fame.descriptors.ServiceConsumerDescriptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConsumerDescriptorTag {
    String id();
    Class<? extends ServiceConsumerDescriptor> descriptor();
}
