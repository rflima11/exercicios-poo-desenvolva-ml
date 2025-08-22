# Exercício: SRP e OCP — Relatório de Vendas

Você recebeu um sistema simples para geração de relatórios de vendas em HTML.  
Atualmente, a classe `RelatorioVendas`:

- Calcula a comissão do vendedor de acordo com sua senioridade (`Junior`, `Pleno`, `Senior`);
- Gera o conteúdo em HTML do relatório;
- Salva o arquivo no diretório `./relatorios`.

---

## Problema
Essa implementação concentra **múltiplas responsabilidades em uma única classe**.  
Com isso, temos alguns efeitos negativos:

- Viola o **SRP (Single Responsibility Principle)**: a classe muda por vários motivos diferentes (regras de comissão, formato do relatório, regras de persistência).  
- Viola o **OCP (Open/Closed Principle)**: para adicionar novos cálculos de comissão, novos formatos de relatório (ex.: PDF, Markdown) ou novas formas de salvar (ex.: e-mail, banco de dados), é necessário modificar diretamente a classe existente.  

---

## Sua tarefa
1. **Analise o código fornecido** e identifique claramente as violações de SRP e OCP.  
2. **Refatore o código** de forma que:  
   - Cada parte do sistema tenha uma responsabilidade única;  
   - Seja fácil estender a solução sem modificar código já existente.  
3. **Mostre um exemplo de uso** que demonstre a flexibilidade da sua solução.  

---

## O que observar
- Evite classes que façam mais de uma coisa ao mesmo tempo.  
- Prefira separar responsabilidades e trabalhar com abstrações (interfaces ou classes abstratas) para permitir extensões futuras.  
- Seu código deve permitir adicionar **novos tipos de comissão**, **novos formatos de relatório** e **novos destinos de saída** sem alterar as classes já existentes.  

---

## Dicas
- Pense em termos de **responsabilidades** antes de sair refatorando.  
- Considere usar polimorfismo para evitar `if/else` repetitivos.  
- Um bom design permite que você **adicione** novas funcionalidades sem precisar **mexer** no que já funciona.  
