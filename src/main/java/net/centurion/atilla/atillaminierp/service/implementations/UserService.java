package net.centurion.atilla.atillaminierp.service.implementations;


import net.centurion.atilla.atillaminierp.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

import net.centurion.atilla.atillaminierp.entities.*;
import net.centurion.atilla.atillaminierp.repository.*;


@Service
public class UserService implements IUserService{

    @Autowired
    private UserGroupeRepository userGroupeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppService appService;

    @Autowired
    private GroupeRepository groupeRepository;

    @Transactional
    @Override
    public Collection<Groupe> getGroupes (String login) {
        User user = userRepository.findOne(login);
        Collection<Groupe> groupes = new ArrayList<Groupe>();


        user.getUserGroupes().forEach(userGroupe -> {
            groupes.add(userGroupe.getGroupe());
        });

        return groupes;
    }

    @Transactional
    @Override
    public Collection<Action> getActions (String login) {

        User user = userRepository.findOne(login);
        Collection<Action> actions = new ArrayList<Action>();

        user.getUserGroupes().forEach(userGroupe -> {
            userGroupe.getGroupe().getGroupeActions().forEach(groupeAction -> {
                actions.add(groupeAction.getAction());
            });
        });

        return actions;
    }


    @Transactional
    @Override
    public String changePassCompte (String login, String oldPass, String newPass) {
        String msg = "";

        User user = userRepository.findOne(login);

        if (!user.equals(null)) {
            if (user.getPassword().equals(oldPass)) {
                user.setPassword(newPass);
                userRepository.save(user);
            } else msg = msg + "mauvais mot de passe";
        } else msg = msg + "mauvais login";
        return msg;
    }


    @Transactional
    @Override
    public void save (User user) {
        user.setPassword(appService.passGenerator(6));
        userRepository.save(user);
    }


    @Transactional
    @Override
    public void chekStatu (String login, Boolean statu) {
        User user = userRepository.findOne(login);
        user.setActived(statu);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update (User newUser, String loginOldUser) {
        User user1 = userRepository.findOne(loginOldUser);
        user1.setAddress(newUser.getAddress());
        user1.setFirstName(newUser.getFirstName());
        user1.setLastName(newUser.getLastName());
        user1.setNumeroTelephone(newUser.getNumeroTelephone());
        user1.setSexe(newUser.getSexe());
        user1.setEmail(newUser.getEmail());
        user1.setPassword(newUser.getPassword());
        user1.setActived(newUser.getActived());
        user1.setCni(newUser.getCni());
        user1.setDateNaissance(newUser.getDateNaissance());
        user1.setUrlPhoto(newUser.getUrlPhoto());

        userRepository.save(user1);
    }

    @Transactional
    @Override
    public void delete (String login) {

        User user = userRepository.findOne(login);

        userRepository.delete(user);
    }

    @Override
    public Page<User> search (String mot, Pageable pageable) {
        return userRepository.
                findAllByFirstNameContainingOrLastNameContainingOrNumeroTelephoneContainingOrCniContainingOrDateNaissanceContainingOrLoginContainingOrEmailContainingOrAddressContainingOrSexeContaining(mot, mot, mot, mot, mot, mot, mot, mot, mot, pageable);
    }

    @Override
    public Page<User> searchByFirstName (String firstName, Pageable pageable) {
        return userRepository.findAllByFirstNameContaining(firstName, pageable);
    }

    @Override
    public Page<User> searchByLastName (String lastName, Pageable pageable) {
        return userRepository.findAllByLastNameContaining(lastName, pageable);
    }

    @Override
    public Page<User> searchByPhone (String phone, Pageable pageable) {
        return userRepository.findAllByNumeroTelephoneContaining(phone, pageable);
    }

    @Override
    public Page<User> searchByAddress (String address, Pageable pageable) {
        return userRepository.findAllByAddressContaining(address, pageable);
    }

    @Override
    public Page<User> searchByCni (String cni, Pageable pageable) {
        return userRepository.findAllByCniContaining(cni, pageable);
    }

    @Override
    public Page<User> searchBySexe (String sexe, Pageable pageable) {
        return userRepository.findAllBySexe(sexe, pageable);
    }

    @Override
    public User searchByCompte (String login) {
        return userRepository.findOne(login);
    }


    @Transactional
    @Override
    public void deleteByGroupe (String groupe) {
        groupeRepository.findOne(groupe).getUserGroupes().forEach(userGroupe -> {
            userRepository.delete(userGroupe.getUser());
            userGroupeRepository.delete(userGroupe.getId());
        });
    }

    @Transactional
    @Override
    public void addUserInGroupe (String nomGroupe, String loginUser) {
        userGroupeRepository.save(new UserGroupe(userRepository.findOne(loginUser), groupeRepository.findOne(nomGroupe)));
    }


    @Transactional
    @Override
    public void addUserInGroupe (Collection<User> users, Groupe groupe) {
        users.forEach(user -> {
            userGroupeRepository.save(new UserGroupe(user, groupe));
        });
    }


}
