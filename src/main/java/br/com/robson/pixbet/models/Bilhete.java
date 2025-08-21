package br.com.robson.pixbet.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_bilhete")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Bilhete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorteio_id")
    private Sorteio sorteio;

    @OneToMany(mappedBy = "bilhete", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Aposta> apostas = new ArrayList<>();

    private BigDecimal valorTotal;

    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Builder.Default
    private Boolean premiado = false;
}