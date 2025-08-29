package tech.ada.exercicios.lsp.pagamentos;

public class PagamentoParcelado extends Pagamento {
    private int parcelas;

    public PagamentoParcelado(double valor, int parcelas) {
        super(valor);
        this.parcelas = parcelas;
    }

    @Override
    public String processar() {
        if (parcelas <= 0) {
            throw new UnsupportedOperationException("Número de parcelas inválido!"); // Viola LSP
        }
        double valorParcela = valor / parcelas;
        return parcelas + " parcelas de R$ " + valorParcela;
    }
}