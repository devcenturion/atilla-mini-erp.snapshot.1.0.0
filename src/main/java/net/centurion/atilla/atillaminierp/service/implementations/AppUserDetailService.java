package net.centurion.atilla.atillaminierp.service.implementations;

import net.centurion.atilla.atillaminierp.entities.AppUserDetails;
import net.centurion.atilla.atillaminierp.entities.User;
import net.centurion.atilla.atillaminierp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailService implements UserDetailsService{

    public User user = new User();
    @Autowired
    private UserRepository userRepository;

    public User getUser ( ) {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }


    @Override
    public UserDetails loadUserByUsername (String login) throws UsernameNotFoundException {
        user = userRepository.findOne(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("login[%s] inexistant ", login));
        }

        return new AppUserDetails(user, userRepository);

    }

}
