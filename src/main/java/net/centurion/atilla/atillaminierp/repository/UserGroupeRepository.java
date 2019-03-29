package net.centurion.atilla.atillaminierp.repository;

import net.centurion.atilla.atillaminierp.entities.Groupe;
import net.centurion.atilla.atillaminierp.entities.User;
import net.centurion.atilla.atillaminierp.entities.UserGroupe;

import org.springframework.data.repository.CrudRepository;

public interface UserGroupeRepository extends CrudRepository<UserGroupe, Integer>{

    public UserGroupe findByGroupeAndUser (Groupe groupe, User user);
}
