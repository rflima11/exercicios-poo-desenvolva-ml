package tech.ada.exercicios.lsp.pagamentos;

public class ServicoDePagamentos {

    public String confirmarPagamento(Pagamento pagamento) {
        return pagamento.processar();
    }

}
