package application.Modele.BaseLayer;

import java.text.DateFormat;
import java.util.Date;

public class Message extends Publication
{
	private Sujet sujet;
	private String message;
	
	public Message(String message, Sujet sujet, Profil profil, Date date) 
	{
		super(profil, date);
		this.message = message;
		this.sujet = sujet;
	}
	
	public Message(int id, String message, Sujet sujet, Profil profil, Date date) 
	{
		super(id, profil, date);
		this.message = message;
		this.sujet = sujet;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public Sujet getSujet()
	{
		return sujet;
	}
	
	public String toString()
	{
                return profil.getPseudo() + " le " + DateFormat.getDateInstance().format(date)+":\t"+message+"\n";
	}
}
