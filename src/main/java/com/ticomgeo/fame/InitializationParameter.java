package com.ticomgeo.fame;

public interface InitializationParameter<T> {
    String getName();
    Class<?> getType();
    T getValue();

    static <T> InitializationParameter<T> of(String name, Class<T> clazz, T value) {
        return new InitializationParameter<T>() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public Class<T> getType() {
                return clazz;
            }

            @Override
            public T getValue() {
                return value;
            }

            @Override
            public String toString() {
                return name + "=" + getValue().toString() + " [" + getType().getSimpleName() + "]";
            }
        };
    }
}
