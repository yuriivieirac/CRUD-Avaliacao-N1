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
@Table(name = "DISCIPLINA")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private int codigo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "CARGA_HORARIA", nullable = false)
    private int cargaHoraria;

    @Column(name = "EMENTA")
    private String ementa;

    @Column(name = "BIBLIOGRAFIA")
    private String bibliografia;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;

    public static void exemploInicializacao() {
        Disciplina disciplina = Disciplina.builder()
                .codigo(123)
                .descricao("Descrição da Disciplina")
                .cargaHoraria(60)
                .ementa("Ementa da Disciplina")
                .bibliografia("Bibliografia da Disciplina")
                .ativo(true)
                .build();

        System.out.println(disciplina);
    }
}
