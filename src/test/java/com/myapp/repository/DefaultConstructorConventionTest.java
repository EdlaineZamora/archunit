package com.myapp.repository;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import static java.lang.String.format;

@AnalyzeClasses(packages = "..com.myapp.repository..", importOptions = {ImportOption.DoNotIncludeTests.class})
class DefaultConstructorConventionTest {

    @ArchTest
    static final ArchRule entityClassShouldHaveDefaultConstructor =
            ArchRuleDefinition.classes()
                    .that()
                    .haveSimpleNameEndingWith("Entity")
                    .should(haveDefaultConstructor());

    private static ArchCondition<JavaClass> haveDefaultConstructor() {
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
                return constructor.getRawParameterTypes().size() == 0;
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
