package application.Modele.BaseLayer;

import java.io.Serializable;
import java.util.Date;
import framework.Contenu.Contenu;

public abstract class Publication extends Contenu
{
	protected Date date;
	protected Profil profil;
	
	public Publication(Profil profil, Date date)
	{
		super();
		this.profil = profil;
		this.date = date;
	}
	
	public Publication(int id, Profil profil, Date date)
	{
		super(id);
		this.profil = profil;
		this.date = date;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public Profil getProfil()
	{
		return profil;
	}
}
