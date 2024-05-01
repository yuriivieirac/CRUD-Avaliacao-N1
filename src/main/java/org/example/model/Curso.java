package org.example.model;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private Integer codigo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;

    public static void exemploBuilder() {
        Curso curso = Curso.builder()
                .codigo(123)
                .descricao("Descrição do Curso")
                .ativo(true)
                .build();
        System.out.println(curso);
    }
}
