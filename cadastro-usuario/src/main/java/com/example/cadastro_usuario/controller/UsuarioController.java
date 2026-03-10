package com.example.cadastro_usuario.controller;

import com.example.cadastro_usuario.business.UsuarioService;
import com.example.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam("email") String email){

        usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam("email") String email){

        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Long id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioporId(id, usuario);
        return ResponseEntity.ok().build();
    }


}
