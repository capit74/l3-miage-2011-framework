package application.Modele.BaseLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Sujet extends Publication
{
	private String nom, description;
	private Categorie categorie;
	private ArrayList<Message> messageList;
	
	public Sujet(String nom, String description, Categorie categorie, Profil profil, Date date) 
	{
		super(profil, date);
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.messageList = new ArrayList<Message>();
	}
	
	public Sujet(int id, String nom, String description, Categorie categorie, Profil profil, Date date) 
	{
		super(id, profil, date);
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.messageList = new ArrayList<Message>();
	}
	
	public void addMessage(Message m)
	{
		messageList.add(m);
	}
	
	public boolean deleteMessage(Message m)
	{
		return messageList.remove(m);
	}
	
	public boolean updateMessage(Message m)
	{
		if(messageList.remove(m))
		{
			messageList.add(m);
			return true;
		}
		return false;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
	
	public ArrayList<Message> getMessage()
	{
		return messageList;
	}
        
	public Message getMsgByNom(String nom)
	{
            Iterator it = messageList.iterator();

                while (it.hasNext()){
                    Message msg = (Message) it.next();
                    if (msg.getMessage().equalsIgnoreCase(nom))
                        return msg;
                }
                return null;
	}
	
	public String toString()
	{
		String str = "";
		str += nom + "\t" + description + "\t" + date + "\n";
		for(int i=0; i<messageList.size(); i++)
		{
			str += "\t\t" + messageList.get(i).toString() + "\n";
		}
		return str;
	}
}
