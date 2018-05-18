package com.ticomgeo.fame.mcs;

import java.util.Collection;

/**
 * @author mstricklin
 * @version 1.0
 */
public interface ServiceProviderDescriptor2 {

	String getId();
	Class<?> getRealization();
	Collection<String> getDesignators();
	Collection<String> getParameters();
	String getType();
	String getProduction();
	String getAccessProtocol();
	Collection<String> getProductFormats();
}
