package net.centurion.atilla.atillaminierp.service.dto;/*
package net.devcenturion.minierpatilla.service.dto;

import net.devcenturion.minierpatilla.entities.Compte;

import javax.persistence.*;
import java.io.Serializable;

public class UserDto implements Serializable{

    @Id
    @GeneratedValue
    private Integer idUser;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String sexe ;


    public String getSexe ( ) {
        return sexe;
    }



    public void setSexe (String sexe) {
        this.sexe = sexe;
    }

    @OneToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;



    public Integer getIdUser ( ) {
        return idUser;
    }

    public void setIdUser (Integer idUser) {
        this.idUser = idUser;
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

    public String getPhone ( ) {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public Compte getCompte ( ) {
        return compte;
    }

    public void setCompte (Compte compte) {
        this.compte = compte;
    }




    public UserDto (String firstName, String lastName, String sexe, String phone, String address, Compte compte) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.compte = compte;
        this.sexe = sexe ;
    }


    public UserDto ( ) {
        super();
    }
}
*/

