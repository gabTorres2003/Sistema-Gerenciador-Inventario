package com.inventario.proxy;

import com.inventario.model.Usuario;
import com.inventario.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsuarioServiceProxy implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceProxy.class);

    private final UsuarioService realService;

    public UsuarioServiceProxy(@Qualifier("usuarioServiceImpl") UsuarioService realService) {
        this.realService = realService;
    }

    @Override
    public void salvar(Usuario usuario) {
        logger.info("Iniciando validação do usuário antes de salvar...");

        if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome completo é obrigatório.");
        }

        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().length() < 4) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 4 caracteres.");
        }

        if (usuario.getDepartamento() == null || usuario.getDepartamento().trim().isEmpty()) {
            throw new IllegalArgumentException("Departamento é obrigatório.");
        }

        logger.info("Usuário validado com sucesso. Salvando: {}", usuario.getEmail());
        realService.salvar(usuario);
        logger.info("Usuário salvo com sucesso.");
    }

    @Override
    public Usuario buscarPorId(int id) {
        logger.info("Buscando usuário por ID: {}", id);
        return realService.buscarPorId(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        logger.info("Listando todos os usuários...");
        return realService.listarTodos();
    }

    @Override
    public void deletar(Usuario usuario) {
        logger.info("Deletando usuário: {}", usuario.getEmail());
        realService.deletar(usuario);
        logger.info("Usuário deletado com sucesso.");
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        logger.info("Buscando usuário por email: {}", email);
        return realService.buscarPorEmail(email);
    }
}

