package myproject.intern.util;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class ReflectionUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
    private static Reflections reflections;

    static {
        reflections = new Reflections("me.ele.arch.shaka");
    }

    public static <T> Set<Class<? extends T>> scannerSubType(Class<T> subType) {
        return reflections.getSubTypesOf(subType);
    }

    public static Set<Class<?>> getTypesAnnotatedWith(Annotation annotation) {
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public static <T> Set<T> newInstanceFromPackage(Class<T> subType) {
        Set<Class<? extends T>> classSet = scannerSubType(subType);
        Set<T> instanceSet = new HashSet<>();
        if (classSet == null || classSet.size() <= 0) {
            return instanceSet;
        }
        for (Class<? extends T> tClass : classSet) {
            try {
                instanceSet.add(tClass.newInstance());
            } catch (Exception e) {
                LOGGER.error("Cannot new an instance for " + tClass.getName(), e);
            }
        }
        return instanceSet;
    }
}
