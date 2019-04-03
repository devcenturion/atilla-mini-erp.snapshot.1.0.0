package net.centurion.atilla.atillaminierp.contoller.User;

import net.centurion.atilla.atillaminierp.entities.User;
import net.centurion.atilla.atillaminierp.repository.UserRepository;
import net.centurion.atilla.atillaminierp.service.implementations.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /////////////////////////////////////////////ADD USER///////////////////////////////////

    @RequestMapping("/formAddUser")
    public String formAddUser ( ) {

        return "formAddUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser (Model model,
                           @RequestParam(name = "login", defaultValue = "") String login,
                           @RequestParam(name = "firstName", defaultValue = "") String firstName,
                           @RequestParam(name = "lastName", defaultValue = "") String lastName,
                           @RequestParam(name = "numeroTelephone", defaultValue = "") String numeroTelephone,
                           @RequestParam(name = "address", defaultValue = "") String address,
                           @RequestParam(name = "actived", defaultValue = "1") Boolean actived,
                           @RequestParam(name = "urlPhoto", defaultValue = "") String urlPhoto,
                           @RequestParam(name = "dateNaissance", defaultValue = "") String dateNaissance,
                           @RequestParam(name = "cni", defaultValue = "") String cni,
                           @RequestParam(name = "sexe", defaultValue = "") String sexe,
                           @RequestParam(name = "email", defaultValue = "") String email
    ) {
        Date date = new Date(dateNaissance);
        User user = new User(login, null, firstName, lastName, numeroTelephone, address, actived, urlPhoto, date, cni, sexe, email, null);
        userService.save(user);

        user = userRepository.findOne(login);

        if (!user.equals(null)) {
            model.addAttribute("user", user);
            model.addAttribute("msg", "le nouvel utilisateur a ete enregistre avec success");
        } else model.addAttribute("msg", "echec de l'enregistrement ");

        return "addUser";
    }


/////////////////////////////////////UPDATE/////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/formUpdateUser")
    public String formUpdateUser ( ) {

        return "formUpdateUser";
    }

    /////////////////////////////////////////////CHANGEPASS//////////////////////////////////////////////////////////////////////////
    @RequestMapping("/formUpdatePass")
    public String formUpdatePass ( ) {

        return "formUpdatePass";
    }

    @RequestMapping(value = "/updatePass", method = RequestMethod.GET)
    public String updatePass (Model model,
                              @RequestParam(name = "login", defaultValue = "") String login,
                              @RequestParam(name = "oldPass", defaultValue = "") String odlPass,
                              @RequestParam(name = "newPass", defaultValue = "") String newPass
    ) {
        userService.changePassCompte(login, odlPass, newPass);
        model.addAttribute(userRepository.findOne(login));
        return "updatePass";
    }

    @RequestMapping(value = "/add")
    public void add ( ) {

    }

}