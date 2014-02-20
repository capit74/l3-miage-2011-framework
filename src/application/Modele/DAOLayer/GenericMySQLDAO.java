package application.Modele.DAOLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import framework.Contenu.*;
import application.Modele.BaseLayer.Categorie;

public abstract class GenericMySQLDAO extends GenericDAO
{
	protected static Connection conn;

	public static void setConnection(String database, String user, String password)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(database, user, password);
			conn.setAutoCommit(true);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	protected int insertQuery(String query)
	{
		try
		{
                    //Correction bug a finir !!
                    setConnection("jdbc:mysql://localhost:3306/projetbd", "root", "xxxx");
                    
			Statement s = conn.createStatement ();
			int res = s.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = s.getGeneratedKeys();
			rs.next();
			if(res!=0)
				return rs.getInt(1);
			rs.close();
			s.close();
		}
		catch (SQLException e)
		{
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
		return 0;
	}
	
	protected boolean updateQuery(String query)
	{
		try
		{
                    //Correction bug a finir !!
                    setConnection("jdbc:mysql://localhost:3306/projetbd", "root", "xxxx");
                    
			Statement s = conn.createStatement ();
			int res = s.executeUpdate(query);
			s.close ();
			if(res!=0)
				return true;
		}
		catch (SQLException e)
		{
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
		return false;
	}
	
	protected ResultSet selectQuery(String query)
	{
		try 
		{
                    //Correction bug a finir !!
                    setConnection("jdbc:mysql://localhost:3306/projetbd", "root", "xxxx");
                    
			Statement s = conn.createStatement ();
			s.executeQuery (query);
			ResultSet rs = s.getResultSet ();
			return rs;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection()
	{
		try
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
