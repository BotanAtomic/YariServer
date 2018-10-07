package com.yari.injector;

public abstract class AbstractModule {

    private Injector injector;

    public abstract void configure();

    void prepare(Injector injector) {
        this.injector = injector;
        this.configure();
    }

    public void bind(Class<?> clazz) {
        injector.bindClass(clazz);
    }
}
