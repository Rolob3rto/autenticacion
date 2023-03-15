package com.roberto.autenticacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberto.autenticacion.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByName(String name);
}
