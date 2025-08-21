package br.com.robson.pixbet.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_aposta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bilhete_id")
    private Bilhete bilhete;

    private Integer numeroEscolhido;

    @Builder.Default
    private Boolean vencedora = false;
}