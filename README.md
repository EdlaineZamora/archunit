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

---

# archunit
Projeto para teste de arquitetura com ArchUnit.

Este módulo apresenta alguns exemplos sobre como usar o ArchUnit com o suporte ao teste do JUnit 5, onde as classes de teste são simplesmente selecionadas por meio de anotações com `@AnalyzeClasses` utilizando o cache default de importação para classes Java.

Todas as regras de exemplo encontradas dentro de `src/test` referem-se a classes de `src/main`.
Estes testes são todos projetados para demonstrar como o código de produção pode ser protegido de violações de restrições arquitetônicas típicas (como dependências de camada e convenções de nomes, por exemplo).

Você pode executar os testes com Maven com o seguinte comando ou através de sua IDE de preferência.

```
 mvn test
```

##### Exemplos contidos nessa aplicação
- Depêndencia Cíclica entre pacotes
- Exceções Genéricas
- Dependência entre camadas em uma Arquitetura em Camadas
- Convenção de Nome de classes
- Construtor Padrão
- Uso de anotação

##### Exemplo de testes que encontram problema na arquitetura
- Faça o checkout da branch TDC-BH-2019 e execute os testes. Todos encontram falhas nos padrões arquiteturais.

Repositório criado juntamente com [@erikaya](https://github.com/erikaya)
