package framework.Contenu;

import java.io.Serializable;

/**
 * Super classe designant les données que l'on souhaite échanger dans l'application
 * Pour creer sont type de données, il faut étendre cette classe
 * 
 * @author Home
 */
public abstract class Contenu implements Serializable {
    //L'identifiant du contenu
    protected int id;

    /**
     * Constructeur par defaut
     */
    public Contenu() {
        id = -1;
    }

    /**
     * Constructeur de Contenu
     * @param id L'identifiant du contenu
     */
    public Contenu(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Redefinition de la méthode equals pour comparer deux contenus
     * 
     * @param obj le contenu à comparer
     * @return True si les deux contenu sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Contenu c = (Contenu) obj;
            if (id == c.id) {
                return true;
            }
        }
        return false;
    }
}
