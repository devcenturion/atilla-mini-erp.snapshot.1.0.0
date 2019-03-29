
package net.centurion.atilla.atillaminierp.security;


import net.centurion.atilla.atillaminierp.repository.GroupeRepository;
import net.centurion.atilla.atillaminierp.repository.UserRepository;
import net.centurion.atilla.atillaminierp.service.implementations.AppUserDetailService;
import net.centurion.atilla.atillaminierp.service.implementations.GroupeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AppUserDetailService appUserDetailService;

    @Autowired
    private GroupeService groupeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupeRepository groupeRepository;


    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure (HttpSecurity http) throws Exception {
/*        // CSRF
        http.csrf().disable();

        http.httpBasic();*/

        groupeRepository.findAll().forEach(groupe -> {
            try {
                http.authorizeRequests().antMatchers(groupeService.getMachers(groupe.getNom())).hasAnyRole(groupeService.getRole(groupe.getNom()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        http.formLogin().loginPage("/login");
    }
}