package Img.Grafo;

import javax.swing.ImageIcon;

public class mostrarCode extends javax.swing.JFrame {

    public int img = 0;

    public mostrarCode() {
        initComponents();
        setTitle("Viendo Codigo");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ImagenBienvenida.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 51));
        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //atras
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (img == 15) {
            img = 14;
            jButton2.setVisible(true);
            cambiarImg();
        } else {
            if (img == 14) {
                img = 13;
                cambiarImg();
            } else {
                if (img == 13) {
                    img = 12;
                    cambiarImg();
                } else {
                    if (img == 12) {
                        img = 11;
                        cambiarImg();
                    } else {
                        if (img == 11) {
                            img = 10;
                            cambiarImg();
                        } else {
                            if (img == 10) {
                                img = 9;
                                jButton1.setVisible(false);
                                cambiarImg();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //adelante
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (img == 9) {
            img = 10;
            cambiarImg();
            jButton1.setVisible(true);
        } else {
            if (img == 10) {
                img = 11;
                cambiarImg();
            } else {
                if (img == 11) {
                    img = 12;
                    cambiarImg();
                } else {
                    if (img == 12) {
                        img = 13;
                        cambiarImg();
                    } else {
                        if (img == 13) {
                            img = 14;
                            cambiarImg();
                        } else {
                            if (img == 14) {
                                img = 15;
                                jButton2.setVisible(false);
                                cambiarImg();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(mostrarCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mostrarCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mostrarCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mostrarCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mostrarCode().setVisible(true);
            }
        });
    }

    public void cambiarImg() {
        if (img == 1) {
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/insertarVertice.png")));
        } else {
            if (img == 2) {
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/modificarVertice.png")));
            } else {
                if (img == 3) {
                    jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/insertarArco.png")));
                } else {
                    if (img == 4) {
                        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/modificarArco.png")));
                    } else {
                        if (img == 5) {
                            jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/eliminarVertice.png")));
                        } else {
                            if (img == 6) {
                                jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/eliminarArco.png")));
                            } else {
                                if (img == 7) {
                                    jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/imprimirAmplitud.png")));
                                } else {
                                    if (img == 8) {
                                        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/imprimirProfundidad.png")));
                                    } else {
                                        if (img == 9) {
                                            jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra1.png")));
                                        } else {
                                            if (img == 10) {
                                                jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra2.png")));
                                            } else {
                                                if (img == 11) {
                                                    jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra3.png")));
                                                } else {
                                                    if (img == 12) {
                                                        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra4.png")));
                                                    } else {
                                                        if (img == 13) {
                                                            jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra5.png")));
                                                        } else {
                                                            if (img == 14) {
                                                                jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra6.png")));
                                                            } else {
                                                                if (img == 15) {
                                                                    jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/Grafo/dijkstra7.png")));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void hacerVisible() {
        jButton2.setVisible(true);
    }
}
