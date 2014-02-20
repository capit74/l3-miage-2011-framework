package framework.Contenu;

import java.io.Serializable;
import java.util.Collection;

/**
 * Classe abstraite définissant un comportement pour la persistance des données.
 * L'implémentation de cette classe va définir comment l'on souhaite rendre les données persistantes,
 * en utilisant par exemple une base de données ou la serialization
 * 
 * @author Home
 */
public abstract class GenericDAO implements Serializable
{
	protected Collection<? extends Contenu> all;
        
	/**
         * Methode de sauvegarde d'un contenu
         * 
         * @param c le contenu a sauvegarder
         * @return true si l'operation est un succes false sinon
         */
	public abstract boolean insert(Contenu c);
        
        /**
         * Methode de suppresion d'un contenu
         * 
         * @param c le contenu à supprimer
         * @return true si l'operation est un succes false sinon
         */
	public abstract boolean delete(Contenu c);
        
        /**
         * Méthode de mise a jour d'un contenu
         * 
         * @param c le contenu ayant la nouvelle valeur
         * @return true si l'operation est un succes false sinon
         */
	public abstract boolean update(Contenu c);
        
        /**
         * Méthode réalisant le chargement de tous les contenu sauvegardés dans une collection
         * 
         * @return La collection de contenu sauvegarder sur le serveur
         */
	protected abstract Collection<? extends Contenu> all();
	
	public Collection<? extends Contenu> getAll()
	{
		return all;
	}
}
