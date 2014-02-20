package application.Modele.DAOLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class FichierDAO extends GenericMySQLDAO
{
	private ProfilDAO pDAO;
	
	public FichierDAO(ProfilDAO pDAO)
	{
		this.pDAO = pDAO;
		all = all();
	}
	
	@Override
	public boolean insert(Contenu c) 
	{
		if(c.getClass().equals(Fichier.class))
		{
			Fichier f = (Fichier)(c);
			String query = "INSERT INTO FICHIER (CHEMIN, DATE, IDPROFIL) VALUES ('" + f.getChemin() + "', '" + new Timestamp(f.getDate().getTime()) + "', '" + f.getProfil().getID() + "')";
			int PK = insertQuery(query);
			if(PK>0)
			{
				f.setID(PK);
				getAll().add(f);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Contenu c) 
	{
		if(c.getClass().equals(Fichier.class))
		{
			if(updateQuery("DELETE FROM FICHIER WHERE IDFICHIER = " + c.getID()))
			{
				all.remove(c);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Contenu c) 
	{
		if(c.getClass().equals(Fichier.class))
		{
			Fichier f = (Fichier)(c);
			String query = "UPDATE FICHIER SET CHEMIN = '" + f.getChemin() + "', DATE = '" +  new Timestamp(f.getDate().getTime()) + "' WHERE IDFICHIER = " + f.getID();
			return updateQuery(query);
		}
		return false;
	}
	
	@Override
	public Collection<? extends Contenu> all() 
	{
		ResultSet rs = selectQuery("SELECT * FROM FICHIER");
		ArrayList<Fichier> list = new ArrayList<Fichier>();
		
		try 
		{
			while (rs.next ())
			{
					int idFichier = rs.getInt ("IDFICHIER");
					String chemin = rs.getString("CHEMIN");
					Date date = rs.getTimestamp("DATE");
					int idProfil = rs.getInt ("IDPROFIL");
					int index = pDAO.getAll().indexOf(new Profil(idProfil, null, null));
					list.add(new Fichier(idFichier, chemin, pDAO.getAll().get(index), date));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Fichier> getAll()
	{
		return ((ArrayList<Fichier>) all);
	}
}
