/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import ConectaBanco.ConectaBanco;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
//import static org.hsqldb.HsqlDateTime.dateValue;

/**
 *
 * @author Fernando
 */
public class FrmOs extends javax.swing.JFrame {

    ConectaBanco conectaCliente = new ConectaBanco();
    ConectaBanco conectaTabelaPrecos = new ConectaBanco();
    SimpleDateFormat dataBrasil = new SimpleDateFormat("dd/MM/yyy");
    Date data = new Date();

    /**
     * Creates new form FrmOsteste
     */
    public FrmOs() {
        initComponents();
        conectaCliente.conexao();
        conectaTabelaPrecos.conexao();
        //jDate.setEnabled(false);
        jButtonCancela.setEnabled(false);
        inicio();
    }

    public void inicio() {
        try {
            // TODO add your handling code here:
            //jComboServicos.removeAllItems();
            conectaCliente.executaSql("select clientes.id, clientes.nome, "
                    + "clientes.placa, tipos.id, tipos.nome, categorias.id, "
                    + "categorias.nome from clientes "
                    + "join tipos on clientes.tipo = tipos.id "
                    + "join categorias on clientes.categoria = categorias.id "
                    + "order by clientes.nome");
            conectaCliente.rs.first();
            do {
                jComboCliente.addItem(conectaCliente.rs.getString("nome"));
            } while (conectaCliente.rs.next());
            jButtonCancela.setVisible(false);
            //preencheConboTabelaPrecos();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void localizaRegistro() {
        try {
            // TODO add your handling code here:
            conectaCliente.executaSql("select clientes.id, clientes.nome, "
                    + "concat(substring(clientes.placa,1,3),'-',"
                    + "substring(clientes.placa,4,7)) as placa, tipos.id, "
                    + "(tipos.nome) as tipo, categorias.id, "
                    + "(categorias.nome) as categoria from clientes "
                    + "join tipos on clientes.tipo = tipos.id "
                    + "join categorias on clientes.categoria = categorias.id "
                    + "where clientes.nome = '"
                    + jComboCliente.getSelectedItem()
                    + "'order by clientes.nome");
            conectaCliente.rs.first();
            preencheTextBox();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencheTextBox() {
        try {
            jTextPlaca.setText(conectaCliente.rs.getString("placa"));
            jTextTipo.setText(conectaCliente.rs.getString("tipo"));
            jTextCategoria.setText(conectaCliente.rs.getString("categoria"));
        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void preencheConboTabelaPrecos() {

        try {
            jComboServicos.removeAllItems();
            conectaTabelaPrecos.executaSql("select * from precos order by nome");
            conectaTabelaPrecos.rs.first();
            jTextValor.setText(conectaTabelaPrecos.rs.getString("valor").toString());
            do {
                jComboServicos.addItem(conectaTabelaPrecos.rs.getString("nome"));
            } while (conectaTabelaPrecos.rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void localizaValorPreco(JComboBox combo) {
        try {
            conectaTabelaPrecos.executaSql("select * from precos where nome='" + combo.getSelectedItem() + "'");
            conectaTabelaPrecos.rs.first();
            jTextValor.setText(conectaTabelaPrecos.rs.getString("valor").toString());

        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextOS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextPlaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextCategoria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextValor = new javax.swing.JTextField();
        jButtonAdiciona = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonFim = new javax.swing.JButton();
        jComboCliente = new javax.swing.JComboBox();
        jComboServicos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButtonCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Serviço");
        setResizable(false);

        jLabel1.setText("Ordem de Serviço");

        jLabel2.setText("Data");

        jTextOS.setEditable(false);
        jTextOS.setBackground(java.awt.Color.yellow);

        jLabel3.setText("Cliente");

        jLabel4.setText("Placa");

        jTextPlaca.setEditable(false);
        jTextPlaca.setBackground(new java.awt.Color(255, 255, 153));

        jLabel5.setText("Tipo");

        jTextTipo.setEditable(false);
        jTextTipo.setBackground(new java.awt.Color(255, 255, 153));

        jLabel6.setText("Categoria");

        jTextCategoria.setEditable(false);
        jTextCategoria.setBackground(new java.awt.Color(255, 255, 153));

        jLabel8.setText("Valor");

        jTextValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextValor.setEnabled(false);

        jButtonAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add.png"))); // NOI18N
        jButtonAdiciona.setToolTipText("Adiciona novo cadastro");
        jButtonAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionaActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save_48x48.png"))); // NOI18N
        jButtonSalvar.setToolTipText("Salvar Registro");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refresh.png"))); // NOI18N
        jButtonAtualizar.setToolTipText("Atualizar");
        jButtonAtualizar.setEnabled(false);
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButton4.setToolTipText("Deletar");
        jButton4.setEnabled(false);

        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inicio.png"))); // NOI18N
        jButtonInicio.setToolTipText("Primeiro Registro");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back_1.png"))); // NOI18N
        jButtonVoltar.setToolTipText("Registro Anterior");
        jButtonVoltar.setEnabled(false);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/next.png"))); // NOI18N
        jButtonProximo.setToolTipText(" Próximo Registro");
        jButtonProximo.setEnabled(false);
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        jButtonFim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fim.png"))); // NOI18N
        jButtonFim.setToolTipText("Último Registro");
        jButtonFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFimActionPerformed(evt);
            }
        });

        jComboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboCliente.setEnabled(false);
        jComboCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboClientePopupMenuWillBecomeVisible(evt);
            }
        });

        jComboServicos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboServicos.setEnabled(false);
        jComboServicos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboServicosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboServicosPopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel7.setText("Serviço");

        jButtonCancela.setText("cancelar");
        jButtonCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextValor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancela))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboServicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCategoria))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextTipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextOS, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdiciona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAtualizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonFim, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(562, 562, 562))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonInicio)
                            .addComponent(jButtonVoltar)
                            .addComponent(jButtonProximo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancela)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(443, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        jComboCliente.setEnabled(false);
        jComboCliente.removeAllItems();
        jComboCliente.addItem("Selecione o Cliente");
        jComboServicos.removeAllItems();
        jComboServicos.setEnabled(false);
        jComboServicos.addItem("Selecione o Serviço");
        //jDate.setEnabled(false);
        //preencheConboTabelaPrecos();
        jTextValor.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jTextPlaca.setEditable(false);
        jTextTipo.setEditable(false);
        jTextCategoria.setEditable(false);
        jButtonInicio.setEnabled(true);
        jButtonVoltar.setEnabled(true);
        jButtonProximo.setEnabled(true);
        jButtonFim.setEnabled(true);
        jButtonAdiciona.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        jButtonCancela.setVisible(false);
        jButtonCancela.setEnabled(false);
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jComboServicosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboServicosPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        jComboServicos.removeAllItems();
        preencheConboTabelaPrecos();
    }//GEN-LAST:event_jComboServicosPopupMenuWillBecomeVisible

    private void jComboServicosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboServicosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        localizaValorPreco(jComboServicos);
    }//GEN-LAST:event_jComboServicosPopupMenuWillBecomeInvisible

    private void jComboClientePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboClientePopupMenuWillBecomeVisible

        jComboCliente.removeAllItems();
        inicio();
    }//GEN-LAST:event_jComboClientePopupMenuWillBecomeVisible

    private void jComboClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboClientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        localizaRegistro();
    }//GEN-LAST:event_jComboClientePopupMenuWillBecomeInvisible

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:

        try {
            conectaCliente.executaSql("select clientes.id, clientes.nome, "
                    + "concat(substring(clientes.placa,1,3),'-',"
                    + "substring(clientes.placa,4,7)) as placa, tipos.id, "
                    + "(tipos.nome) as tipo, categorias.id, "
                    + "(categorias.nome) as categoria from clientes "
                    + "join tipos on clientes.tipo = tipos.id "
                    + "join categorias on clientes.categoria = categorias.id ");
            conectaCliente.rs.first();
            jComboCliente.removeAllItems();
            jComboCliente.addItem(conectaCliente.rs.getString("clientes.nome"));
            preencheTextBox();
            preencheConboTabelaPrecos();
            jButtonProximo.setEnabled(true);
            jButtonVoltar.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, dataBrasil.format(jDate.getDate()));
        verificaCamposVazios();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionaActionPerformed
        // TODO add your handling code here:
        jComboCliente.setEnabled(true);
        jComboCliente.removeAllItems();
        jComboCliente.addItem("Selecione o Cliente");
        jComboServicos.removeAllItems();
        jComboServicos.setEnabled(true);
        jComboServicos.addItem("Selecione o Serviço");
        //jDate.setEnabled(true);
        //preencheConboTabelaPrecos();
        jTextValor.setEnabled(true);
        // jDate.requestFocusInWindow();
        jButtonSalvar.setEnabled(true);
        //jDate.setDate(data);
        //jTextPlaca.setEditable(true);
        //jTextTipo.setEditable(true);
        //jTextCategoria.setEditable(true);
        jButtonInicio.setEnabled(false);
        jButtonVoltar.setEnabled(false);
        jButtonProximo.setEnabled(false);
        jButtonFim.setEnabled(false);
        jButtonAdiciona.setEnabled(false);
        jButtonCancela.setVisible(true);
        jButtonCancela.setEnabled(true);
        jButtonAtualizar.setEnabled(true);
    }//GEN-LAST:event_jButtonAdicionaActionPerformed

    private void jButtonFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFimActionPerformed
        // TODO add your handling code here:
        try {
            conectaCliente.executaSql("select clientes.id, clientes.nome, "
                    + "concat(substring(clientes.placa,1,3),'-',"
                    + "substring(clientes.placa,4,7)) as placa, tipos.id, "
                    + "(tipos.nome) as tipo, categorias.id, "
                    + "(categorias.nome) as categoria from clientes "
                    + "join tipos on clientes.tipo = tipos.id "
                    + "join categorias on clientes.categoria = categorias.id ");
            conectaCliente.rs.last();
            jComboCliente.removeAllItems();
            jComboCliente.addItem(conectaCliente.rs.getString("clientes.nome"));
            preencheTextBox();
            preencheConboTabelaPrecos();
            jButtonVoltar.setEnabled(true);
            jButtonProximo.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonFimActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        try {
            // TODO add your handling code here:
            conectaCliente.rs.next();
            jComboCliente.removeAllItems();
            jComboCliente.addItem(conectaCliente.rs.getString("clientes.nome"));
            preencheTextBox();
            preencheConboTabelaPrecos();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            conectaCliente.rs.previous();
            jComboCliente.removeAllItems();
            jComboCliente.addItem(conectaCliente.rs.getString("clientes.nome"));
            preencheTextBox();
            preencheConboTabelaPrecos();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOs.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // TODO add your handling code here:
        jButtonAtualizar.updateUI();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    public void verificaCamposVazios() {
        if (jTextPlaca.getText().equals("")
                || jTextTipo.getText().equals("")
                || jTextCategoria.getText().equals("")
                || jTextValor.getText().equals("")
                || jComboCliente.getSelectedItem().equals("Selecione o Cliente")
                || jComboServicos.getSelectedItem().equals("Selecione o Serviço")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        }

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
            java.util.logging.Logger.getLogger(FrmOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAdiciona;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCancela;
    private javax.swing.JButton jButtonFim;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboCliente;
    private javax.swing.JComboBox jComboServicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextOS;
    private javax.swing.JTextField jTextPlaca;
    private javax.swing.JTextField jTextTipo;
    private javax.swing.JTextField jTextValor;
    // End of variables declaration//GEN-END:variables
}