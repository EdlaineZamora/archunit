# archunit
Architecture testing with ArchUnit.

This module presents examples on how to use ArchUnit with JUnit 5 testing support, where classes are selected using annotation `@AnalyzeClasses` and also using the default import cache for Java classes.

All of rules found within `src/test` refer to `src/main` classes.
These tests are all designed to demonstrate how the code can be protected from violations of typical architectural constraints (such as layer dependencies and naming conventions, for example).

You can run the tests with Maven (dependency manager) with the following command or through your preferred IDE.

```
 mvn test
```

##### Examples in this application
- Cyclic dependency between packages
- Generic Exceptions
- Dependency between layers in a Layered Architecture
- Class Name Convention
- Default Constructor
- Annotation usage

##### Example of tests that find problems in the architecture
- Checkout the branch TDC-BH-2019 and run the tests. Everyone finds failures in architectural standards.

Repository created together with [@erikaya](https://github.com/erikaya)
