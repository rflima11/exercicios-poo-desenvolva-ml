# Exercícios: Princípio de Substituição de Liskov (LSP)

## Objetivo
Explorar violações do **Princípio de Substituição de Liskov (LSP)** em cenários próximos ao mundo real, mas ainda simples e sem bibliotecas externas além da JRE.

O LSP afirma que:
> "Se `S` é subtipo de `T`, objetos de `T` podem ser substituídos por objetos de `S` sem alterar a correção do programa."

---

## Exercício 1 – Sistema de Pagamentos
Você tem um serviço de pagamentos que processa diferentes formas de pagamento: **Cartão de Crédito, Boleto, Pix e Parcelado**.

O problema é que `PagamentoParcelado` lança uma exceção inesperada quando recebe um número inválido de parcelas. Isso viola o LSP, porque o cliente espera poder processar qualquer `Pagamento` sem lidar com exceções inesperadas.

### Estrutura inicial
- Classe base: `Pagamento`
- Subclasses: `CartaoCredito`, `Boleto`, `Pix`, `PagamentoParcelado`
- Serviço: `ServicoDePagamentos` que recebe qualquer `Pagamento` e retorna uma mensagem de confirmação.

### Tarefa
1. Identifique onde ocorre a violação do LSP.
2. Refatore o código de forma que `PagamentoParcelado` respeite o contrato da classe `Pagamento`.
3. Explore diferentes formas de resolver:
   - Garantir estado válido no construtor.
   - Criar uma hierarquia diferente (`PagamentoUnico` e `PagamentoParcelado`).
   - Usar composição ou estratégias para processar o pagamento.

### Uso esperado
```java
ServicoDePagamentos servico = new ServicoDePagamentos();
Pagamento p1 = new CartaoCredito(200);
Pagamento p2 = new Boleto(500);
Pagamento p3 = new Pix(100);
Pagamento p4 = new PagamentoParcelado(300, 0); // comportamento inesperado

System.out.println(servico.confirmarPagamento(p1));
System.out.println(servico.confirmarPagamento(p2));
System.out.println(servico.confirmarPagamento(p3));
System.out.println(servico.confirmarPagamento(p4));
```

## Importante
- **Não há apenas uma resposta correta**. O objetivo é exercitar a análise crítica de design.
- O foco está em **identificar a quebra do LSP e propor alternativas**.


