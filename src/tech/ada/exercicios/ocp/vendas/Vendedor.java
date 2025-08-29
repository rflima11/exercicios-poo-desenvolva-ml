package tech.ada.exercicios.ocp.vendas;

public class Vendedor {

    private String nome;
    private String senioridade;

    public Vendedor(String nome, String senioridade) {
        this.nome = nome;
        this.senioridade = senioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(String senioridade) {
        this.senioridade = senioridade;
    }
}
