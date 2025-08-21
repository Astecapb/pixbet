package br.com.robson.pixbet.controllers;

import br.com.robson.pixbet.models.Usuario;
import br.com.robson.pixbet.repositories.UsuarioRepository;
import br.com.robson.pixbet.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Criar novo usuário
    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario novo = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    // Buscar por e-mail
    @GetMapping("/email/{email}")
    public Usuario buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email);
    }
}