package br.com.robson.pixbet.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
}