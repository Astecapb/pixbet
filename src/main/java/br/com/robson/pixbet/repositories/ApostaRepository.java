package br.com.robson.pixbet.repositories;

import br.com.robson.pixbet.models.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    @Query("SELECT a FROM Aposta a " +
            "JOIN a.bilhete b " +
            "WHERE b.sorteio.id = :sorteioId " +
            "AND a.numeroEscolhido IN :numeros")
    List<Aposta> findApostasVencedoras(@Param("sorteioId") Long sorteioId,
                                       @Param("numeros") List<Integer> numeros);
}