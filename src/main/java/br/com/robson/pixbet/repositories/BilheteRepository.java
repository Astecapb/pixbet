package br.com.robson.pixbet.repositories;

import br.com.robson.pixbet.models.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
    List<Bilhete> findByUsuarioId(Long usuarioId);
}