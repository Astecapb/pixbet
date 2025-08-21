package br.com.robson.pixbet.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "tb_sorteio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Sorteio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private LocalDate data = LocalDate.now();

    @ElementCollection
    @CollectionTable(name = "tb_sorteio_numeros", joinColumns = @JoinColumn(name = "sorteio_id"))
    @Column(name = "numero")
    @Builder.Default
    private Set<Integer> numerosSorteados = new LinkedHashSet<>();

    @Builder.Default
    private Boolean finalizado = false;
}