package net.centurion.atilla.atillaminierp.service.interfaces;

import net.centurion.atilla.atillaminierp.entities.Groupe;
import net.centurion.atilla.atillaminierp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Collection;

public interface IGroupeService{
    @Transactional
    String[] getRoles ( );

    String getRole (String roles);

    @Transactional
    String[] getMachers (String groupe);

    @Transactional
    Collection<User> getUser (String nom);

    Page<Groupe> search (String mot, Pageable pageable);

    void save (Groupe groupe);

    @Transactional
    void addUserInGroupe (String nomGroupe, String loginUser);

    @Transactional
    void addUserInGroupe (Collection<User> users, Groupe groupe);

    @Transactional
    Collection<User> getGroupeUser (Groupe groupe);

    @Transactional
    void removeUserInGroupe (String idGroupe, String idUser);

    void removeUserInGroupe (Collection<User> users, Groupe groupe);

    Collection<Groupe> listGroupes ( );
}
