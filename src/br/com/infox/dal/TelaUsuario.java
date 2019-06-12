/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dal;

/**
 *
 * @author Gravata
 */
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    //metodo para consulta usuario
    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUseId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUseNome.setText(rs.getString(2));
                txtUseFone.setText(rs.getString(3));
                txtuseLogin.setText(rs.getString(4));
                txtSenha.setText(rs.getString(5));
                // a linha a baixo se refere ao combo box
                cboUsoPerfil.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                // Linhas abaixo limpa o campo
                txtUseNome.setText(null);
                txtUseFone.setText(null);
                txtuseLogin.setText(null);
                txtSenha.setText(null);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo para adicionar 
    private void adicionar() {
        String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUseId.getText());
            pst.setString(2, txtUseNome.getText());
            pst.setString(3, txtUseFone.getText());
            pst.setString(4, txtuseLogin.getText());
            pst.setString(5, txtSenha.getText());
            pst.setString(6, cboUsoPerfil.getSelectedItem().toString());
            // validacao dos campo obrigatorios
            if ((txtUseId.getText().isEmpty()||(txtUseNome.getText().isEmpty()||(txtuseLogin.getText().isEmpty()||(txtSenha.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os campos obrigatorio");

            } else {

                //a linha abaixo atualiza a tbusuarios com os dados do formulario
                //a estrutura abaxo e usada para comfirma a insercao do dados na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio entendimento ao codigo
                System.out.println("adicionado");
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
                    txtUseId.setText(null);
                    txtUseNome.setText(null);
                    txtUseFone.setText(null);
                    txtuseLogin.setText(null);
                    txtSenha.setText(null);
                }
            }

        } catch (Exception e) {
            JoptionPane.showMessageDialog(null, e);
        }

    }
    
    //criando metodo alterar dados do usuario
    private void alterar(){
        String sql="update tbusuarios set usuario=?,fone=?,login=?,senha=?,perfil=? where iduser=?" ;
        try {
             pst=conexao.prepareStatement(sql);
             pst.setString(1, txtUseNome.getText());
             pst.setString(2,txtUseFone.getText() );
             pst.setString(3, txtuseLogin.getText());
             pst.setString(4, txtSenha.getText());
             pst.setString(5, cboUsoPerfil.getSelectedItem().toString());
             pst.setString(6, txtUseId.getText() );
           if ((txtUseId.getText().isEmpty()||(txtUseNome.getText().isEmpty()||(txtuseLogin.getText().isEmpty()||(txtSenha.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os campos obrigatorio");

            } else {

                //a linha abaixo atualiza a tbusuarios com os dados do formulario
                //a estrutura abaxo e usada para comfirma a alteracao do dados na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio entendimento ao codigo
                //System.out.println("");
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados modificados com sucesso");
                    txtUseId.setText(null);
                    txtUseNome.setText(null);
                    txtUseFone.setText(null);
                    txtuseLogin.setText(null);
                    txtSenha.setText(null);
                }
           }
           
        } catch (Exception e) {
             JoptionPane.showMessageDialog(null, e);
        }
    }
    
    // metodo responsavel pela remocao de usuario
    private void remover(){
        //a estrutura abaixo comfirma a remosao do usuario
        int comfirma=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuario:","Atencão",JOptionPane.YES_NO_OPTION);
        if(comfirma==JOptionPane.YES_OPTION){
            String sql= "delete from tbusuarios where iduser=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, txtUseId.getText());
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");
                    txtUseId.setText(null);
                    txtUseNome.setText(null);
                    txtUseFone.setText(null);
                    txtuseLogin.setText(null);
                    txtSenha.setText(null);
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUseId = new javax.swing.JTextField();
        txtuseLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUseNome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cboUsoPerfil = new javax.swing.JComboBox<>();
        btnUseDelete = new javax.swing.JButton();
        btnUseUpdate = new javax.swing.JButton();
        btnUseRead = new javax.swing.JButton();
        btnUseCreate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUseFone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuario");
        setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(792, 693));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("*Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("*Login");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("*Senha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("*Perfil");

        txtUseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUseIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("*Id");

        txtUseNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUseNomeActionPerformed(evt);
            }
        });

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        cboUsoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admim", "user" }));
        cboUsoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsoPerfilActionPerformed(evt);
            }
        });

        btnUseDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete (3).png"))); // NOI18N
        btnUseDelete.setToolTipText("Delete");
        btnUseDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseDeleteActionPerformed(evt);
            }
        });

        btnUseUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/Update.png"))); // NOI18N
        btnUseUpdate.setToolTipText("Update");
        btnUseUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseUpdateActionPerformed(evt);
            }
        });

        btnUseRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/Read (3).png"))); // NOI18N
        btnUseRead.setToolTipText("Pesquisar");
        btnUseRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseReadActionPerformed(evt);
            }
        });

        btnUseCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create (2).png"))); // NOI18N
        btnUseCreate.setToolTipText("Create");
        btnUseCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseCreateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Fone");

        jLabel9.setText("* Campos Obrigatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUseCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnUseRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btnUseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnUseDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(cboUsoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(255, 255, 255))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtuseLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUseId, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUseNome, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtUseFone, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(247, 247, 247))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUseNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtuseLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUseFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboUsoPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUseCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUseRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUseDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(659, 659, 659))
        );

        setBounds(0, 0, 810, 710);
    }// </editor-fold>//GEN-END:initComponents

    private void cboUsoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsoPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsoPerfilActionPerformed

    private void txtUseNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUseNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUseNomeActionPerformed

    private void btnUseDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseDeleteActionPerformed
        // TODO add your handling code here:
        //chamando o metodo remover
        remover();
    }//GEN-LAST:event_btnUseDeleteActionPerformed

    private void btnUseReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseReadActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnUseReadActionPerformed

    private void txtUseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUseIdActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnUseCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseCreateActionPerformed
        // TODO add your handling code here:
        // chamando o metodo adicionar
        adicionar();
    }//GEN-LAST:event_btnUseCreateActionPerformed

    private void btnUseUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseUpdateActionPerformed
 //chamando metodo alterar
        alterar();
    }//GEN-LAST:event_btnUseUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUseCreate;
    private javax.swing.JButton btnUseDelete;
    private javax.swing.JButton btnUseRead;
    private javax.swing.JButton btnUseUpdate;
    private javax.swing.JComboBox<String> cboUsoPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUseFone;
    private javax.swing.JTextField txtUseId;
    private javax.swing.JTextField txtUseNome;
    private javax.swing.JTextField txtuseLogin;
    // End of variables declaration//GEN-END:variables
}
