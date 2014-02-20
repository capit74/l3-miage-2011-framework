package application.Modele.ModuleLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import framework.Commun.Module;
import framework.Contenu.*;
import application.Modele.DAOLayer.*;
import application.Modele.BaseLayer.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;

/**
 * Module de transfert de fichiers
 * 
 * @author Home
 */
public class GestionFichierModule extends Module
{
        //liste des fichiers presents sur le serveur
	private ArrayList<Fichier> catalogueFichier;
	
	public GestionFichierModule(DAOFactory factory)
	{
		super(factory);
		this.catalogueFichier = ((FichierDAO)factory.getDAO(Fichier.class)).getAll();
	}
        
	/**
         * Ajoute un fichier sur le serveur, dans la liste et dans la BD
         * @param pr le profil de l'utilisateur qui à envoyer le fichier
         * @param date la date de l'envoi
         * @param fdata le Fichier à ajouter
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean ajouterFichier(Profil pr, Date date, FilePacket fdata)
	{
            Fichier f = new Fichier(fdata.getName().substring(fdata.getName().lastIndexOf("\\")+1), pr, date);
            try {
                fdata.writeTo(new FileOutputStream(new File(f.getChemin())));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            return factory.getDAO(Fichier.class).insert(f);
	}
	
        /**
         * Recupere un fichier sur le serveur et le transmet
         * @param name le nom du fichier
         * @return le fichier demandé
         */
        public FilePacket download(String name){
            FilePacket fp = new FilePacket(name);
            fp.readIn();
            return fp;
        }
        
	public boolean deleteFichier(Fichier f)
	{
		return factory.getDAO(Fichier.class).delete(f);
	}
	
	public ArrayList<Fichier> getCatalogue()
	{
            //Correction bug a finir !!
            catalogueFichier = ((ArrayList<Fichier>)((FichierDAO)factory.getDAO(Fichier.class)).all());
            
		return catalogueFichier;
	}
        
	public Fichier getFichierByChemin(String chemin)
	{
            //Correction bug a finir !!
            catalogueFichier = ((ArrayList<Fichier>)((FichierDAO)factory.getDAO(Fichier.class)).all());
            
            Iterator it = catalogueFichier.iterator();

                while (it.hasNext()){
                    Fichier fichier = (Fichier) it.next();
                    if (fichier.getChemin().equalsIgnoreCase(chemin))
                        return fichier;
                }
                return null;
	}
	
	public void display()
	{
            //Correction bug a finir !!
            catalogueFichier = ((ArrayList<Fichier>)((FichierDAO)factory.getDAO(Fichier.class)).all());
            
		for(int i=0; i<catalogueFichier.size(); i++)
		{
			System.out.println(catalogueFichier.get(i).toString());
		}
		System.out.println();
	}
}
