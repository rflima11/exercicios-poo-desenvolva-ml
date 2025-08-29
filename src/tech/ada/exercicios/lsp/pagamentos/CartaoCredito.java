package tech.ada.exercicios.lsp.pagamentos;

public class CartaoCredito extends Pagamento {
    public CartaoCredito(double valor) {
        super(valor);
    }

    @Override
    public String processar() {
        return "Pagamento aprovado no cartão de crédito: R$ " + valor;
    }
}