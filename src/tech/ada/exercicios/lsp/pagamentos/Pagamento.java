package tech.ada.exercicios.lsp.pagamentos;

public abstract class Pagamento {
    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // Cada pagamento retorna uma mensagem de confirmação
    public abstract String processar();

}