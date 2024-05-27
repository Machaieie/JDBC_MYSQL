package controller;

import model.Produto;
import servico.ProdutoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoController {

    private ProdutoService produtoService;
    private JTextField txtCodigo, txtNome, txtDescricao, txtVenda, txtCusto, txtQuantest;
    private JTable table;
    private DefaultTableModel tableModel;

    public ProdutoController(JTextField txtCodigo, JTextField txtNome, JTextField txtDescricao, JTextField txtVenda, JTextField txtCusto, JTextField txtQuantest, JTable table) {
        this.produtoService = new ProdutoService();
        this.txtCodigo = txtCodigo;
        this.txtNome = txtNome;
        this.txtDescricao = txtDescricao;
        this.txtVenda = txtVenda;
        this.txtCusto = txtCusto;
        this.txtQuantest = txtQuantest;
        this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();
    }

    public void adicionarProduto() {
        Produto produto = new Produto(
                Integer.parseInt(txtCodigo.getText()),
                txtNome.getText(),
                txtDescricao.getText(),
                Double.parseDouble(txtVenda.getText()),
                Double.parseDouble(txtCusto.getText()),
                Integer.parseInt(txtQuantest.getText())
        );
        boolean adicionou = produtoService.adicionarProduto(produto);
        if (adicionou) {
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
            listarTodos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto.");
        }
    }

    public void buscarProduto() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        Produto produto = produtoService.buscarProduto(codigo);
        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtDescricao.setText(produto.getDescricao());
            txtVenda.setText(String.valueOf(produto.getVenda()));
            txtCusto.setText(String.valueOf(produto.getCusto()));
            txtQuantest.setText(String.valueOf(produto.getQuantest()));
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }

    public void atualizarProduto() {
        Produto produto = new Produto(
                Integer.parseInt(txtCodigo.getText()),
                txtNome.getText(),
                txtDescricao.getText(),
                Double.parseDouble(txtVenda.getText()),
                Double.parseDouble(txtCusto.getText()),
                Integer.parseInt(txtQuantest.getText())
        );
        boolean atualizou = produtoService.atualizarProduto(produto);
        if (atualizou) {
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            listarTodos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto.");
        }
    }

    public void deletarProduto() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        boolean deletou = produtoService.deletarProduto(codigo);
        if (deletou) {
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
            listarTodos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto.");
        }
    }

    public void listarTodos() {
        List<Produto> produtos = produtoService.listarTodos();
        tableModel.setRowCount(0);
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{
                    produto.getCodigo(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getVenda(),
                    produto.getCusto(),
                    produto.getQuantest()
            });
        }
    }
}
