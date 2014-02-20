package framework.Commun;

import java.io.Serializable;

import framework.Contenu.DAOFactory;

/**
 * La super classe à partir de laquelle on creer les different modules de notre application.
 * Chaque module devra étendre cette classe.
 * 
 * @author Home
 */
public abstract class Module implements Serializable {
    //La factory servant à initialiser les données du module
    protected DAOFactory factory;

    /**
     * Constructeur de module
     * @param factory La factory servant à initialiser les données du module
     */
    public Module(DAOFactory factory) {
        this.factory = factory;
    }
}
