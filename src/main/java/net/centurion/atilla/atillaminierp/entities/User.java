package net.centurion.atilla.atillaminierp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class User implements Serializable{

    @Id
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String numeroTelephone;
    @NotNull
    private String address;
    @NotNull
    private Boolean actived = true;

    private String urlPhoto;

    @NotNull
    private Date dateNaissance;
    @NotNull
    private String cni;
    @NotNull
    private String sexe;
    @NotNull
    private String email;

    @OneToMany
    @JoinColumn(name = "idUser")
    private Collection<UserGroupe> userGroupes = new ArrayList<UserGroupe>();


    public User ( ) {
        super();
    }

    public User (String login, String password, String firstName, String lastName, String numeroTelephone, String address, Boolean actived, String urlPhoto, Date dateNaissance, String cni, String sexe, String email, Collection<UserGroupe> userGroupes) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numeroTelephone = numeroTelephone;
        this.address = address;
        this.actived = actived;
        this.urlPhoto = urlPhoto;
        this.dateNaissance = dateNaissance;
        this.cni = cni;
        this.sexe = sexe;
        this.email = email;
        this.userGroupes = userGroupes;
    }

    public String getLogin ( ) {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getFirstName ( ) {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName ( ) {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getNumeroTelephone ( ) {
        return numeroTelephone;
    }

    public void setNumeroTelephone (String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public Boolean getActived ( ) {
        return actived;
    }

    public void setActived (Boolean actived) {
        this.actived = actived;
    }

    public String getUrlPhoto ( ) {
        return urlPhoto;
    }

    public void setUrlPhoto (String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Date getDateNaissance ( ) {
        return dateNaissance;
    }

    public void setDateNaissance (Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCni ( ) {
        return cni;
    }

    public void setCni (String cni) {
        this.cni = cni;
    }

    public String getSexe ( ) {
        return sexe;
    }

    public void setSexe (String sexe) {
        this.sexe = sexe;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Collection<UserGroupe> getUserGroupes ( ) {
        return userGroupes;
    }

    public void setUserGroupes (Collection<UserGroupe> userGroupes) {
        this.userGroupes = userGroupes;
    }

}

