package tech.ada.exercicios.ocp.vendas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioVendas {
    private Vendedor vendedor;
    private double valorTotal;

    public RelatorioVendas(Vendedor vendedor,
                           double valorTotal) {
        this.vendedor = vendedor;
        this.valorTotal = valorTotal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getValorTotal() {
        return valorTotal;
    }


    public double calcularComissao() {
        String senioridade = vendedor.getSenioridade();
        if (senioridade == null) return 0;
        if (senioridade.equalsIgnoreCase("Junior")) {
            return valorTotal * 0.02;
        } else if (senioridade.equalsIgnoreCase("Pleno")) {
            return valorTotal * 0.05;
        } else if (senioridade.equalsIgnoreCase("Senior")) {
            return valorTotal * 0.10;
        }
        return 0;
    }

    public String gerarHtml() {
        double comissao = calcularComissao();
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"pt-BR\">");
        sb.append("<head><meta charset=\"UTF-8\"><title>Relatório de Vendas</title></head>");
        sb.append("<body>");
        sb.append("<h1>Relatório de Vendas</h1>");
        sb.append("<ul>");
        sb.append("<li>Vendedor: ").append(vendedor.getNome()).append("</li>");
        sb.append("<li>Valor total: R$ ").append(String.format("%.2f", valorTotal)).append("</li>");
        sb.append("<li>Tipo do vendedor: ").append(vendedor.getSenioridade()).append("</li>");
        sb.append("<li>Comissão: R$ ").append(String.format("%.2f", comissao)).append("</li>");
        sb.append("</ul>");
        sb.append("</body></html>");
        return sb.toString();
    }

    public void salvarRelatorioHtmlEmDiretorioAtual() {
        String html = gerarHtml();

        String dirAtual = System.getProperty("user.dir");
        Path pastaRelatorios = Paths.get(dirAtual, "relatorios");

        try {
            if (!Files.exists(pastaRelatorios)) {
                Files.createDirectories(pastaRelatorios);
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String nomeArquivo = "relatorio_vendas_" + vendedor.getNome().replaceAll("\\s+", "_") + "_" + timestamp + ".html";
            Path caminhoArquivo = pastaRelatorios.resolve(nomeArquivo);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo.toFile()))) {
                writer.write(html);
            }

            System.out.println("Relatório salvo com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao salvar relatório em HTML: " + e.getMessage(), e);
        }
    }
}
