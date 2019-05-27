package com.myapp.general;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "..com.myapp..", importOptions = DoNotIncludeTests.class)
class LayeredArchitectureTest {

    private static final String PRESENTATION = "Presentation";
    private static final String SERVICE = "Service";
    private static final String REPOSITORY = "Repository";

    @ArchTest
    static final ArchRule layeredArchitectureRules = Architectures.layeredArchitecture()
            .layer(PRESENTATION).definedBy("..presentation")
            .layer(SERVICE).definedBy("..service")
            .layer(REPOSITORY).definedBy("..repository")

            .whereLayer(PRESENTATION).mayNotBeAccessedByAnyLayer()
            .whereLayer(SERVICE).mayOnlyBeAccessedByLayers(PRESENTATION)
            .whereLayer(REPOSITORY).mayOnlyBeAccessedByLayers(SERVICE);

}
