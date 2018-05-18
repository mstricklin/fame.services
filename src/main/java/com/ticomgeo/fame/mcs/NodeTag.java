package com.ticomgeo.fame.mcs;

import java.lang.annotation.*;

/**
 * @author mstricklin
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NodeTag {
	Class<?> descriptor();
	String id() default "";
}
