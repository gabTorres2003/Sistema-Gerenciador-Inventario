package com.inventario.repository;

import com.inventario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
