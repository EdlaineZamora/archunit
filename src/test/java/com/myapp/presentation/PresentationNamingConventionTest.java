package com.myapp.presentation;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "..com.myapp.presentation..", importOptions = {DoNotIncludeTests.class})
class PresentationNamingConventionTest {

    @ArchTest
    static final ArchRule classThatResideInPresentationPackageShouldBeHaveControllerSufix =
            ArchRuleDefinition.classes()
                .should().haveSimpleNameEndingWith("Endpoint");

}
