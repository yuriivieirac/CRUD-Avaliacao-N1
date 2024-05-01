package org.example.model;

import lombok.*;

import org.example.service.TurmaService;
import org.springframework.transaction.annotation.Transactional;

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
@Table(name = "TURMA")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ANO", nullable = false)
    private int ano;

    @Column(name = "SEMESTRE", nullable = false)
    private int semestre;

    @Column(name = "DIA_SEMANA", nullable = false)
    private int diaSemana;

    @Column(name = "HORARIOS")
    private String horarios;

    /**
     * Método de exemplo para demonstrar o uso do builder do Lombok.
     * Isso não deve ser usado como lógica de negócio real.
     */
    public static void exemploBuilder() {
        Turma turma = Turma.builder()
                .ano(2024)
                .semestre(1)
                .diaSemana(3)
                .horarios("Segunda e Quarta, 8:00 - 10:00")
                .build();

        System.out.println(turma);
    }

    @Transactional(rollbackFor = Exception.class)
    public Turma update(Integer id, TurmaService turmaService) {
        Turma turmaEncontrada = turmaService.turmaRepository.get(id);
        if (turmaEncontrada != null) {
            setId(id);
            return turmaService.turmaRepository.save(this);
        } else {
            return null;
        }
    }

    // Outros métodos, getters e setters conforme necessário
}
