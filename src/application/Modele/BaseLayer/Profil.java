package application.Modele.BaseLayer;

import framework.Contenu.Contenu;

public class Profil extends Contenu
{
	private String pseudo, password;
        private int admin;
	
	public Profil(String pseudo, String password)
	{
		this.pseudo = pseudo;
		this.password = password;
                this.admin = 0;
	}
	
	public Profil(int id, String pseudo, String password)
	{
		super(id);
		this.pseudo = pseudo;
		this.password = password;
                this.admin = 0;
	}
        
	public Profil(String pseudo, String password, int admin)
	{
		this.pseudo = pseudo;
		this.password = password;
                this.admin = admin;
	}
	
	public Profil(int id, String pseudo, String password, int admin)
	{
		super(id);
		this.pseudo = pseudo;
		this.password = password;
                this.admin = admin;
	}
	
	public boolean login(Profil p)
	{
		if(pseudo.equals(p.pseudo) && password.equals(p.password))
				return true;
		return false;
	}
	
	public String getPseudo()
	{
		return pseudo;
	}
	
	public String getPassword()
	{
		return password;
	}
        
        public void changerMDP(String newmdp){
            this.password = new String(newmdp);
        }
        
	public int getAdmin()
	{
		return admin;
	}
        
        public boolean isAdmin() {
            if (this.admin == 1)
                return true;
            else
                return false;
        }
	
	public String toString()
	{
		return pseudo + "\t" + password + "\tAdmin : " + this.isAdmin();
	}
}
