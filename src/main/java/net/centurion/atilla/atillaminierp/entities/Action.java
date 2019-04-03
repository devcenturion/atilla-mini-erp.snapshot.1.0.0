package net.centurion.atilla.atillaminierp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Action implements Serializable{

    @Id
    @NotNull
    private String url;

    @OneToMany
    @JoinColumn(name = "idAction")
    private Collection<GroupeAction> groupeActions;

    public Action (String url, Collection<GroupeAction> groupeActions) {
        this.url = url;
        this.groupeActions = groupeActions;
    }

    public Action ( ) {
        super();
    }

    public String getUrl ( ) {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public Collection<GroupeAction> getGroupeActions ( ) {
        return groupeActions;
    }

    public void setGroupeActions (Collection<GroupeAction> groupeActions) {
        this.groupeActions = groupeActions;
    }
}
