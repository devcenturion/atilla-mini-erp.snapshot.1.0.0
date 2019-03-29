package net.centurion.atilla.atillaminierp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserGroupe implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idGroupe")
    private Groupe groupe;

    public UserGroupe (User user, Groupe groupe) {
        this.user = user;
        this.groupe = groupe;
    }

    public UserGroupe ( ) {
        super();
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public User getUser ( ) {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Groupe getGroupe ( ) {
        return groupe;
    }

    public void setGroupe (Groupe groupe) {
        this.groupe = groupe;
    }
}
