package model;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
    // Atributos
    private int codigo;
    private String nome;
    private String descricao;
    private double venda;
    private double custo;
    private int quantest;

    // Construtor sem argumentos
    public Produto() {}

    // Construtor com argumentos
    public Produto(int codigo, String nome, String descricao, double venda, double custo, int quantest) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.venda = venda;
        this.custo = custo;
        this.quantest = quantest;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getQuantest() {
        return quantest;
    }

    public void setQuantest(int quantest) {
        this.quantest = quantest;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", venda=" + venda +
                ", custo=" + custo +
                ", quantest=" + quantest +
                '}';
    }
}
