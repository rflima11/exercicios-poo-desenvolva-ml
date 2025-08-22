# Exercício: SRP e OCP — Relatório de Vendas em HTML

Você recebeu um código de `RelatorioVendas` que:
- Calcula comissão de acordo com o tipo do vendedor (`Junior`, `Pleno`, `Senior`);
- Gera o conteúdo **HTML** do relatório;
- **Salva** o relatório em um arquivo **.html** dentro da pasta `./relatorios` (relativa ao diretório atual).

Esse design viola **SRP** (uma classe com múltiplos motivos para mudar) e **OCP** (para estender comportamentos, é necessário modificar a classe existente).

---

## Tarefas

1. **Mapeie as responsabilidades** atualmente acopladas na classe:
    - Regra de negócio (cálculo da comissão);
    - Apresentação (geração do HTML);
    - Persistência/infra (criação de diretório, nome do arquivo, escrita em disco);

2. **Refatore aplicando SRP**:
    - Crie **uma classe/entidade** apenas para os dados do relatório;
    - Crie **estratégias de comissão** (ex.: `ComissaoJunior`, `ComissaoPleno`, `ComissaoSenior`);
    - Crie **um gerador de relatório** (ex.: `GeradorRelatorioHtml`) responsável somente por receber dados e produzir HTML;
    - Crie **um salvador** (ex.: `SalvadorArquivoLocal`) que saiba salvar conteúdo em `./relatorios`;

3. **Aplique OCP**:
    - Sua solução deve permitir **adicionar um novo tipo de comissão** sem modificar código existente (apenas adicionando uma nova estratégia);
    - Sua solução deve permitir **adicionar um novo formato de relatório** (ex.: PDF, Markdown, CSV) sem modificar as classes já estáveis;
    - Sua solução deve permitir **trocar o destino de persistência** (ex.: enviar por e-mail, salvar em S3, banco de dados) sem alterar classes existentes.

4. **Demonstre o uso**:
    - Crie um `main` (ou teste) que monte o pipeline: **entidade → estratégia de comissão → gerador HTML → salvador em arquivo → orquestrador**;
    - Mostre que é simples trocar a estratégia de comissão e/ou o gerador de relatório sem tocar nas outras classes.

---

## Dicas
- Use **interfaces** para `EstrategiaComissao`, `GeradorRelatorio` e `DestinoRelatorio` (ou similar);
- Evite `if/else` encadeados para comissão; prefira polimorfismo;

