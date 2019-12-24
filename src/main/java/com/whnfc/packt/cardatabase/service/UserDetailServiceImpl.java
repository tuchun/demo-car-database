package com.whnfc.packt.cardatabase.service;

import com.whnfc.packt.cardatabase.domain.User;
import com.whnfc.packt.cardatabase.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author tuchun
 * @version 2019-12-16
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User currentUser = userRepository.findByUsername(username);
        UserDetails ud = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));

        return ud;
    }
}
