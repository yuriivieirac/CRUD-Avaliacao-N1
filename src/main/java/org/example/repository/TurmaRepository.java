package org.example.repository;

import java.util.Optional;

import org.example.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    default Turma get(Integer id) {
        Optional<Turma> turmaOptional = findById(id);
        return turmaOptional.orElse(null);
    }

    /**
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    default boolean delete(Integer id) {
        if (existsById(id)) {
       
            return true; // Indica que a exclusão foi bem-sucedida
        } else {
            return false; // Indica que não foi possível encontrar a turma com o ID fornecido
        }
    }

}
