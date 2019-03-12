/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Cursor;
import java.awt.Desktop;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author dougthompson
 */
public class About extends javax.swing.JDialog {

    /**
     * Creates new form About
     */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("About TJCS  Lottery Tool");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelAppName = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();
        jLabelLastUpdated = new javax.swing.JLabel();
        jLabelTJCS_Contact = new javax.swing.JLabel();
        jLabelDeveloper = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelWebSite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TJCS_logo.png"))); // NOI18N

        jLabel2.setText("Name:");

        jLabel3.setText("Version:");

        jLabel4.setText("Last Updated:");

        jLabel5.setText("Main Contact:");

        jLabel6.setText("Primary Developer:");

        jLabelAppName.setText("Name");

        jLabelVersion.setForeground(new java.awt.Color(0, 0, 255));
        jLabelVersion.setText("Version");
        jLabelVersion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVersionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVersionMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVersionMouseEntered(evt);
            }
        });

        jLabelLastUpdated.setText("Date");

        jLabelTJCS_Contact.setText("TJCS Contact");

        jLabelDeveloper.setText("Developer");

        jLabel7.setText("Website:");

        jLabelWebSite.setForeground(new java.awt.Color(0, 0, 255));
        jLabelWebSite.setText("URL");
        jLabelWebSite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelWebSiteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelWebSiteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelWebSiteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAppName)
                            .addComponent(jLabelVersion)
                            .addComponent(jLabelLastUpdated)
                            .addComponent(jLabelTJCS_Contact)
                            .addComponent(jLabelDeveloper)
                            .addComponent(jLabelWebSite))
                        .addGap(0, 171, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelAppName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelLastUpdated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelTJCS_Contact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelDeveloper))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelWebSite))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelWebSiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelWebSiteMouseClicked
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(appWebsite);
            desktop.browse(oURL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open the website",
                    "Cannot Open Site", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jLabelWebSiteMouseClicked

    private void jLabelWebSiteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelWebSiteMouseEntered
        jLabelWebSite.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabelWebSiteMouseEntered

    private void jLabelWebSiteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelWebSiteMouseExited
        jLabelWebSite.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabelWebSiteMouseExited

    private void jLabelVersionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVersionMouseClicked
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        if (path.getNameCount() > 3) {
            //The tool, by default, is launched from the java bin directory, which is 3 dirs deep from the root.
            path = path.getParent().getParent().getParent().resolve("ChangeHistory.html").toAbsolutePath();
        }
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();           
            if (Utilities.isDevelopment()) {
                path = FileSystems.getDefault().getPath("src", "main", "java", "ChangeHistory.html").toAbsolutePath();
            }
            desktop.browse(path.toUri());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open the change history: " + e.getMessage(),
                    "Cannot Open Change History", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jLabelVersionMouseClicked

    private void jLabelVersionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVersionMouseEntered
        jLabelVersion.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabelVersionMouseEntered

    private void jLabelVersionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVersionMouseExited
        jLabelVersion.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabelVersionMouseExited

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                About dialog = new About(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAppName;
    private javax.swing.JLabel jLabelDeveloper;
    private javax.swing.JLabel jLabelLastUpdated;
    private javax.swing.JLabel jLabelTJCS_Contact;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JLabel jLabelWebSite;
    // End of variables declaration//GEN-END:variables

    private String appWebsite = "";
    
    public void setAppName(String appName) {
        this.jLabelAppName.setText(appName);
    }

    public void setDeveloper(String developer) {
        this.jLabelDeveloper.setText(developer);
    }

    public void setLastUpdated(String lastUpdated) {
        this.jLabelLastUpdated.setText(lastUpdated);
    }

    public void setTJCS_Contact(String TJCS_Contact) {
        this.jLabelTJCS_Contact.setText(TJCS_Contact);
    }

    public void setVersion(String version) {
        this.jLabelVersion.setText(version);
    }
    
    public void setWebsite(String websiteDesc, String website) {
        this.jLabelWebSite.setText(websiteDesc);
        appWebsite = website;
    }
    
}
