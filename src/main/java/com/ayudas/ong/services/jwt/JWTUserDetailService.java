package com.ayudas.ong.services.jwt;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayudas.ong.repositories.DirectorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

        @Autowired
        private final DirectorRepository directorRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                System.out.println(this.directorRepository.findByEmail(username).get().toString());
                return this.directorRepository.findByEmail(username)
                                .map(usuario -> {
                                        System.out.println("Usuario: : " + usuario.toString());
                                        Set<GrantedAuthority> authorities = new HashSet<>();
                                        authorities.add(new SimpleGrantedAuthority(
                                                        usuario.getRol().getNombre().name()));
                                        System.out.println("auth: " + authorities.toString());
                                        return new User(usuario.getEmail(), usuario.getPassWord(), authorities);
                                })
                                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));
        }
}
