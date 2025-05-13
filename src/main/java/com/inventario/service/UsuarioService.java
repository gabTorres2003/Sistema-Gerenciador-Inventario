package com.inventario.service;

import com.inventario.model.Usuario;

import java.util.List;

public interface UsuarioService {

    void salvar(Usuario usuario);

    Usuario buscarPorId(int id);

    List<Usuario> listarTodos();

    void deletar(Usuario usuario);

    Usuario buscarPorEmail(String email); // opcional para login

}
