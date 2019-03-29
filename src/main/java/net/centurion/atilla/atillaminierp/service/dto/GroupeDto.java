package net.centurion.atilla.atillaminierp.service.dto;/*package net.devcenturion.minierpatilla.service.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class GroupeDto implements Serializable {
	
    @Id
	@GeneratedValue
    private Integer idGroupe;

    private String descriptionGroupe;
    
    private String nomGroupe;
    

    private Date dateCreationGroupe;

	public Collection<UserGroupeDto> getUserGroupes ( ) {
		return userGroupes;
	}

	public void setUserGroupes (Collection<UserGroupeDto> userGroupes) {
		this.userGroupes = userGroupes;
	}

	@OneToMany
	@JoinColumn(name = "idGroupe")
    private Collection<UserGroupeDto> userGroupes;

	public Integer getIdGroupe ( ) {
		return idGroupe;
	}

	public void setIdGroupe (Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getDescriptionGroupe ( ) {
		return descriptionGroupe;
	}

	public void setDescriptionGroupe (String descriptionGroupe) {
		this.descriptionGroupe = descriptionGroupe;
	}

	public String getNomGroupe ( ) {
		return nomGroupe;
	}

	public void setNomGroupe (String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Date getDateCreationGroupe ( ) {
		return dateCreationGroupe;
	}

	public void setDateCreationGroupe (Date dateCreationGroupe) {
		this.dateCreationGroupe = dateCreationGroupe;
	}



	public GroupeDto (String descriptionGroupe, String nomGroupe, Date dateCreationGroupe, Collection<UserGroupeDto> userGroupes) {
		this.descriptionGroupe = descriptionGroupe;
		this.nomGroupe = nomGroupe;
		this.dateCreationGroupe = dateCreationGroupe;
		this.userGroupes = userGroupes;
	}

	public GroupeDto ( ) {
		super();
	}
}*/
