<!-- Instruções concisas para agentes de código (Copilot / IA) trabalhando neste repositório -->
# Copilot / Agente: instruções rápidas

Objetivo: ser imediatamente produtivo neste projeto Spring Boot minimal.

- **Stack:** Java 17, Spring Boot 3, Spring Data JPA, Thymeleaf, H2 (runtime).
- **Build & run (dev):** use o wrapper Maven presente:
  - `./mvnw spring-boot:run` — inicia a aplicação web.
  - `./mvnw test` — executa testes.
  - `./mvnw package` — gera o JAR.

Diretório e arquivos-chave (referência):
- `src/main/java/com/example/gerenciador_de_tarefas/GerenciadorDeTarefasApplication.java` — ponto de entrada Spring Boot.
- `src/main/resources/application.properties` — propriedades da app (`spring.application.name=gerenciador_de_tarefas`).
- `src/main/resources/templates/` — views Thymeleaf.
- `src/main/resources/static/` — assets estáticos.
- `pom.xml` — dependências (JPA, Thymeleaf, H2, spring-boot-starter-test).

Padrões e convenções observadas (úteis para gerar/alterar código):
- Pacote base: `com.example.gerenciador_de_tarefas` (observe o uso de underscore no nome do pacote/artifactId).
- Persistência: JPA com H2 em tempo de execução; entidades normalmente usam `jakarta.persistence`.
- Views: usar Thymeleaf para páginas HTML; rotas e controllers seguem convenções Spring MVC.

Pontos importantes e anomalias detectadas (mantenha atenção):
- Há uma entidade `Tarefa` presente em `src/test/java/com/example/gerenciador_de_tarefas/model/Tarefa.java` — isso indica organização inconsistente (entidades deveriam estar em `src/main/java`). Evitar alterar testes sem confirmar com o mantenedor.
- Não há `.github/` existente — este arquivo será a fonte única de orientação para agentes.

Integrações externas e ambiente esperado:
- Banco: H2 (embutido) — não requer credenciais externas por enquanto.
- Nenhum serviço externo (APIs) ou credenciais detectadas no repositório.

Boas práticas específicas deste repositório (ações concretas):
- Ao criar novas entidades, coloque-as em `src/main/java/com/example/gerenciador_de_tarefas/model/`.
- Ao adicionar repositórios, use interfaces que extendam `org.springframework.data.jpa.repository.JpaRepository`.
- Ao modificar templates, atualize as rotas nos controllers correspondentes em `src/main/java/.../controller` (se existirem).

Exemplos rápidos (copiar/usar):
- Executar testes localmente: `./mvnw test`.
- Rodar app local: `./mvnw spring-boot:run` → acessar `http://localhost:8080`.

Checklist de PRs para agentes que geram código:
- Mantém Java 17 compatibilidade.
- Não mover testes para `main` sem aviso: preferir criar novas classes em `main` e ajustar imports.
- Atualiza `README.md` se adicionar endpoints ou instruções de execução.

Perguntas que o agente deve colocar ao autor humano antes de mudanças grandes:
- Deseja que eu mova a entidade `Tarefa` de `src/test` para `src/main`?
- Há convenções de naming/locale que devo respeitar (pt-BR para mensagens, por exemplo)?

Se algo não for detectável nos arquivos acima, peça acesso ao mantenedor antes de alterar behavior (DB, secrets, CI).
