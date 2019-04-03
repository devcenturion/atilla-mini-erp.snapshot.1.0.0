package net.centurion.atilla.atillaminierp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Groupe implements Serializable{

    @Id
    @NotNull
    private String nom;
    @NotNull
    private String description;
    @NotNull
    private Date dateCreationGroupe;

    @OneToMany
    @JoinColumn(name = "idGroupe")
    private Collection<GroupeAction> groupeActions;

    @OneToMany
    @JoinColumn(name = "idGroupe")
    private Collection<UserGroupe> userGroupes;

    public Groupe (String nom, String description, Collection<GroupeAction> groupeActions, Collection<UserGroupe> userGroupes) {
        this.nom = nom;
        this.description = description;
        this.dateCreationGroupe = new Date();
        this.groupeActions = groupeActions;
        this.userGroupes = userGroupes;
    }


    public Groupe ( ) {
        super();
    }

    public String getNom ( ) {
        return nom;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Date getDateCreationGroupe ( ) {
        return dateCreationGroupe;
    }

    public void setDateCreationGroupe (Date dateCreationGroupe) {
        this.dateCreationGroupe = dateCreationGroupe;
    }

    public Collection<GroupeAction> getGroupeActions ( ) {
        return groupeActions;
    }

    public void setGroupeActions (Collection<GroupeAction> groupeActions) {
        this.groupeActions = groupeActions;
    }

    public Collection<UserGroupe> getUserGroupes ( ) {
        return userGroupes;
    }

    public void setUserGroupes (Collection<UserGroupe> userGroupes) {
        this.userGroupes = userGroupes;
    }
}
