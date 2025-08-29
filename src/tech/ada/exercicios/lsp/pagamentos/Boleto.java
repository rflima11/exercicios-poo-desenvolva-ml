package tech.ada.exercicios.lsp.pagamentos;

public class Boleto extends Pagamento {
    public Boleto(double valor) {
        super(valor);
    }

    @Override
    public String processar() {
        return "Boleto gerado para pagamento de R$ " + valor;
    }
}