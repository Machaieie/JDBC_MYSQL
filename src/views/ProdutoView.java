package views;

import controller.ProdutoController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoView extends JFrame {

    private JTextField txtCodigo, txtNome, txtDescricao, txtVenda, txtCusto, txtQuantest;
    private JTable table;
    private ProdutoController produtoController;

    public ProdutoView() {
        setTitle("CRUD de Produto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de Formulário
        JPanel panelForm = new JPanel(new GridLayout(6, 2));
        panelForm.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelForm.add(txtCodigo);
        panelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelForm.add(txtNome);
        panelForm.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        panelForm.add(txtDescricao);
        panelForm.add(new JLabel("Preço de Venda:"));
        txtVenda = new JTextField();
        panelForm.add(txtVenda);
        panelForm.add(new JLabel("Preço de Custo:"));
        txtCusto = new JTextField();
        panelForm.add(txtCusto);
        panelForm.add(new JLabel("Quantidade em Estoque:"));
        txtQuantest = new JTextField();
        panelForm.add(txtQuantest);

        // Painel de Botões
        JPanel panelButtons = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnDeletar = new JButton("Deletar");
        panelButtons.add(btnAdicionar);
        panelButtons.add(btnBuscar);
        panelButtons.add(btnAtualizar);
        panelButtons.add(btnDeletar);

        // Tabela de Produtos
        table = new JTable(new DefaultTableModel(new Object[]{"Código", "Nome", "Descrição", "Venda", "Custo", "Quantest"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);

        // Adicionar componentes ao Frame
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Controlador
        produtoController = new ProdutoController(txtCodigo, txtNome, txtDescricao, txtVenda, txtCusto, txtQuantest, table);
        produtoController.listarTodos();

        // Ações dos Botões
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoController.adicionarProduto();
                limparCampos();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoController.buscarProduto();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoController.atualizarProduto();
                limparCampos();
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoController.deletarProduto();
                limparCampos();
            }
        });
    }

    // Método para limpar os campos de texto
    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtVenda.setText("");
        txtCusto.setText("");
        txtQuantest.setText("");
    }

    
}
