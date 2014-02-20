package application.Modele.DAOLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class SujetDAO extends GenericMySQLDAO
{
	private ProfilDAO pDAO;
	private CategorieDAO cDAO;
	
	public SujetDAO(ProfilDAO pDAO, CategorieDAO cDAO)
	{
		this.pDAO = pDAO;
		this.cDAO = cDAO;
		all = all();
	}
	
	@Override
	public boolean insert(Contenu c) 
	{
		if(c.getClass().equals(Sujet.class))
		{
			Sujet s = (Sujet)(c);
			String query = "INSERT INTO SUJET (NOM, DESCRIPTION, DATE, IDCATEGORIE, IDPROFIL) VALUES ('" + s.getNom() + "', '" + s.getDescription()  + "', '" + new Timestamp(s.getDate().getTime()) + "', '" + s.getCategorie().getID() + "', '" + s.getProfil().getID() + "')";
			int PK = insertQuery(query);
			if(PK>0)
			{
				s.setID(PK);
				s.getCategorie().getSujet().add(s);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Contenu c) 
	{
		if(c.getClass().equals(Sujet.class))
		{
			Sujet s = (Sujet)c;
			if(updateQuery("DELETE FROM SUJET WHERE IDSUJET = " + c.getID()))
			{
				all.remove(c);
				s.getCategorie().deleteSujet(s);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Contenu c) 
	{
		return false;
	}
	
	@Override
	public Collection<? extends Contenu> all() 
	{
		ResultSet rs = selectQuery("SELECT * FROM SUJET");
		ArrayList<Sujet> list = new ArrayList<Sujet>();
		
		try 
		{
			while (rs.next ())
			{
					int idSujet = rs.getInt ("IDSUJET");
					String nom = rs.getString("NOM");
					String description = rs.getString("DESCRIPTION");
					Date date = rs.getTimestamp("DATE");
					int idCategorie = rs.getInt ("IDCATEGORIE");
					int idProfil = rs.getInt ("IDPROFIL");
					
					int indexP = pDAO.getAll().indexOf(new Profil(idProfil, null, null));
					int indexC = cDAO.getAll().indexOf(new Categorie(idCategorie, null, null));
		
					Sujet s = new Sujet(idSujet, nom, description, cDAO.getAll().get(indexC), pDAO.getAll().get(indexP), date);
					list.add(s);
					cDAO.getAll().get(indexC).addSujet(s);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Sujet> getAll()
	{
		return ((ArrayList<Sujet>) all);
	}
        
        public void setAll(ArrayList<Sujet> suj)
        {
            this.all = suj;
        }
}
