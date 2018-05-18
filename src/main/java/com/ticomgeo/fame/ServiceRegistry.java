package com.ticomgeo.fame;

import com.google.common.collect.Maps;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.ticomgeo.fame.descriptors.ServiceConsumerDescriptor;
import com.ticomgeo.fame.descriptors.ServiceDescriptor;
import com.ticomgeo.fame.descriptors.ServiceProviderDescriptor;
import com.ticomgeo.fame.util.ClassUtils;

import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceRegistry {
	public static class ServiceDesc {
		String name;
		String classname;
	}

	ServiceRegistry(URL svcConfig) {
		ByteSource bs = Resources.asByteSource(svcConfig);

		Gson gson = new Gson();
		gson.fromJson(bs, Integer.class);
	}

	ServiceRegistry(String packageName) {
		services = Maps.toMap(serviceDescriptors(packageName), ServiceDescriptor::getRealization);
	}

	public void dump() {
		for (Map.Entry<ServiceDescriptor, FameService> e : services.entrySet()) {
			ServiceDescriptor<FameService> sd = e.getKey();
			System.out.printf("%s => %s\n", e.getKey(), e.getValue());
			System.out.printf("\tConsumers\n");
			for (ServiceConsumerDescriptor scd : sd.getConsumers()) {
				System.out.printf("\t\t%s\n", scd.getId());
			}
			System.out.printf("\tProviders\n");
			for (ServiceProviderDescriptor spd : sd.getProviders()) {
				System.out.printf("\t\t%s\n", spd);
			}
		}
	}

	static Collection<ServiceDescriptor> serviceDescriptors(String packageName) {
		// super-duper hinky
		return ClassUtils.annotatedClasses(packageName, ServiceDescriptorTag.class).stream().map(o -> (ServiceDescriptor) noThrowReify(o)).collect(Collectors.toList());
	}

	static <T> T noThrowReify(Class<T> clazz) {
		// yeah, this is hinky
		try {
			return (T) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null; // NPE, here we come!
	}

	private final Map<ServiceDescriptor, FameService> services;
}
