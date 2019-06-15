package com.myapp.extensions;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import static java.lang.String.format;

public class ArchUnitExtensions {

    public static ArchCondition<JavaClass> haveDefaultConstructor() {
        return new ArchCondition<JavaClass>("have default constructor") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
                Optional<JavaConstructor> defaultConstructor = javaClass.getAllConstructors()
                        .stream()
                        .filter(constructor -> javaClass.equals(constructor.getOwner()))
                        .filter(this::doesNotHaveParameters)
                        .filter(this::canBeInstantiated)
                        .findAny();

                conditionEvents.add(new SimpleConditionEvent(javaClass, defaultConstructor.isPresent(),
                        format("not found default constructor for class %s", javaClass.getName())));
            }

            private boolean doesNotHaveParameters(JavaConstructor constructor) {
                return constructor.getRawParameterTypes().isEmpty();
            }

            private boolean canBeInstantiated(JavaConstructor constructor) {
                try {
                    constructor.reflect().newInstance();
                    return true;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    return false;
                }
            }
        };
    }

}
