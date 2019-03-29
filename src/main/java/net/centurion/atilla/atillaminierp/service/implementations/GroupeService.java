package net.centurion.atilla.atillaminierp.service.implementations;


import net.centurion.atilla.atillaminierp.entities.*;
import net.centurion.atilla.atillaminierp.repository.*;
import net.centurion.atilla.atillaminierp.service.interfaces.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class GroupeService implements IGroupeService{
    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private UserGroupeRepository userGroupeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActionRepository actionRepository;


    @Transactional
    @Override
    public String[] getRoles ( ) {
        Collection<Groupe> groupes = new ArrayList<>();
        groupes = (Collection<Groupe>) groupeRepository.findAll();

        int taille = groupes.size();
        String roles[] = new String[taille];

        for (int i = 0; i < taille; i++) {
            roles[i] = ((ArrayList<Groupe>) groupes).get(i).getNom();
        }

        return roles;
    }

    @Override
    public String getRole (String roles) {
        return groupeRepository.findOne(roles).getNom();
    }

    @Transactional
    @Override
    public String[] getMachers (String groupe) {

        Collection<Action> actions = new ArrayList<Action>();

        groupeRepository.findOne(groupe).getGroupeActions().forEach(groupeAction -> {
            actions.add(groupeAction.getAction());
        });

        int taille = actions.size();
        String machers[] = new String[taille];

        for (int i = 0; i < taille; i++) {
            machers[i] = ((ArrayList<Action>) actions).get(i).getUrl();
        }
        return machers;
    }

    @Transactional
    @Override
    public Collection<User> getUser (String nom) {
        Collection<User> users = new ArrayList<User>();

        groupeRepository.findOne(nom).getUserGroupes().forEach(userGroupe -> {
            users.add(userGroupe.getUser());
        });
        return users;
    }

    @Override
    public Page<Groupe> search (String mot, Pageable pageable) {
        return groupeRepository.findByNomContainingOrDescriptionContaining(mot, mot, pageable);
    }

    @Override
    public void save (Groupe groupe) {
        groupeRepository.save(groupe);
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

    @Transactional
    @Override
    public Collection<User> getGroupeUser (Groupe groupe) {
        Collection<User> users = new ArrayList<User>();
        groupeRepository.findOne(groupe.getNom()).getUserGroupes().forEach(e -> {
            users.add(e.getUser());
        });
        return users;
    }

    @Transactional
    @Override
    public void removeUserInGroupe (String idGroupe, String idUser) {
        User user = userRepository.findOne(idUser);
        Groupe groupe = groupeRepository.findOne(idGroupe);

        UserGroupe userGroupe = userGroupeRepository.findByGroupeAndUser(groupe, user);
        userGroupeRepository.delete(userGroupe);
    }

    @Override
    public void removeUserInGroupe (Collection<User> users, Groupe groupe) {
        users.forEach(user -> {

            UserGroupe userGroupe = userGroupeRepository.findByGroupeAndUser(groupe, user);
            userGroupeRepository.delete(userGroupe);
        });
    }

    @Override
    public Collection<Groupe> listGroupes ( ) {
        return (Collection<Groupe>) groupeRepository.findAll();
    }

}
