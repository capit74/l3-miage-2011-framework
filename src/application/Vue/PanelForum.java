/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelForum.java
 *
 * Created on 27 avr. 2012, 10:47:17
 */
package application.Vue;

import application.Modele.BaseLayer.Categorie;
import application.Modele.BaseLayer.Message;
import application.Modele.BaseLayer.Profil;
import application.Modele.BaseLayer.Sujet;
import application.Modele.ModuleLayer.ForumModule;
import application.Modele.ModuleLayer.GestionProfilModule;
import framework.Client.Client;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author kaba
 */
public class PanelForum extends javax.swing.JPanel {

    /** Creates new form PanelForum */
    public PanelForum() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEnvoyer = new javax.swing.JButton();
        jScrollPaneEcrireMessage = new javax.swing.JScrollPane();
        texteMessage = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListInformatique = new javax.swing.JList();
        jButtonNouveau_sujet = new javax.swing.JButton();
        rafraichirButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forum", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jButtonEnvoyer.setText("Envoyer");
        jButtonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerActionPerformed(evt);
            }
        });

        texteMessage.setColumns(20);
        texteMessage.setRows(5);
        jScrollPaneEcrireMessage.setViewportView(texteMessage);

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jTextAreaMessage.setFocusable(false);
        jScrollPane2.setViewportView(jTextAreaMessage);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("Topic de discussion :");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sujet :");

        jListInformatique.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListInformatiqueValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListInformatique);

        jButtonNouveau_sujet.setText("Nouveau Sujet");
        jButtonNouveau_sujet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouveau_sujetActionPerformed(evt);
            }
        });

        rafraichirButton.setText("Rafraichir");
        rafraichirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rafraichirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, 238, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNouveau_sujet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rafraichirButton)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPaneEcrireMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEnvoyer))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEnvoyer, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jScrollPaneEcrireMessage, 0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNouveau_sujet)
                            .addComponent(rafraichirButton))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNouveau_sujetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNouveau_sujetActionPerformed
        
        FenNouveauSujet nouvSuj = new FenNouveauSujet();
        nouvSuj.setFenetrePrincipal(ancetre);
        nouvSuj.setCategorie(this.getCategorieActuelle());
        nouvSuj.setFenPreced(this);
        nouvSuj.setVisible(true);
    }//GEN-LAST:event_jButtonNouveau_sujetActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        affichierSujet();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public void affichierSujet(){
try {
            String titreCategorie = (String) this.jComboBox1.getSelectedItem();
            ArrayList<Categorie> lesCategories = ancetre.application().getForum().getCatalogueCategorie();
            Iterator<Categorie> it = lesCategories.iterator();
            while (it.hasNext()) {
                Categorie categorieActuelle = it.next();
                if (categorieActuelle.getNom().equalsIgnoreCase(titreCategorie)) {
                    Iterator<Sujet> itSujet = categorieActuelle.getSujet().iterator();
                    HashSet<String> titreSujet = new HashSet<String>();
                    while (itSujet.hasNext()) {
                        Sujet sujetActuel = itSujet.next();
                        titreSujet.add(sujetActuel.getNom());
                    }
                    this.jListInformatique.setListData(titreSujet.toArray());
                    this.jTextAreaMessage.setText("");
                    break;
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PanelForum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jListInformatiqueValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListInformatiqueValueChanged

        // TODO add your handling code here:
        afficherMessage();
        
    }//GEN-LAST:event_jListInformatiqueValueChanged
    
    public void afficherMessage(){
        String titreSujet = (String) this.jListInformatique.getSelectedValue();
        ArrayList<Sujet> tousLesSujets = this.getCategorieActuelle().getSujet();
        Iterator<Sujet> itSujet = tousLesSujets.iterator();
        while (itSujet.hasNext()) {
            Sujet sujetActuel = itSujet.next();
            if (sujetActuel.getNom().equalsIgnoreCase(titreSujet)) {
                ArrayList<Message> tousLesMessages = sujetActuel.getMessage();
                Iterator<Message> itMessage = tousLesMessages.iterator();
                String affichageMessage = "";
                while (itMessage.hasNext()) {
                    Message messageActuel = itMessage.next();
                    affichageMessage += messageActuel.toString() + "\n";
                }
                this.jTextAreaMessage.setText(affichageMessage);
                this.sujetActuel = sujetActuel;
            }
        }
    }
    
    public Categorie getCategorieActuelle() {
        Categorie categorie = null;
        try {
            String titreCategorie = (String) this.jComboBox1.getSelectedItem();
            ArrayList<Categorie> lesCategories = ancetre.application().getForum().getCatalogueCategorie();
            Iterator<Categorie> it = lesCategories.iterator();
            while (it.hasNext()) {
                Categorie categorieActuelle = it.next();
                if (categorieActuelle.getNom().equalsIgnoreCase(titreCategorie)) {
                    categorie = categorieActuelle;
                }
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(PanelForum.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorie;
    }
    
    private void rafraichirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rafraichirButtonActionPerformed
        // TODO add your handling code here:
                this.afficherMessage();
    }//GEN-LAST:event_rafraichirButtonActionPerformed

    private void jButtonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerActionPerformed
        try {
            // TODO add your handling code here:
            Message mess = new Message(this.texteMessage.getText(), sujetActuel, ancetre.profil(), new Date());
            ancetre.application().getForum().ajouterMessage(mess);
            this.texteMessage.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(PanelForum.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        afficherMessage();
    }//GEN-LAST:event_jButtonEnvoyerActionPerformed
    
    public void setFenetrePrincipal(FenPrincipale fen) {
        try {
            this.ancetre = fen;
            ArrayList<Categorie> toutesLesCategories = ancetre.application().getForum().getCatalogueCategorie();
            Iterator<Categorie> itCategorie = toutesLesCategories.iterator();
            while (itCategorie.hasNext()) {
                Categorie cat = itCategorie.next();
                this.jComboBox1.addItem(cat.getNom());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PanelForum.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnvoyer;
    private javax.swing.JButton jButtonNouveau_sujet;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListInformatique;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPaneEcrireMessage;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JButton rafraichirButton;
    private javax.swing.JTextArea texteMessage;
    // End of variables declaration//GEN-END:variables
    private FenPrincipale ancetre;
    private Sujet sujetActuel;
}
