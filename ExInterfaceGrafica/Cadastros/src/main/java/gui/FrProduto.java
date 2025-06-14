package gui;

import classes.Produto;
import gerenciador.GerenciadorProduto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangel
 */
public class FrProduto extends javax.swing.JFrame {

    public boolean editando;
    public String codAntigo;
    public GerenciadorProduto gerenciadorProduto;
    
    public FrProduto() {
        this.editando = false;
        this.codAntigo = "";
        this.gerenciadorProduto = new GerenciadorProduto();

        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();
        
        gerenciadorProduto.carregarDoArquivo("ListagemProdutos.json");
      //gerenciadorProduto.carregarDeXML("ListagemPessoas.xml"); // Isso carrega para arquivo xml
        edtListagem.setText(gerenciadorProduto.toString());
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Salvando dados ao fechar a janela...");
                
              //gerenciadorProduto.salvarEmXML("ListagemProdutos.xml"); // Isso salva em arquivo xml
                gerenciadorProduto.salvarNoArquivo("ListagemProdutos.json"); //Isso salva em arquivo .json
                
                System.exit(0);
            }
        });
    }
    public void habilitarCampos(boolean flag) {
        edtCodigo.setEnabled(flag);
        edtNome.setEnabled(flag);
        edtCusto.setEnabled(flag);
        edtPreco.setEnabled(flag);
    }

    public void limparCampos() {
        edtCodigo.setText("");
        edtNome.setText("");
        edtCusto.setText("");
        edtPreco.setText("");
    }

    public void objetoParaCampos(Produto p) {
        edtCodigo.setText(p.getCod());
        edtNome.setText(p.getNome());
        edtCusto.setText(p.getCusto()+"");
        edtPreco.setText(p.getPreco() + "");
    }

    public Produto camposParaObjeto() {
        Produto p = new Produto();
        p.setCod(edtCodigo.getText());
        p.setNome(edtNome.getText());

        String custo = edtCusto.getText();
        double a = 0;
        if (!custo.isEmpty()) {
            a = Double.parseDouble(custo);
        }
        p.setCusto(a);
        
        String precoStr = edtPreco.getText();
        a = 0;
        if (!precoStr.isEmpty()) {
            a = Double.parseDouble(precoStr);
        }
        p.setPreco(a);

        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        panCampos = new javax.swing.JPanel();
        edtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        edtCusto = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        edtPreco = new javax.swing.JTextField();
        lblSexo1 = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Produto");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo-arquivo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        panBotoes.add(btnNovo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar-texto.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panBotoes.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panBotoes.add(btnCancelar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        panBotoes.add(btnExcluir);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar-arquivo.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panBotoes.add(btnSalvar);

        panCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNome.setText("Nome:");

        lblSexo.setText("Custo:");

        edtCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCustoActionPerformed(evt);
            }
        });

        lblNome1.setText("Preço:");

        lblSexo1.setText("Cod:");

        edtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCamposLayout = new javax.swing.GroupLayout(panCampos);
        panCampos.setLayout(panCamposLayout);
        panCamposLayout.setHorizontalGroup(
            panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCamposLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCamposLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCamposLayout.createSequentialGroup()
                        .addComponent(lblSexo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCamposLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCamposLayout.createSequentialGroup()
                        .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCamposLayout.setVerticalGroup(
            panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCamposLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSexo1)
                        .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(edtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1)
                    .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(panCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
        this.editando = false;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String codEscolhido = JOptionPane.showInputDialog("Informe o CODIGO do produto que deseja EDITAR:", "");

        Produto produtoEditando = gerenciadorProduto.buscarProduto(codEscolhido);

        if (produtoEditando == null) {
            JOptionPane.showMessageDialog(this, "Não existe este produto.");
            this.editando = false;
        } else {
            this.limparCampos();
            this.habilitarCampos(true);

            this.objetoParaCampos(produtoEditando);
            this.editando = true;
            this.codAntigo = produtoEditando.getCod();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String codEscolhido = JOptionPane.showInputDialog("Informe o CODIGO do produto que deseja excluir:", "");

        Produto p = gerenciadorProduto.buscarProduto(codEscolhido);

        if (p == null) {
            JOptionPane.showMessageDialog(this, "Não existe este produto.");
        } else {
            gerenciadorProduto.removerProduto(codEscolhido);
            JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
        }

        String listagem = gerenciadorProduto.toString();
        edtListagem.setText(listagem);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto p = this.camposParaObjeto();

        //Este metodo ja verifica se esta criando um novo ou atualizando
        if(this.editando){
            gerenciadorProduto.atualizarProduto(codAntigo, p);
        }else{
            gerenciadorProduto.adicionarProduto(p);
        }

        //No final reset a tela
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;

        String listagem = gerenciadorProduto.toString();
        edtListagem.setText(listagem);

        gerenciadorProduto.salvarNoArquivo("ListagemProdutos.json"); // Isso salva em arquivo .json
      //gerenciadorProduto.salvarEmXML("ListagemProdutos.xml"); // Isso salva em arquivo xml
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void edtCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCustoActionPerformed

    private void edtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCodigoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtCusto;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panCampos;
    // End of variables declaration//GEN-END:variables
}
