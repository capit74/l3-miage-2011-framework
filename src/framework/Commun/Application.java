package framework.Commun;


import application.Modele.DAOLayer.*;
import application.Modele.ModuleLayer.*;
import framework.Commun.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe définissant l'application que l'on souhaite developper.
 * Cette classe doit être completer par le developper de l'application,
 * C'est ici qu'on ajoute les modules développés
 * ainsi que l'implementation de la DAOFactory si l'on souhaite avoir de la persistance.
 * 
 * @author MICHEL Rémi
 */
public class Application extends UnicastRemoteObject implements IApplication 
{
    private MySQLFactory factory;
    private GestionProfilModule gProfil;
    private GestionFichierModule gFichier;
    private ForumModule forum;
    
    public Application() throws RemoteException
    {
        factory = new MySQLFactory("jdbc:mysql://localhost:3306/projetbd", "root", "xxxx");
	gProfil = new GestionProfilModule(factory);
	gFichier = new GestionFichierModule(factory);
	forum = new ForumModule(factory);
    }

    @Override
    public ForumModule getForum() throws RemoteException 
    {
        return forum;
    }

    @Override
    public GestionProfilModule getGestionProfil() throws RemoteException {
        return gProfil;
    }

    @Override
    public GestionFichierModule getGestionFichier() throws RemoteException {
        return gFichier;
    }
}
