package application.Modele.ModuleLayer;

import java.util.ArrayList;
import framework.Commun.Module;
import framework.Contenu.*;
import application.Modele.DAOLayer.*;
import application.Modele.BaseLayer.*;
import java.util.Iterator;

/**
 * Module Forum
 * @author Home
 */
public class ForumModule extends Module
{
        //liste des categorie disponnible sur le forum
	private ArrayList<Categorie> catalogueCategorie;
	
	public ForumModule(DAOFactory factory)
	{
		super(factory);
		this.catalogueCategorie = ((CategorieDAO)factory.getDAO(Categorie.class)).getAll();
	}
	
        /**
         * Ajoute une categorie dans le forum
         * @param c la categorie à ajouter
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean ajouterCategorie(Categorie c)
	{
		return factory.getDAO(Categorie.class).insert(c);
	}
	
        /**
         * Supprime une categorie du forum
         * @param c la categorie a supprimer
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean deleteCategorie(Categorie c)
	{
		return factory.getDAO(Categorie.class).delete(c);
	}
	
        /**
         * Ajoute un sujet dans une categorie
         * @param s le sujet à ajouter
         * @return vrai si l'operation c'est bien déroulé, faux sinon
         */
	public boolean ajouterSujet(Sujet s)
	{
		return factory.getDAO(Sujet.class).insert(s);
	}
	
	public boolean deleteSujet(Sujet s)
	{
		return factory.getDAO(Sujet.class).delete(s);
	}
	
	public boolean ajouterMessage(Message m)
	{
		return factory.getDAO(Message.class).insert(m);
	}
	
	public boolean deleteMessage(Message m)
	{
		return factory.getDAO(Message.class).delete(m);
	}
	
	public ArrayList<Categorie> getCatalogueCategorie()
	{
            //Correction bug a finir !!
            catalogueCategorie = ((ArrayList<Categorie>)((CategorieDAO)factory.getDAO(Categorie.class)).all());
            ((CategorieDAO)factory.getDAO(Categorie.class)).setAll(catalogueCategorie);
             ArrayList<Sujet> catalogueSujet  = ((ArrayList<Sujet>)((SujetDAO)factory.getDAO(Sujet.class)).all());
             ((SujetDAO)factory.getDAO(Sujet.class)).setAll(catalogueSujet);
            ((MessageDAO)factory.getDAO(Message.class)).all();
            
		return catalogueCategorie;
	}
        
	public Categorie getCategorieByNom(String nom)
	{
            //Correction bug a finir !!
            catalogueCategorie = ((ArrayList<Categorie>)((CategorieDAO)factory.getDAO(Categorie.class)).all());
            ((CategorieDAO)factory.getDAO(Categorie.class)).setAll(catalogueCategorie);
             ArrayList<Sujet> catalogueSujet  = ((ArrayList<Sujet>)((SujetDAO)factory.getDAO(Sujet.class)).all());
             ((SujetDAO)factory.getDAO(Sujet.class)).setAll(catalogueSujet);
            ((MessageDAO)factory.getDAO(Message.class)).all();
            
            
            Iterator it = catalogueCategorie.iterator();

                while (it.hasNext()){
                    Categorie categorie = (Categorie) it.next();
                    if (categorie.getNom().equalsIgnoreCase(nom))
                        return categorie;
                }
                return null;
	}
	
	public void display()
	{
            //Correction bug a finir !!
            catalogueCategorie = ((ArrayList<Categorie>)((CategorieDAO)factory.getDAO(Categorie.class)).all());
            ((CategorieDAO)factory.getDAO(Categorie.class)).setAll(catalogueCategorie);
             ArrayList<Sujet> catalogueSujet  = ((ArrayList<Sujet>)((SujetDAO)factory.getDAO(Sujet.class)).all());
             ((SujetDAO)factory.getDAO(Sujet.class)).setAll(catalogueSujet);
            ((MessageDAO)factory.getDAO(Message.class)).all();
            
		for(int i=0; i<catalogueCategorie.size(); i++)
		{
			System.out.println(catalogueCategorie.get(i).toString());
		}
		System.out.println();
	}
}
