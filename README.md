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
- Faça o checkout da branch TDC-BH-2019 e execute os testes. Todos estão falhando por falha nos padrões arquiteturais.

Repositório criado juntamente com [@erikaya](https://github.com/erikaya)
