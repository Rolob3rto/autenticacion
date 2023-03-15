package com.roberto.autenticacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.autenticacion.model.Usuario;
import com.roberto.autenticacion.services.Impl.UsuarioService;


@RestController
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @RequestMapping("/buscar")
    Usuario findByusername(@RequestParam String username, @RequestParam String password) {
        return service.findByusername(username, password);
    }
}
