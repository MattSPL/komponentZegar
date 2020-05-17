
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusz
 */
public class ZegarTestowy extends javax.swing.JFrame {

    /**
     * Creates new form ZegarTestowy
     */
    JFrame frame = this;
    JFrame jFrame1 = new JFrame();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        
    public ZegarTestowy() {
        
        initComponents();
        clock1.create();
        clock1.runClock();
        jFrame1.add(clock1);
        jFrame1.setSize(510, 136);
        jFrame1.setVisible(true);
        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setTitle("Zegar Komponent");
        
       
        clock1.setClockSize(jFrame1.getContentPane().getWidth()-60, jFrame1.getContentPane().getHeight()-10);
         jFrame1.setLocation(screenSize.width/2-jFrame1.getWidth()/2, screenSize.height/4);
         frame.setLocation(screenSize.width/2 - frame.getWidth()/2, screenSize.height/2);
         
         for(Integer i=0;i<=23;i++)
         {
             jComboBox2.addItem(i.toString());
         }
         
         for(Integer i=0;i<=59;i++)
         {
             jComboBox3.addItem(i.toString());
             jComboBox4.addItem(i.toString());
         }
         
        jFrame1.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
       clock1.setClockSize(jFrame1.getContentPane().getWidth()-60, jFrame1.getContentPane().getHeight()-10);
      }
      
    });
        
        jButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setPrimaryColor(jColorChooser2.getColor());
                }
            
        });
        
        jButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setSecondaryColor(jColorChooser2.getColor());
                }
            
        });
        
        jButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setBackground(jColorChooser2.getColor());
                }
            
        });
        
        jButton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setClockFormat("HH:MM");
                clock1.setClockSize(jFrame1.getContentPane().getWidth()-60, jFrame1.getContentPane().getHeight()-10);
                }
            
        });
        
        jButton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setClockFormat("HH:MM:SS");
                clock1.setClockSize(jFrame1.getContentPane().getWidth()-60, jFrame1.getContentPane().getHeight()-10);
                }
            
        });
        
        jButton6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.setClockFormat("HH:MM:SS:mmm");
                clock1.setClockSize(jFrame1.getContentPane().getWidth()-60, jFrame1.getContentPane().getHeight()-10);
                }
            
        });
        
        jButton7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.stopwatchStart();
            }
            
        });
        
        jButton8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.stopwatchPause();
            }
            
        });
        
        jButton9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.stopwatchStop();
            }
            
        });
        
        jButton10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.runTimer(Integer.parseInt(jComboBox2.getSelectedItem().toString()), Integer.parseInt(jComboBox3.getSelectedItem().toString()), Integer.parseInt(jComboBox4.getSelectedItem().toString()));
            }
            
        });
        
        jButton11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.runClock();
            }
            
        });
        
        jButton12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               clock1.stopwatchOpen();
            }
            
        });
        
        
        
        jButton13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clock1.runClock();
            }
            
        });
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        clock1 = new clockPkg.Clock();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jColorChooser2 = new javax.swing.JColorChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton12 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton13 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();

        javax.swing.GroupLayout clock1Layout = new javax.swing.GroupLayout(clock1);
        clock1.setLayout(clock1Layout);
        clock1Layout.setHorizontalGroup(
            clock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        clock1Layout.setVerticalGroup(
            clock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikacja testowa Zegara");

        jColorChooser2.setPreviewPanel(new JPanel());
        jScrollPane1.setViewportView(jColorChooser2);

        jButton1.setText("Ustaw kolor zapalonego segmentu");

        jButton2.setText("Ustaw kolor zgaszonego segmentu");

        jButton3.setText("Ustaw kolor tła");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kolor", jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(3, 4, 5, 5));
        jPanel2.add(jSeparator1);

        jButton4.setText("Ustaw format 'HH:MM'");
        jPanel2.add(jButton4);
        jPanel2.add(jSeparator7);
        jPanel2.add(jSeparator9);

        jButton5.setText("Ustaw format 'HH:MM:SS'");
        jPanel2.add(jButton5);
        jPanel2.add(jSeparator11);
        jPanel2.add(jSeparator8);

        jButton6.setText("Ustaw format 'HH:MM:SS:mmm'");
        jPanel2.add(jButton6);
        jPanel2.add(jSeparator10);

        jTabbedPane1.addTab("Format", jPanel2);

        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWeights = new double[] {0.33, 0.33, 0.33};
        jPanel3.setLayout(jPanel3Layout);

        jLabel3.setText("Ustaw czas do odliczenia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel3.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jComboBox2, gridBagConstraints);

        jLabel4.setText("godzin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jComboBox3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jComboBox4, gridBagConstraints);

        jLabel5.setText("minut");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setText("sekund");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel6, gridBagConstraints);

        jButton10.setText("OK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jButton10, gridBagConstraints);

        jButton11.setText("Anuluj");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel3.add(jButton11, gridBagConstraints);

        jTabbedPane1.addTab("Minutnik", jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(3, 3, 5, 5));
        jPanel4.add(jSeparator2);

        jButton12.setText("Przygotuj stoper");
        jPanel4.add(jButton12);
        jPanel4.add(jSeparator3);

        jButton7.setText("Start");
        jPanel4.add(jButton7);

        jButton8.setText("Pauza");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);

        jButton9.setText("Stop");
        jPanel4.add(jButton9);
        jPanel4.add(jSeparator4);

        jButton13.setText("Powrót do zegara");
        jPanel4.add(jButton13);
        jPanel4.add(jSeparator6);

        jTabbedPane1.addTab("Stoper", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZegarTestowy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
       
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ZegarTestowy().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private clockPkg.Clock clock1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
