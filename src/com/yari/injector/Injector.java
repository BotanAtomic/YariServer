package com.yari.injector;

import com.yari.injector.api.Inject;
import com.yari.injector.api.InjectConfiguration;
import com.yari.utils.ExceptionManager;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Injector {

    private Map<Class<?>, Object> instances;

    private Map<String, Object> properties;

    private Injector() {
        this.instances = new ConcurrentHashMap<>();
    }

    public static Injector create() {
        return new Injector();
    }

    public void bind(AbstractModule... modules) {
        for (AbstractModule module : modules)
            module.prepare(this);

        instances.values().forEach(instance -> {
            Field[] fields = instance.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.isAnnotationPresent(InjectConfiguration.class)) {
                        field.set(instance, properties.get(field.getAnnotation(InjectConfiguration.class).value()));
                    } else if (field.isAnnotationPresent(Inject.class)) {
                        field.set(instance, instances.get(field.getType()));
                    }
                } catch (IllegalAccessException e) {
                    ExceptionManager.register(e);
                }
                field.setAccessible(false);
            }

        });
    }

    void bindClass(Class<?> clazz) {
        try {
            instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            ExceptionManager.register(e);
        }
    }

    public void bindConfiguration(JSONObject configuration) {
        this.properties = configuration.toMap();
    }

    public <T> Set<T> annotatedBy(Class<? extends Annotation> annotation, Class<T> cast) {
        return instances.values().stream().filter(instance -> instance.getClass().isAnnotationPresent(annotation)).map(o -> (T) o)
                .collect(Collectors.toSet());
    }

    public <T> T get(Class<T> abstractClass) {
        return (T) instances.get(abstractClass);
    }
}
