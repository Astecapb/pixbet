package br.com.robson.pixbet.repositories;

import br.com.robson.pixbet.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    // findAll() já é herdado de JpaRepository
}