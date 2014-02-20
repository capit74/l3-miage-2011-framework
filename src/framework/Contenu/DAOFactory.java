package framework.Contenu;

import java.io.Serializable;

/**
 * Classe servant a creer et initialiser les classes qui vont heriter de GenricDAO
 * @see GenericDAO
 * @author Home
 */
public abstract class DAOFactory implements Serializable
{
	private static final long serialVersionUID = 1L;

        /**
         * Méthode qui permet de recuperer le DAO dont on a besoin
         * 
         * @param c la classe du DAO dont on a besoin. La classe doit etendre contenu
         * @return le DAO
         */
	public abstract GenericDAO getDAO(Class<? extends Contenu> c);
}
