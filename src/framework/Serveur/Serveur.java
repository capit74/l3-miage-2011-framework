/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.Serveur;

import framework.Commun.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe servant à initialiser le serveur.
 * Creer une nouvelle instance de l'application et la partage grâce à RMI
 * 
 * @author MICHEL Rémi
 */
public class Serveur {
    //L'application que l'on souhaite partager
    private IApplication application;

    /**
     * Constructeur du Serveur
     * @param host l'adresse à laquelle on souhaite établir le serveur
     */
    public Serveur(String host) {
        try {
            //Le registre de nom RMI doit s'exécuter avant toute opération
            LocateRegistry.createRegistry(1099);
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            //On crée une instance de l'application
            application = new Application();
            //On configure l'URL sur laquelle cet objet pourra être joignable
            String url = "rmi://" + host + "/Application";
            //On lie l'objet "application" à l'URL pour le rendre accessible à distance
            Naming.rebind(url, application);
            //On informe sur le succès du lancement
            System.out.println("Serveur lancé avec succès à l'adresse "+host+" sur le port 1099");
        } catch (RemoteException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
            //Si on ne fourni pas d'argument, lancement du serveur en local
                Serveur serv = new Serveur("127.0.0.1:1099");

    }
}
