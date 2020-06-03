package com.myapp.service;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.myapp..", importOptions = DoNotIncludeTests.class)
class AnnotationConventionTest {

    @ArchTest
    static final ArchRule classesShouldBeAnnotatedWithServiceAnnotation = ArchRuleDefinition.classes()
            .that().resideInAPackage("..service..")
            .and().haveSimpleNameEndingWith("Service")
            .and().areNotInterfaces()
            .should().beAnnotatedWith(Service.class);

}
