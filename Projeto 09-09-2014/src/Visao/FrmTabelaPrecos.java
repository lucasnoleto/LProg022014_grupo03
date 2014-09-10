/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import ConectaBanco.ConectaBanco;
import Controle.ControleTabelaPrecos;
import Modelo.ModeloTabela;
import Modelo.ModeloTabelaPrecos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fernando
 */
public class FrmTabelaPrecos extends javax.swing.JFrame {
     ConectaBanco conecta = new ConectaBanco();
     ConectaBanco conectaTipos = new ConectaBanco();
     Modelo.ModeloTabelaPrecos mod = new ModeloTabelaPrecos();
     ControleTabelaPrecos controle = new ControleTabelaPrecos();
     /**
     * Creates new form FrmCategoriasVeiculos
     */
    public FrmTabelaPrecos() {
        initComponents();
        conecta.conexao();
        jButtonSalvar.setEnabled(false);
        preencherTabelaPrecos("select * from PRECOS order by nome");
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jTextNome = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonUltimo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePrecos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Categorias dos Veiculos.");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Serviço:");

        jTextId.setEditable(false);
        jTextId.setBackground(new java.awt.Color(255, 255, 0));

        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add.png"))); // NOI18N
        jButtonAdicionar.setToolTipText("Adiciona novo registro");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save_48x48.png"))); // NOI18N
        jButtonSalvar.setToolTipText("Salva");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refresh.png"))); // NOI18N
        jButtonAtualizar.setToolTipText("Atualiza");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButtonDeletar.setToolTipText("Exclui");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inicio.png"))); // NOI18N
        jButtonInicio.setMaximumSize(new java.awt.Dimension(81, 57));
        jButtonInicio.setMinimumSize(new java.awt.Dimension(81, 57));
        jButtonInicio.setPreferredSize(new java.awt.Dimension(81, 57));
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back.png"))); // NOI18N
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/next.png"))); // NOI18N
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        jButtonUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fim.png"))); // NOI18N
        jButtonUltimo.setPreferredSize(new java.awt.Dimension(81, 57));
        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoActionPerformed(evt);
            }
        });

        jTablePrecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePrecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePrecosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePrecos);

        jLabel3.setText("Valor:");

        jTextValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextValor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar)
                        .addGap(2, 2, 2)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButtonAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonDeletar)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonProximo)
                    .addComponent(jButtonUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(737, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        jTextId.setText(null);
        jTextNome.setText(null);
        jTextValor.setText(null);
        jButtonAtualizar.setEnabled(false);
        jButtonDeletar.setEnabled(false);
        jButtonSalvar.setEnabled(true);
        preencherTabelaPrecos("select * from precos order by nome");
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        if(jTextNome.getText().equals("") || jTextValor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todos os campos são Obrigatorios");
            return ;
        }
        mod.setNome(jTextNome.getText());
        mod.setValor(Float.parseFloat(jTextValor.getText()));
        controle.InserirTabelaPrecos(mod);
        jButtonSalvar.setEnabled(false);
        jButtonAtualizar.setEnabled(true);
        jButtonDeletar.setEnabled(true);
        preencherTabelaPrecos("select * from precos order by nome");
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // TODO add your handling code here:
        if(jTextNome.getText().equals("") || jTextValor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todos os campos são Obrigatorios");
            return ;
        }
        mod.setId(Integer.parseInt(jTextId.getText()));
        mod.setNome(jTextNome.getText());
        mod.setValor(Float.parseFloat(jTextValor.getText()));
        controle.AlterarTabelaPrecos(mod);
        preencherTabelaPrecos("select * from precos order by nome");
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        // TODO add your handling code here:
        mod.setId(Integer.parseInt(jTextId.getText()));
        mod.setNome(jTextNome.getText());
        mod.setValor(Float.parseFloat(jTextValor.getText()));
        controle.ExcluirTabelaPrecos(mod);
        try {
            conecta.rs.first();
            jTextId.setText(String.valueOf(conecta.rs.getInt("id")));
            jTextNome.setText(conecta.rs.getString("nome"));
            jTextValor.setText(String.valueOf(conecta.rs.getFloat("valor")));
        } catch (SQLException ex) {
            //Logger.getLogger(FrmCategoriasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabelaPrecos("select * from precos order by nome");
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:

        try {
            conecta.executaSql("select * from precos order by nome");
            conecta.rs.first();
            jTextId.setText(String.valueOf(conecta.rs.getInt("id")));
            jTextNome.setText(conecta.rs.getString("nome"));
            jTextValor.setText(String.valueOf(conecta.rs.getFloat("valor")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao setar o primeiro registro! \nErro:"+ex);
        }

    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        // TODO add your handling code here:
        try {
            //conecta.executaSql("select * from tipos order by id");
            conecta.rs.previous();
            jTextId.setText(String.valueOf(conecta.rs.getInt("id")));
            jTextNome.setText(conecta.rs.getString("nome"));
            jTextValor.setText(String.valueOf(conecta.rs.getFloat("valor")));
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao setar o registro! \nErro:"+ex);
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        // TODO add your handling code here:
        try {
            //conecta.executaSql("select * from tipos order by id");
            conecta.rs.next();
            jTextId.setText(String.valueOf(conecta.rs.getInt("id")));
            jTextNome.setText(conecta.rs.getString("nome"));
            jTextValor.setText(String.valueOf(conecta.rs.getFloat("valor")));
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao setar o primeiro registro! \nErro:"+ex);
        }
    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.executaSql("select * from precos order by nome");
            conecta.rs.last();
            jTextId.setText(String.valueOf(conecta.rs.getInt("id")));
            jTextNome.setText(conecta.rs.getString("nome"));
            jTextValor.setText(String.valueOf(conecta.rs.getFloat("valor")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao setar o ultimo registro! \nErro:"+ex);
        }
    }//GEN-LAST:event_jButtonUltimoActionPerformed

    private void jTablePrecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePrecosMouseClicked
        // TODO add your handling code here:
        int linha = jTablePrecos.getSelectedRow();
        jTextId.setText(jTablePrecos.getValueAt(linha, 0).toString());
        jTextNome.setText(jTablePrecos.getValueAt(linha, 1).toString());
        jTextValor.setText(jTablePrecos.getValueAt(linha, 2).toString());
    }//GEN-LAST:event_jTablePrecosMouseClicked
public void preencherTabelaPrecos(String SQL){
        conecta.conexao();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","NOME","VALOR"};
        
        conecta.executaSql(SQL);
        try {
            conecta.rs.first();
            do{
                dados.add(new Object[]{conecta.rs.getInt("id"),conecta.rs.getString("nome"),conecta.rs.getFloat("valor")});
            }while(conecta.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(FrmTabelaPrecos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();  
        r.setHorizontalAlignment(SwingConstants.RIGHT);  
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePrecos.setModel(modelo);
        jTablePrecos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablePrecos.getColumnModel().getColumn(0).setResizable(false);
        jTablePrecos.getColumnModel().getColumn(1).setPreferredWidth(495);
        jTablePrecos.getColumnModel().getColumn(1).setResizable(false);
        jTablePrecos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTablePrecos.getColumnModel().getColumn(2).setResizable(false);
        jTablePrecos.getColumnModel().getColumn(2).setCellRenderer(r);
        jTablePrecos.getTableHeader().setReorderingAllowed(false);
        jTablePrecos.setAutoResizeMode(jTablePrecos.AUTO_RESIZE_OFF);
        jTablePrecos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }   

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(FrmTabelaPrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaPrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaPrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaPrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTabelaPrecos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePrecos;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextValor;
    // End of variables declaration//GEN-END:variables
}
