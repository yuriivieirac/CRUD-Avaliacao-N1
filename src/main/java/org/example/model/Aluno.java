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
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "MATRICULA", nullable = false, unique = true)
    private String matricula;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    private String endereco;

    private String telefone;

    @Column(name = "SITUACAO", nullable = false)
    private String situacao;

    private boolean ativo;

    public void matricularCurso() {
        // Lógica para matricular o aluno em um curso
    }

    public void trancar() {
        // Lógica para trancar a matrícula do aluno
    }

    public void formar() {
        // Lógica para marcar o aluno como formado
    }

    public void evadir() {
        // Lógica para marcar o aluno como evadido
    }

    public void obterAvaliacoes() {
        // Lógica para obter as avaliações do aluno
    }

    public void emitirHistorico() {
        // Lógica para emitir o histórico do aluno
    }
}
