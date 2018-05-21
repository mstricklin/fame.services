package com.ticomgeo.fame;

import com.ticomgeo.fame.descriptors.ServiceProviderDescriptor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProviderDescriptorTag {
    String id();
    Class<? extends ServiceProviderDescriptor> descriptor();
}
