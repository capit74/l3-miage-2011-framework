package framework.Commun;


import java.rmi.Remote;
import java.rmi.RemoteException;
import application.Modele.DAOLayer.*;
import application.Modele.ModuleLayer.*;
import framework.Commun.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * L'interface qui definit les méthodes de l'application accesible par un client au travers de RMI
 * Cette interface doit être compléter par le developpeur de l'application
 * 
 * @author MICHEL Rémi
 */
public interface IApplication extends Remote 
{
    public ForumModule getForum() throws RemoteException;
    public GestionProfilModule getGestionProfil() throws RemoteException;    
    public GestionFichierModule getGestionFichier() throws RemoteException;
}
