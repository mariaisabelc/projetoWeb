package telascorreto;

import java.util.ArrayList;
import java.util.List;
import projetointegrador.Cliente;
import projetointegrador.Produto;
import projetointegrador.Venda;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class TelaVendas extends javax.swing.JFrame {

    private Cliente clienteSelecionado;
    private List<Produto> listaProdutos = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private Venda venda;

    public TelaVendas() {
        initComponents();
        listaProdutos = carregarListaDeProdutos();
        listaClientes = carregarListaDeClientes();
        carregarClientesNoComboBox();
        carregarProdutosNoComboBox();
        DefaultListModel<String> produtosListModel = new DefaultListModel<>();
        listaProdutosVenda.setModel(produtosListModel);
   
    }


private void carregarClientesNoComboBox() {
    clientevenda.removeAllItems();
    for (Cliente cliente : listaClientes) {
        clientevenda.addItem(cliente.getNome()); 
    }

    
    }
    private List<Cliente> carregarListaDeClientes() {
    List<Cliente> listaClientes = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "1111");
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente");
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            String nome = resultSet.getString("nomeCliente");
            String cpf = resultSet.getString("CPF");
            String endereco = resultSet.getString("endereco");
            String telefone = resultSet.getString("telefone");

            Cliente cliente = new Cliente(nome, cpf, endereco, telefone);
            listaClientes.add(cliente);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaClientes;
}
    private void carregarProdutosNoComboBox() {
    produtovenda.removeAllItems();
    for (Produto produto : listaProdutos) {
        produtovenda.addItem(produto.getNomeProduto());
    }
}
    private List<Produto> carregarListaDeProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "1111");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nomeProduto");
                double preco = resultSet.getDouble("valor");
                  String descricao = resultSet.getString("descricao");
                int quantidade = resultSet.getInt("quantidade");

                Produto produto = new Produto(nome, descricao, preco, quantidade);
                listaProdutos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return listaProdutos;
    }
    

    private Cliente obterClientePorNome(String nomeClienteSelecionado) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().equals(nomeClienteSelecionado)) {
                return cliente;
            }
        }
        return null;
    }

    private Produto obterProdutoPorNome(String nomeProdutoSelecionado) {
        for (Produto produto : listaProdutos) {
            if (produto.getNomeProduto().equals(nomeProdutoSelecionado)) {
                return produto;
            }
        }
        return null;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clientevenda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        produtovenda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutosVenda = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        porcentagemDesconto = new javax.swing.JTextField();
        valorTotalVenda = new javax.swing.JTextField();
        botaoAddProduto = new javax.swing.JButton();
        botaoConfirmar = new javax.swing.JButton();
        quantidade = new javax.swing.JTextField();
        valorinicial = new javax.swing.JTextField();
        botaoCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Vendas");

        clientevenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientevenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientevendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente:");

        jLabel3.setText("Produto:");

        jLabel4.setText("Quantidade:");

        produtovenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        produtovenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtovendaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaProdutosVenda);

        jLabel5.setText("Desconto:");

        jLabel6.setText("Valor Total:");

        porcentagemDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcentagemDescontoActionPerformed(evt);
            }
        });

        valorTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalVendaActionPerformed(evt);
            }
        });

        botaoAddProduto.setText("Adicionar Produto");
        botaoAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddProdutoActionPerformed(evt);
            }
        });

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeActionPerformed(evt);
            }
        });

        valorinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorinicialActionPerformed(evt);
            }
        });

        botaoCalcular.setText("Calcular");
        botaoCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientevenda, 0, 373, Short.MAX_VALUE)
                    .addComponent(produtovenda, 0, 373, Short.MAX_VALUE)
                    .addComponent(quantidade))
                .addGap(158, 158, 158))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentagemDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(botaoCalcular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoConfirmar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(botaoAddProduto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientevenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(produtovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(botaoAddProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(valorinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(valorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoConfirmar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(porcentagemDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(botaoCalcular))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valorTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalVendaActionPerformed

    private void botaoAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddProdutoActionPerformed
        String nomeProdutoSelecionado = (String) produtovenda.getSelectedItem();
        String quantidadeSelecionada = quantidade.getText();

        if (nomeProdutoSelecionado != null && !nomeProdutoSelecionado.isEmpty()
                && quantidadeSelecionada != null && !quantidadeSelecionada.isEmpty()) {

            Produto produtoSelecionado = obterProdutoPorNome(nomeProdutoSelecionado);
            int quantidade = Integer.parseInt(quantidadeSelecionada);

            if (quantidade <= produtoSelecionado.getQtEstoque()) {
                if (venda == null) {
                    venda = new Venda(clienteSelecionado);
                }

                String itemLista = produtoSelecionado.getNomeProduto() + " - Quantidade: " + quantidade;
                ((DefaultListModel<String>) listaProdutosVenda.getModel()).addElement(itemLista);

                double valorProduto = produtoSelecionado.getPreco() * quantidade;
                venda.adicionarProduto(produtoSelecionado, quantidade, valorProduto);

                valorinicial.setText(String.valueOf(venda.calcularValorTotal()));

            } else {
                System.out.println("Quantidade inválida para o produto: " + produtoSelecionado.getNomeProduto());
            }
        }
    

    }//GEN-LAST:event_botaoAddProdutoActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
   String descontoStr = porcentagemDesconto.getText();

    try {
        double desconto = Double.parseDouble(descontoStr);

        if (venda != null) {
            double valorTotalComDesconto = venda.calcularValorTotal() * (1 - desconto / 100);

            salvarVenda(valorTotalComDesconto);

          
            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

       
            dispose();

          
        } else {
            System.out.println("Erro");
        }
    } catch (NumberFormatException e) {
        System.out.println("Erro: Valor de desconto inválido.");
    }


    }//GEN-LAST:event_botaoConfirmarActionPerformed
private void salvarVenda(double valorTotalComDesconto) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "1111");
         Statement statement = connection.createStatement()) {

        connection.setAutoCommit(false);

        try {
            Date dataAtual = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataFormatada = dateFormat.format(dataAtual);

            String query = "INSERT INTO venda (dataVenda, valor) VALUES ('" + dataFormatada + "', " + valorTotalComDesconto + ")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int vendaId = -1;
            if (generatedKeys.next()) {
                vendaId = generatedKeys.getInt(1);
            }

            DefaultListModel<String> produtosListModel = (DefaultListModel<String>) listaProdutosVenda.getModel();
            for (int i = 0; i < produtosListModel.getSize(); i++) {
                String itemLista = produtosListModel.getElementAt(i);
                String[] partes = itemLista.split(" - Quantidade: ");
                String nomeProduto = partes[0];
                int quantidadeVendida = Integer.parseInt(partes[1]);

                query = "UPDATE produto SET quantidade = quantidade - " + quantidadeVendida + " WHERE nomeProduto = '" + nomeProduto + "'";
                statement.executeUpdate(query);
            }

            connection.commit(); 

            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

            dispose();
        } catch (SQLException ex) {
            connection.rollback(); 
            ex.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void clientevendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientevendaActionPerformed
  String nomeClienteSelecionado = (String) clientevenda.getSelectedItem();
        this.clienteSelecionado = obterClientePorNome(nomeClienteSelecionado);
    
    }//GEN-LAST:event_clientevendaActionPerformed

    private void produtovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtovendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtovendaActionPerformed

    private void porcentagemDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentagemDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentagemDescontoActionPerformed

    private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeActionPerformed

    private void valorinicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorinicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorinicialActionPerformed

    private void botaoCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalcularActionPerformed
     try {
        double valorInicial = Double.parseDouble(valorinicial.getText());
        double desconto = Double.parseDouble(porcentagemDesconto.getText());

        double valorComDesconto = valorInicial * (1 - desconto / 100);
        valorTotalVenda.setText(String.format("%.2f", valorComDesconto));

    } catch (NumberFormatException e) {
        System.out.println("Erro: Valor inicial ou desconto inválido.");
    }

    }//GEN-LAST:event_botaoCalcularActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAddProduto;
    private javax.swing.JButton botaoCalcular;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JComboBox<String> clientevenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaProdutosVenda;
    private javax.swing.JTextField porcentagemDesconto;
    private javax.swing.JComboBox<String> produtovenda;
    private javax.swing.JTextField quantidade;
    private javax.swing.JTextField valorTotalVenda;
    private javax.swing.JTextField valorinicial;
    // End of variables declaration//GEN-END:variables

 

}