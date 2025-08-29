package tech.ada.exercicios.lsp.pagamentos;

public class Pix extends Pagamento {
    public Pix(double valor) {
        super(valor);
    }

    @Override
    public String processar() {
        return "Pagamento via Pix realizado: R$ " + valor;
    }
}
