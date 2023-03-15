package com.roberto.autenticacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberto.autenticacion.model.Permiso;



@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{
    
}

