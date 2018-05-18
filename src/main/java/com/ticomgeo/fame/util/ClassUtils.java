package com.ticomgeo.fame.util;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


public class ClassUtils {

    public static Collection<Class<?>> packageClasses(String packageName) {
        try {
            final ClassLoader loader = Thread.currentThread()
                    .getContextClassLoader();
            return ClassPath.from(loader)
                    .getTopLevelClassesRecursive(packageName)
                    .stream()
                    .filter(clz -> !clz.getSimpleName().endsWith("_"))
                    .map(ClassPath.ClassInfo::load)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }

    public static Collection<Class<?>> annotatedClasses(String packageName, Class<? extends Annotation> annotation) {
        return packageClasses(packageName).stream()
                .filter(clz -> clz.isAnnotationPresent(annotation))
                .collect(Collectors.toSet());
    }

}
