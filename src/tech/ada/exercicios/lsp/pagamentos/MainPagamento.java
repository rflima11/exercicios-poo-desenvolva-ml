package tech.ada.exercicios.lsp.pagamentos;

public class MainPagamento {

    public static void main(String[] args) {
        ServicoDePagamentos servico = new ServicoDePagamentos();

        Pagamento p1 = new CartaoCredito(200);
        Pagamento p2 = new Boleto(500);
        Pagamento p3 = new Pix(100);
        Pagamento p4 = new PagamentoParcelado(300, 0); // quebra LSP

        System.out.println(servico.confirmarPagamento(p1));
        System.out.println(servico.confirmarPagamento(p2));
        System.out.println(servico.confirmarPagamento(p3));
        System.out.println(servico.confirmarPagamento(p4));
    }

}
