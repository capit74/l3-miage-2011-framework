package application.Modele.BaseLayer;

import java.util.Date;

public class Fichier extends Publication
{
	private String chemin;
	
	public Fichier(String chemin, Profil profil, Date date) 
	{
		super(profil, date);
		this.chemin = chemin;
	}
	
	public Fichier(int id, String chemin, Profil profil, Date date) 
	{
		super(id, profil, date);
		this.chemin = chemin;
	}

	public String getChemin()
	{
		return chemin;
	}
	
	public String toString()
	{
		return chemin + "\t" + date;
	}
}
