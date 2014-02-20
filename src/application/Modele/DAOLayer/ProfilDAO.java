package application.Modele.DAOLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class ProfilDAO extends GenericMySQLDAO
{
	public ProfilDAO()
	{
		all = all();
	}
	
	@Override
	public boolean insert(Contenu c) 
	{
		if(c.getClass().equals(Profil.class))
		{
			Profil p = (Profil)(c);
			String query = "INSERT INTO PROFIL (PSEUDO, PASSWORD, ADMIN) VALUES ('" + p.getPseudo() + "', '" + p.getPassword() + "', '" + String.valueOf(p.getAdmin()) + "')";
			int PK = insertQuery(query);
			if(PK>0)
			{
				p.setID(PK);
				getAll().add(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Contenu c) 
	{
		if(c.getClass().equals(Profil.class))
		{
			 if(updateQuery("DELETE FROM PROFIL WHERE IDPROFIL = " + c.getID()))
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
		if(c.getClass().equals(Profil.class))
		{
			Profil p = (Profil)(c);
			String query = "UPDATE PROFIL SET PSEUDO = '" + p.getPseudo() + "', PASSWORD = '" + p.getPassword() + "' WHERE IDPROFIL = " + p.getID();
			return updateQuery(query);
		}
		return false;
	}

	@Override
	public Collection<? extends Contenu> all() 
	{
		ResultSet rs = selectQuery("SELECT * FROM PROFIL");
		ArrayList<Profil> list = new ArrayList<Profil>();
		
		try 
		{
			while (rs.next ())
			{
					int idProfil = rs.getInt ("IDPROFIL");
					String pseudo = rs.getString("PSEUDO");
					String password = rs.getString ("PASSWORD");
                                        int admin = rs.getInt("ADMIN");
					list.add(new Profil(idProfil, pseudo, password, admin));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Profil> getAll()
	{
		return ((ArrayList<Profil>) all);
	}
}
