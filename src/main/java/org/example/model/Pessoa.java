package org.example.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;

    /**
     * Método de exemplo para demonstrar a inicialização de uma pessoa.
     * Isso não deve ser usado como lógica de negócio real.
     */
    public static void exemploInicializacao() {
        Pessoa pessoa = Pessoa.builder()
                .nome("João")
                .endereco("Rua A, 123")
                .telefone("123456789")
                .build();

        System.out.println(pessoa);
    }

    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Outros métodos, getters e setters conforme necessário
}
