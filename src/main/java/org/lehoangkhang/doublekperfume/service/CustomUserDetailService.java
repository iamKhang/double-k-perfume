package org.lehoangkhang.doublekperfume.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lehoangkhang.doublekperfume.entity.CustomUserDetail;
import org.lehoangkhang.doublekperfume.entity.Role;
import org.lehoangkhang.doublekperfume.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        Role role = user.getRole();

            authorities.add(new SimpleGrantedAuthority(role.getName()));


        return new CustomUserDetail(user, authorities);
    }

}