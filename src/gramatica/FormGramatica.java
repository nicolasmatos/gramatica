package gramatica;

public class FormGramatica extends javax.swing.JFrame {

    public FormGramatica() {
        initComponents();
    }

    public static void main(String[] args) {
        FormGramatica f = new FormGramatica();
        f.setVisible(true);
        f.setTitle("Verificar autômato");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        panel1 = new java.awt.Panel();
        lblAlfabeto = new javax.swing.JLabel();
        lblQtdEstados = new javax.swing.JLabel();
        lblTransicoes = new javax.swing.JLabel();
        jtxtAlfabeto = new javax.swing.JTextField();
        jtxtQtdEstados = new javax.swing.JTextField();
        jtxtEstadosFinais = new javax.swing.JTextField();
        lblEstadoInicial = new javax.swing.JLabel();
        lblEstadosFinais = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
        jtxtEstadoIni = new javax.swing.JTextField();
        jtxtTransicoes = new javax.swing.JTextField();
        jtxtEntrada = new javax.swing.JTextField();
        jbtExecutar = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxaResultado = new javax.swing.JTextArea();
        //jPanelDesenho = new Desenho();

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 284, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 129, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        label1.setText("label1");

        jFormattedTextField1.setText("jFormattedTextField1");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 331, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 276, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        lblAlfabeto.setText("Alfabeto");

        lblQtdEstados.setText("Quantidade de estados");

        lblTransicoes.setText("Transições");

        jtxtAlfabeto.setText("0,1,2,3,4,5,6,7,8,9");

        jtxtQtdEstados.setText("3");

        jtxtEstadosFinais.setText("1");

        lblEstadoInicial.setText("Estado Inicial");

        lblEstadosFinais.setText("Estados Finais");

        lblEntrada.setText("Entrada");

        jtxtEstadoIni.setText("1");

        jtxtTransicoes.setText("1/0/1,1/0/2,1/0/3/,3/0/3");

        jtxtEntrada.setText("1/3/7/3");

        jbtExecutar.setBackground(new java.awt.Color(245, 245, 245));
        jbtExecutar.setLabel("Verificar");
        jbtExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExecutarActionPerformed(evt);
            }
        });

        jtxaResultado.setColumns(20);
        jtxaResultado.setRows(5);
        jScrollPane1.setViewportView(jtxaResultado);

        jPanelDesenho.setPreferredSize(new java.awt.Dimension(578, 428));

        javax.swing.GroupLayout jPanelDesenhoLayout = new javax.swing.GroupLayout(jPanelDesenho);
        jPanelDesenho.setLayout(jPanelDesenhoLayout);
        jPanelDesenhoLayout.setHorizontalGroup(
                jPanelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelDesenhoLayout.setVerticalGroup(
                jPanelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 453, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblEntrada)
                                                                        .addComponent(lblTransicoes)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblEstadoInicial)
                                                                                        .addComponent(jtxtEstadoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblEstadosFinais)
                                                                                        .addComponent(jtxtEstadosFinais, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(jtxtTransicoes)
                                                                        .addComponent(jtxtEntrada)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblAlfabeto)
                                                                                        .addComponent(jtxtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblQtdEstados)
                                                                                        .addComponent(jtxtQtdEstados)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jbtExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblAlfabeto)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtxtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblQtdEstados)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtxtQtdEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblEstadosFinais)
                                                        .addComponent(lblEstadoInicial))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jtxtEstadosFinais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtxtEstadoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTransicoes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxtTransicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblEntrada)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanelDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jbtExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExecutarActionPerformed
        Automato a  = new Automato(jtxtAlfabeto.getText(), Integer.parseInt(jtxtQtdEstados.getText()), jtxtTransicoes.getText(), jtxtEstadoIni.getText(), jtxtEstadosFinais.getText(), jtxtEntrada.getText());
        jtxaResultado.setText(a.verificacao());
        ((Desenho)jPanelDesenho).setEstados(a.getEstados());
        ((Desenho)jPanelDesenho).setQtdEstados(a.getQtdEstados());

        jPanelDesenho.repaint();
    }//GEN-LAST:event_jbtExecutarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDesenho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Button jbtExecutar;
    private javax.swing.JTextArea jtxaResultado;
    private javax.swing.JTextField jtxtAlfabeto;
    private javax.swing.JTextField jtxtEntrada;
    private javax.swing.JTextField jtxtEstadoIni;
    private javax.swing.JTextField jtxtEstadosFinais;
    private javax.swing.JTextField jtxtQtdEstados;
    private javax.swing.JTextField jtxtTransicoes;
    private java.awt.Label label1;
    private javax.swing.JLabel lblAlfabeto;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblEstadoInicial;
    private javax.swing.JLabel lblEstadosFinais;
    private javax.swing.JLabel lblQtdEstados;
    private javax.swing.JLabel lblTransicoes;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
