package net.centurion.atilla.atillaminierp.contoller;

import net.centurion.atilla.atillaminierp.entities.Groupe;
import net.centurion.atilla.atillaminierp.repository.GroupeRepository;
import net.centurion.atilla.atillaminierp.service.implementations.GroupeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


/**
 * @author CrunchDroid
 */
@RestController
public class HomeController{

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private GroupeService groupeService;

    @GetMapping("/plain-page")
    public String plainPage ( ) {
        return "plain-page";
    }

    @GetMapping("/pricing-tables")
    public String pricingTables ( ) {
        return "pricing-tables";
    }


    @GetMapping("/home")
    public String home ( ) {

        return "plain-page";
    }


    @GetMapping("/test")
    public Collection<Groupe> test ( ) {

        groupeService.search("a", new PageRequest(0, 5)).forEach(groupe -> {
            System.out.println(groupe.getNom());
            System.out.println(groupe.getDateCreationGroupe());
            System.out.println(groupe.getDescription());
        });

        return groupeService.listGroupes();
    }


}
