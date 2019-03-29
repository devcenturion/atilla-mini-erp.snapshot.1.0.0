package net.centurion.atilla.atillaminierp.service.interfaces;

import net.centurion.atilla.atillaminierp.entities.Action;
import net.centurion.atilla.atillaminierp.entities.Groupe;
import net.centurion.atilla.atillaminierp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Collection;

public interface IUserService{
    @Transactional
    Collection<Groupe> getGroupes (String login);

    @Transactional
    Collection<Action> getActions (String login);

    @Transactional
    String changePassCompte (String login, String oldPass, String newPass);

    @Transactional
    void save (User user);

    @Transactional
    void chekStatu (String login, Boolean statu);

    @Transactional
    void update (User newUser, String loginOldUser);

    @Transactional
    void delete (String login);

    Page<User> search (String mot, Pageable pageable);

    Page<User> searchByFirstName (String firstName, Pageable pageable);

    Page<User> searchByLastName (String lastName, Pageable pageable);

    Page<User> searchByPhone (String phone, Pageable pageable);

    Page<User> searchByAddress (String address, Pageable pageable);

    Page<User> searchByCni (String cni, Pageable pageable);

    Page<User> searchBySexe (String sexe, Pageable pageable);

    User searchByCompte (String login);

    @Transactional
    void deleteByGroupe (String groupe);

    @Transactional
    void addUserInGroupe (String nomGroupe, String loginUser);

    @Transactional
    void addUserInGroupe (Collection<User> users, Groupe groupe);
}
