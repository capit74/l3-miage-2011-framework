package framework.Client;

import framework.Commun.IApplication;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe realisant l'initialisation de la connexion avec le serveur.
 * On recupere la reference sur l'objet application qui se trouve sur le serveur.
 * 
 * @author MICHEL Rémi
 */
public class Client {

    //Attribut stockant la reference sur l'application distante
    private IApplication application;
    
    /**
     * Constructeur de la classe Client
     * @param hostServeur Addresse IP du serveur
     */
    public Client(String hostServeur) {
        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            //On construit l'URL avec laquelle le client pourra se connecter à l'application
            String urlApplication = "rmi://" + hostServeur + "/Application";
            //On peut désormais obtenir une référence sur cet objet distant
            Remote remote = Naming.lookup(urlApplication);
            if (remote instanceof IApplication) {
                application = (IApplication) remote;
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @return la reference sur l'application distante
     */
    public IApplication application(){
        return application;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Client("127.0.0.1");
    }
}
