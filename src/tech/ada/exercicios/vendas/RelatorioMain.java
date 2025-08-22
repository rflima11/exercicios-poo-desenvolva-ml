package tech.ada.exercicios.vendas;

public class RelatorioMain {

    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Rodolfo", "Junior");

        RelatorioVendas relatorio = new RelatorioVendas(
                vendedor,
                3000
        );

        relatorio.salvarRelatorioHtmlEmDiretorioAtual();

        System.out.println("Relatório gerado com sucesso");
    }
}
