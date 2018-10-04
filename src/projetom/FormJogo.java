/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RodolfoAugustodeOliv
 */
public class FormJogo extends javax.swing.JFrame implements Runnable {

    Graphics graph;
    Random rnd = new Random();
    int j, i = 0;
    int qtd_cartas = 6;
    int jogadas = 0;
    int qtd_jogadas = 2;
    int x = 20;
    int y = 50;
    Point cursor = new Point();

    Carta carta;

    controlesCartas controle = new controlesCartas();

    // ArrayList<controlesCartas> listaControles = new ArrayList();
    // ArrayList <Base> lista = new ArrayList();
    /**
     * Creates new form FormJogo
     */
    public FormJogo() {
        initComponents();
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        cursor = evt.getPoint();

        if (controle.clique(cursor)) {
            jogadas++;
            controle.alteraEstado(Estados.SELECIONADO);

            if (jogadas == qtd_jogadas) {
                if (controle.getSelecionados().size() > 1) {
                    if (controle.comparaCarta(controle.getSelecionados())) {
                        controle.getSelecionados().removeAll(controle.getSelecionados());
                    }
                    else{
                        controle.alteraEstado(Estados.INICIAL);
                        controle.getSelecionados().removeAll(controle.getSelecionados());
                    }
                    jogadas = 0;
                }
                
            }
        }
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(FormJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJogo().setVisible(true);
            }
        });
    }

    @Override
    public void run() {

        for (int i = 0; i < (qtd_cartas * 2); i++) {
            if (i % 2 == 0) {
                j++;
            }

            carta = new Carta("IMG/" + j + ".png");
            carta.setAltura(100);
            carta.setLargura(100);
            carta.setX(x);
            carta.setY(y);
            if (x > 20 && x % 7 == 0) {
                x = 20;
                y += 110;
            } else {
                x += 110;
            }
            controle.criaCartas(carta);              
        }

        while (true) {
            graph = getBufferStrategy().getDrawGraphics();
            graph.setColor(Color.white);
            graph.fillRect(0, 0, getWidth(), getHeight());

            for (Base base : controle.getRegrasCartas()) {
                base.desenhar(graph);
            }

            graph.dispose();
            getBufferStrategy().show();
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
