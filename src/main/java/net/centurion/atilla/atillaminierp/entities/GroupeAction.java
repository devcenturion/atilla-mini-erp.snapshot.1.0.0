package net.centurion.atilla.atillaminierp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class GroupeAction implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idGroupe")
    private Groupe groupe;

    @ManyToOne
    @JoinColumn(name = "idAction")
    private Action action;

    public GroupeAction (Groupe groupe, Action action) {
        this.groupe = groupe;
        this.action = action;
    }

    public GroupeAction ( ) {
        super();
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Groupe getGroupe ( ) {
        return groupe;
    }

    public void setGroupe (Groupe groupe) {
        this.groupe = groupe;
    }

    public Action getAction ( ) {
        return action;
    }

    public void setAction (Action action) {
        this.action = action;
    }
}
