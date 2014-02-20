package application.Modele.ModuleLayer;

import java.util.ArrayList;
import framework.Commun.Module;
import framework.Contenu.*;
import application.Modele.DAOLayer.*;
import application.Modele.BaseLayer.*;
import java.util.Iterator;

/**
 * Module de gestion des utilisateurs et de leurs profils
 * 
 * @author Home
 */
public class GestionProfilModule extends Module
{
        //liste des profils
	private ArrayList<Profil> catalogueProfil;
	
	public GestionProfilModule(DAOFactory factory)
	{
		super(factory);
		this.catalogueProfil = ((ProfilDAO)factory.getDAO(Profil.class)).getAll();
	}
	/**
         * ajoute un profil dans la liste et dans la base de donnée
         * @param p le profil à ajouter
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean ajouterProfil(Profil p)
	{
            boolean res = factory.getDAO(Profil.class).insert(p);
		return res;
	}
	
        /**
         * supprime un profil de la liste et dans la base de donnée
         * @param p le profil à supprimer
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean deleteProfil(Profil p)
	{
		return factory.getDAO(Profil.class).delete(p);
	}
	
	public ArrayList<Profil> getCatalogue()
	{
            
            catalogueProfil = ((ArrayList<Profil>)((ProfilDAO)factory.getDAO(Profil.class)).all());
            
		return catalogueProfil;
	}
	
	public void display()
	{
            
            
            catalogueProfil = ((ArrayList<Profil>)((ProfilDAO)factory.getDAO(Profil.class)).all());
            
		for(int i=0; i<catalogueProfil.size(); i++)
		{
			System.out.println(catalogueProfil.get(i).toString());
		}
		System.out.println();
	}
        /**
         * Methode verifiant l'identification d'un utilisateur
         * 
         * @param pseudo le nom de l'utilisateur
         * @param mdp le mot de passe de l'utilisateur
         * @return le profil de cette utilisateur si l'identification est correct, null sinon
         */
        public Profil login(String pseudo, String mdp){
            
            
            catalogueProfil = ((ArrayList<Profil>)((ProfilDAO)factory.getDAO(Profil.class)).all());
            
            Profil log = null;
            for(int i=0; i<this.catalogueProfil.size(); i++){
                if(pseudo.equals(this.catalogueProfil.get(i).getPseudo()) && mdp.equals(this.catalogueProfil.get(i).getPassword())){
                    log = this.catalogueProfil.get(i);
                    break;
                }
            }
            return log;
        }
        /**
         * Permet de recuperer le profil d'un utilisateur à partir de son pseudo
         * @param pseudo le nom de l'utilisateur
         * @return le profil si il existe faux sinon
         */
	public Profil getProfilByPseudo(String pseudo)
	{
            
            
            catalogueProfil = ((ArrayList<Profil>)((ProfilDAO)factory.getDAO(Profil.class)).all());
            
            Iterator it = catalogueProfil.iterator();

                while (it.hasNext()){
                    Profil profil = (Profil) it.next();
                    if (profil.getPseudo().equalsIgnoreCase(pseudo))
                        return profil;
                }
                return null;
	}
        /**
         * Modifie le mot de passe d'un utilisateur
         * @param pr le profil concerné
         * @param newmdp le nouveau mot de passe
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
        public boolean changerMDP(Profil pr, String newmdp){
            pr.changerMDP(newmdp);
            return factory.getDAO(Profil.class).update(pr);
        }
        
}
