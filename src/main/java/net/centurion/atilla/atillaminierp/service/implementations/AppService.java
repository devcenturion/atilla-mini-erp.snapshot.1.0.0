package net.centurion.atilla.atillaminierp.service.implementations;

import net.centurion.atilla.atillaminierp.repository.UserRepository;
import net.centurion.atilla.atillaminierp.service.interfaces.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService implements IAppService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public String passGenerator (int taille) {
        String caractere[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "Ì", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        String string = "";

        int alea;


        for (int i = 0; i < taille; i++) {

            alea = (int) (Math.random() * (caractere.length));

            string = string + caractere[alea];
        }
        return string;
    }


}
