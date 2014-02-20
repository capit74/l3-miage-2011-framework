package application.Modele.DAOLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class CategorieDAO extends GenericMySQLDAO
{
	public CategorieDAO()
	{
		all = all();
	}
	
	@Override
	public boolean insert(Contenu c) 
	{
		if(c.getClass().equals(Categorie.class))
		{
			Categorie ca = (Categorie)(c);
			String query = "INSERT INTO CATEGORIE (NOM, DESCRIPTION) VALUES ('" + ca.getNom() + "', '" + ca.getDescription() + "')";
			int PK = insertQuery(query);
			if(PK>0)
			{
				ca.setID(PK);
				getAll().add(ca);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Contenu c) 
	{
		if(c.getClass().equals(Categorie.class))
		{
			if(updateQuery("DELETE FROM CATEGORIE WHERE IDCATEGORIE = " + c.getID()))
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
		if(c.getClass().equals(Categorie.class))
		{
			Categorie ca = (Categorie)(c);
			String query = "UPDATE CATEGORIE SET NOM = '" + ca.getNom()  + "', DESCRIPTION = '" + ca.getDescription() + "' WHERE IDCATEGORIE = " + ca.getID();
			return updateQuery(query);
		}
		return false;
	}

	@Override
	public Collection<? extends Contenu> all() 
	{
		ResultSet rs = selectQuery("SELECT * FROM CATEGORIE");
		ArrayList<Categorie> list = new ArrayList<Categorie>();
		
		try 
		{
			while (rs.next ())
			{
					int idCategorie = rs.getInt ("IDCATEGORIE");
					String nom = rs.getString("NOM");
					String description = rs.getString ("DESCRIPTION");
					list.add(new Categorie(idCategorie, nom, description));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Categorie> getAll()
	{
		return ((ArrayList<Categorie>) all);
	}
        
        public void setAll(ArrayList<Categorie> cat)
        {
            this.all = cat;
        }
}
