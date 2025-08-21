package br.com.robson.pixbet.controllers;

import br.com.robson.pixbet.models.Aposta;
import br.com.robson.pixbet.models.Sorteio;
import br.com.robson.pixbet.services.SorteioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sorteios")
@RequiredArgsConstructor
public class SorteioController {

    private final SorteioService sorteioService;

    @PostMapping
    public ResponseEntity<Sorteio> criar() {
        Sorteio sorteio = sorteioService.criarSorteio();
        return ResponseEntity.status(HttpStatus.CREATED).body(sorteio);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Sorteio> finalizar(@PathVariable Long id) {
        Sorteio sorteio = sorteioService.finalizarSorteio(id);
        return ResponseEntity.ok(sorteio);
    }

    @GetMapping
    public ResponseEntity<List<Sorteio>> listar() {
        return ResponseEntity.ok(sorteioService.listarTodos());
    }

    @GetMapping("/{id}/vencedores")
    public ResponseEntity<List<Aposta>> buscarVencedores(@PathVariable Long id) {
        return ResponseEntity.ok(sorteioService.buscarVencedores(id));
    }
}