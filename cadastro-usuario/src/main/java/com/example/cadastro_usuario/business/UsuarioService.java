package com.example.cadastro_usuario.business;

import com.example.cadastro_usuario.infrastructure.entitys.Usuario;
import com.example.cadastro_usuario.infrastructure.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Usuario usuario) {
        if (usuario.getNome() == null) {
            throw new RuntimeException("nome obrigatorio");
        }
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

      public List<Usuario> listarUsuarios(){
        
        return usuarioRepository.findAll();
     }
}
