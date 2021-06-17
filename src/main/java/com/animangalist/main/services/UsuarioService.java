package com.animangalist.main.services;

import com.animangalist.main.entity.UsuarioEntity;
import com.animangalist.main.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarUsuario(UsuarioEntity user){
        this.usuarioRepository.save(user);
    }

    public UsuarioEntity buscarUsuarioPorId(Long id) throws Exception {
       return this.usuarioRepository.findById(id)
               .orElseThrow(() -> new Exception("Não foi possível encontrar usuário por ID"));
    }

    public void deletarUsuarioPorId(Long id){
        this.usuarioRepository.deleteById(id);
    }

    public void editarUsuario(UsuarioEntity usuarioNovo, Long id) throws Exception {
        UsuarioEntity dadosAntigos = this.buscarUsuarioPorId(id);
        dadosAntigos.setEmail(usuarioNovo.getEmail());
        dadosAntigos.setName(usuarioNovo.getName());
        dadosAntigos.setUsername(usuarioNovo.getUsername());
        this.usuarioRepository.save(dadosAntigos);
    }
}
