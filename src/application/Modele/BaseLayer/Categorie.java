package application.Modele.BaseLayer;

import java.util.ArrayList;
import framework.Contenu.Contenu;
import java.util.Iterator;

public class Categorie extends Contenu
{
	private String nom, description;
	private ArrayList<Sujet> sujetList;
	
	public Categorie(String nom, String description)
	{
		super();
		this.nom = nom;
		this.description = description;
		this.sujetList = new ArrayList<Sujet>();
	}
	
	public Categorie(int id, String nom, String description)
	{
		super(id);
		this.nom = nom;
		this.description = description;
		this.sujetList = new ArrayList<Sujet>();
	}
	
	public void addSujet(Sujet s)
	{
		sujetList.add(s);
	}
	
	public boolean deleteSujet(Sujet s)
	{
		return sujetList.remove(s);
	}
	
	public boolean updateSujet(Sujet s)
	{
		if(sujetList.remove(s))
		{
			sujetList.add(s);
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
	
	public ArrayList<Sujet> getSujet()
	{
		return sujetList;
	}
        
	public Sujet getSujetByNom(String nom)
	{
            Iterator it = sujetList.iterator();

                while (it.hasNext()){
                    Sujet sujet = (Sujet) it.next();
                    if (sujet.getNom().equalsIgnoreCase(nom))
                        return sujet;
                }
                return null;
	}
	
	public String toString()
	{
		String str = "";
		str += nom + "\t" + description + "\n";
		for(int i=0; i<sujetList.size(); i++)
		{
			str += "\t" + sujetList.get(i).toString() + "\n";
		}
		return str;
	}
}
