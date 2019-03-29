package net.centurion.atilla.atillaminierp.entities;


import net.centurion.atilla.atillaminierp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDetails implements UserDetails{
    private User user;
    private UserRepository userRepository;

    public AppUserDetails (User user, UserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }

    public AppUserDetails ( ) {
        super();
    }

    public User getUser ( ) {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities ( ) {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        userRepository.findOne(user.getLogin()).getUserGroupes().forEach(userGroupe -> {

            authorities.add(new SimpleGrantedAuthority(userGroupe.getGroupe().getNom()));
        });

        return authorities;
    }


    @Override
    public String getPassword ( ) {
        return user.getPassword();
    }

    @Override
    public String getUsername ( ) {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked ( ) {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isEnabled ( ) {
        return user.getActived();
    }
}
