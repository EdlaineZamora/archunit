package com.myapp;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "..com.myapp..", importOptions = {DoNotIncludeTests.class})
class CyclicDependencyRulesTest {

    @ArchTest
    static final ArchRule noCyclesByMemberDependenciesBetweenModules =
            SlicesRuleDefinition.slices()
                    .matching("..(*)")
                    .should()
                    .beFreeOfCycles();

}
