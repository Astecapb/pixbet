package br.com.robson.pixbet.services;

import br.com.robson.pixbet.models.Aposta;
import br.com.robson.pixbet.models.Sorteio;
import br.com.robson.pixbet.repositories.ApostaRepository;
import br.com.robson.pixbet.repositories.SorteioRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class SorteioService {

    private final SorteioRepository sorteioRepository;
    private final ApostaRepository apostaRepository;

    @Transactional
    public Sorteio criarSorteio() {
        Sorteio sorteio = Sorteio.builder()
                .numerosSorteados(gerarNumerosSorteados()) // Set já inicializado via @Builder.Default
                .finalizado(false)
                .build();
        return sorteioRepository.save(sorteio);
    }

    @Transactional
    public Sorteio finalizarSorteio(Long sorteioId) {
        Sorteio sorteio = sorteioRepository.findById(sorteioId)
                .orElseThrow(() -> new RuntimeException("Sorteio não encontrado"));
        sorteio.setFinalizado(true);
        return sorteioRepository.save(sorteio);
    }

    public List<Aposta> buscarVencedores(Long sorteioId) {
        Sorteio sorteio = sorteioRepository.findById(sorteioId)
                .orElseThrow(() -> new RuntimeException("Sorteio não encontrado"));

        // Evita NPE caso o Set esteja null (não ocorre com @Builder.Default)
        Set<Integer> sorteados = sorteio.getNumerosSorteados();
        if (sorteados == null || sorteados.isEmpty()) {
            return List.of();
        }

        return apostaRepository.findApostasVencedoras(
                sorteioId,
                new ArrayList<>(sorteados)
        );
    }

    private Set<Integer> gerarNumerosSorteados() {
        Random random = new Random();
        Set<Integer> numeros = new LinkedHashSet<>();
        while (numeros.size() < 6) {
            numeros.add(random.nextInt(60) + 1);
        }
        return numeros;
    }

    public List<Sorteio> listarTodos() {
        return sorteioRepository.findAll();
    }
}