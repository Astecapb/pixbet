package br.com.robson.pixbet.services;

import br.com.robson.pixbet.models.Aposta;
import br.com.robson.pixbet.models.Bilhete;
import br.com.robson.pixbet.models.Usuario;
import br.com.robson.pixbet.repositories.BilheteRepository;
import br.com.robson.pixbet.repositories.UsuarioRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter

public class BilheteService {

    private final BilheteRepository bilheteRepository;
    private final UsuarioRepository usuarioRepository;

    public Bilhete criarBilhete(Long usuarioId, List<Integer> numeros) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Bilhete bilhete = Bilhete.builder()
                .usuario(usuario)
                .valorTotal(BigDecimal.valueOf(numeros.size() * 5.0))
                .apostas(new ArrayList<>())
                .build();

        numeros.forEach(n -> bilhete.getApostas().add(
                Aposta.builder()
                        .bilhete(bilhete)
                        .numeroEscolhido(n)
                        .vencedora(false)
                        .build()));

        return bilheteRepository.save(bilhete);
    }

    public List<Bilhete> listarTodos() {
        return bilheteRepository.findAll();
    }
}