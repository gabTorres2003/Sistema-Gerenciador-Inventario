package com.inventario.proxy;

import com.inventario.model.Usuario;
import com.inventario.service.UsuarioService;

import java.util.List;

public class UsuarioServiceProxy implements UsuarioService {

    private final UsuarioService realService;

    public UsuarioServiceProxy(UsuarioService realService) {
        this.realService = realService;
    }

    @Override
    public void salvar(Usuario usuario) {
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 4) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 4 caracteres");
        }
        realService.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(int id) {
        return realService.buscarPorId(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return realService.listarTodos();
    }

    @Override
    public void deletar(Usuario usuario) {
        realService.deletar(usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEmail'");
    }

   
}