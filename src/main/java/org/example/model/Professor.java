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
@Table(name = "PROFESSOR")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "TITULACAO_MAXIMA")
    private String titulacaoMaxima;

    /**
     * Método de exemplo para demonstrar o uso do builder do Lombok.
     * Isso não deve ser usado como lógica de negócio real.
     */
    public static void exemploBuilder() {
        Professor professor = Professor.builder()
                .nome("Maria")
                .endereco("Rua B, 456")
                .telefone("987654321")
                .titulacaoMaxima("Doutorado")
                .build();

        System.out.println(professor);
    }

    // Outros métodos, getters e setters conforme necessário
}
