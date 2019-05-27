package com.myapp.repository;

import com.myapp.ArchUnitExtensions;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "..com.myapp.repository..", importOptions = {ImportOption.DoNotIncludeTests.class})
class DefaultConstructorConventionTest {

    @ArchTest
    static final ArchRule entityClassShouldHaveDefaultConstructor =
            ArchRuleDefinition.classes()
                    .that()
                    .haveSimpleNameEndingWith("Entity")
                    .should(ArchUnitExtensions.haveDefaultConstructor());

}
