package com.roberto.autenticacion.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.autenticacion.model.Usuario;
import com.roberto.autenticacion.repositories.UsuarioRepository;



@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public Usuario findByusername(String username, String password) {
        return repository.findByNameAndPassword(username, password);
    }
}
