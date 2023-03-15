package com.roberto.autenticacion.services.Impl;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roberto.autenticacion.model.Permiso;
import com.roberto.autenticacion.model.Usuario;
import com.roberto.autenticacion.repositories.UsuarioRepository;



@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository repository;

    public Usuario findByusername(String username) {
        return repository.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = repository.findByName(username);        

        List<Permiso> permisos = usuario.getPermisos();
        List<GrantedAuthority> permisosNombres = new ArrayList<>();

        for (Permiso permission : permisos) {            
            permisosNombres.add(new SimpleGrantedAuthority(permission.getNombre()));
        }
        
        UserDetails user = org.springframework.security.core.userdetails.User.builder()        
            .username(usuario.getName())
            .password(usuario.getPassword())     
            .authorities(permisosNombres)
            .build();
    

        return  user;
    }
}
