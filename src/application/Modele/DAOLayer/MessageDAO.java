package application.Modele.DAOLayer;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import framework.Contenu.*;
import application.Modele.BaseLayer.*;

public class MessageDAO extends GenericMySQLDAO
{
	private ProfilDAO pDAO;
	private SujetDAO sDAO;
	
	public MessageDAO(ProfilDAO pDAO, SujetDAO sDAO)
	{
		this.pDAO = pDAO;
		this.sDAO = sDAO;
		all = all();
	}
	
	@Override
	public boolean insert(Contenu c) 
	{
		if(c.getClass().equals(Message.class))
		{
			Message m = (Message)(c);
			String query = "INSERT INTO MESSAGE (MESSAGE, DATE, IDPROFIL, IDSUJET) VALUES ('" + m.getMessage() + "', '" + new Timestamp(m.getDate().getTime()) + "', '" + m.getProfil().getID() + "', '" + m.getSujet().getID() + "')";
			int PK = insertQuery(query);
			if(PK>0)
			{
				m.setID(PK);
				getAll().add(m);
				m.getSujet().addMessage(m);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Contenu c) 
	{
		if(c.getClass().equals(Message.class))
		{
			Message m = (Message) c;
			if(updateQuery("DELETE FROM MESSAGE WHERE IDMESSAGE = " + c.getID()))
			{
				all.remove(c);
				m.getSujet().deleteMessage(m);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Contenu c) 
	{
		if(c.getClass().equals(Message.class))
		{
			Message m = (Message)(c);
			String query = "UPDATE MESSAGE SET MESSAGE = '" + m.getMessage() + "', DATE = '" +  new Timestamp(m.getDate().getTime()) + "' WHERE IDMESSAGE = " + m.getID();
			return updateQuery(query);
		}
		return false;
	}
	
	@Override
	public Collection<? extends Contenu> all() 
	{
		ResultSet rs = selectQuery("SELECT * FROM MESSAGE");
		ArrayList<Message> list = new ArrayList<Message>();
		
		try 
		{
			while (rs.next ())
			{
					int idMessage = rs.getInt ("IDMESSAGE");
					String message = rs.getString("MESSAGE");
					Date date = rs.getTimestamp("DATE");
					int idSujet = rs.getInt ("IDSUJET");
					int idProfil = rs.getInt ("IDPROFIL");
					
					int indexP = pDAO.getAll().indexOf(new Profil(idProfil, null, null));
					int indexS = sDAO.getAll().indexOf(new Sujet(idSujet, null, null, null, null, null));
					
					Message m = new Message(idMessage, message, sDAO.getAll().get(indexS), pDAO.getAll().get(indexP), date);
					list.add(m);
					sDAO.getAll().get(indexS).addMessage(m);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Message> getAll()
	{
		return ((ArrayList<Message>) all);
	}
}
