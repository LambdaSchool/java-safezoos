package com.stepasha.zoo.services;

import com.stepasha.zoo.models.User;
import com.stepasha.zoo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//TODO 4 create a service
@Service(value = "securityUserService")
public class SecurityUserServiceImpl implements UserDetailsService {

    //TODO 4.1 get the user data
    @Autowired
    private UserRepository userrepos;
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepos.findByUsername(username.toLowerCase());
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername().toLowerCase(),
                user.getPassword(),
                user.getAuthority());
    }
}

