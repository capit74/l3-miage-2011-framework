package application.Modele.DAOLayer;

import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class MySQLFactory extends DAOFactory
{	
	private ProfilDAO pDAO;
	private CategorieDAO cDAO;
	private FichierDAO fDAO;
	private SujetDAO sDAO;
	private MessageDAO mDAO;
	
	public MySQLFactory(String database, String user, String password)
	{
		GenericMySQLDAO.setConnection(database, user, password);
		pDAO = new ProfilDAO();
		cDAO = new CategorieDAO();
		fDAO = new FichierDAO(pDAO);
		sDAO = new SujetDAO(pDAO, cDAO);
		mDAO = new MessageDAO(pDAO, sDAO);
	}
	
	@Override
	public GenericDAO getDAO(Class<? extends Contenu> c) 
	{
		if(c.equals(Profil.class))
			return pDAO;
		if(c.equals(Message.class))
			return mDAO;
		if(c.equals(Fichier.class))
			return fDAO;
		if(c.equals(Categorie.class))
			return cDAO;
		if(c.equals(Sujet.class))
			return sDAO;
		return null;
	}
}
