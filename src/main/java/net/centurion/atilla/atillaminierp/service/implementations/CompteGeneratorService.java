package net.centurion.atilla.atillaminierp.service.implementations;/*
package net.devcenturion.minierpatilla.service;

import net.devcenturion.minierpatilla.entities.Roles;
import net.devcenturion.minierpatilla.entities.User;
import net.devcenturion.minierpatilla.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CompteGeneratorService{

    @Autowired
    private CompteRepository compteRepository ;

    @Autowired
    private RolesRepository rolesRepository ;

    public String passGenerator (int taille) {
       String caractere[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" , "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "Ì", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        String string = "";

        int alea;


        for (int i = 0; i < taille; i++) {

            alea =  (int) (Math.random() * (caractere.length) );

            string = string + caractere[alea];
        }
        return string;
    }

    public String loginGenerator (int taille) {
        String caractere[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "Ì", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        String string = "";

        int alea;

        for (int i = 0; i < taille; i++) {

            alea = (int) (Math.random() * (caractere.length) );

            string = string + caractere[alea];
        }
        return string;
    }

    public Compte createCompte(User user){
        Roles roles1 = new Roles(""+user.getIdUser());
        rolesRepository.save(roles1);

        Collection<Roles> roles = new ArrayList<Roles>() ;
        roles.add(roles1);

        return compteRepository.save(new Compte(user.getEmail(),passGenerator(8) ,true ,roles,user) );
    }

}*/
