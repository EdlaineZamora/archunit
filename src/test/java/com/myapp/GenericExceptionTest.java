package com.myapp;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

@AnalyzeClasses(packages = "..com.myapp..", importOptions = DoNotIncludeTests.class)
class GenericExceptionTest {

    @ArchTest
    static final ArchRule shouldNotHaveGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

}
