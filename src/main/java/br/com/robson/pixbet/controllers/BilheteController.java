package br.com.robson.pixbet.controllers;

import br.com.robson.pixbet.models.Bilhete;
import br.com.robson.pixbet.services.BilheteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bilhetes")
@RequiredArgsConstructor
public class BilheteController {

    private final BilheteService bilheteService;

    @PostMapping
    public Bilhete criar(@RequestParam Long usuarioId,
                         @RequestBody List<Integer> numeros) {
        return bilheteService.criarBilhete(usuarioId, numeros);
    }

    @GetMapping
    public List<Bilhete> listar() {
        return bilheteService.listarTodos();
    }
}