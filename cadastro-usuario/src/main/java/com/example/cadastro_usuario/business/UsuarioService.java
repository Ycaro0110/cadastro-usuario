package com.example.cadastro_usuario.business;

import com.example.cadastro_usuario.infrastructure.entitys.Usuario;
import com.example.cadastro_usuario.infrastructure.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("email não encontrado"));

    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioporId(Long id, Usuario usuario) {
        Usuario usuarioAnterior = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("usuario nao encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioAnterior.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioAnterior.getNome())
                .id(usuarioAnterior.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }
}
