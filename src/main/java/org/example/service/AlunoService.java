package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Aluno;
import org.example.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class AlunoService implements IService<Aluno, Integer> {

    @Autowired //injeção de dependência
    private AlunoRepository alunoRepository;

    /**
     * Método para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Aluno create(Aluno entity) {
        return alunoRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Aluno get(Integer id) {
        Optional<Aluno> alunoEncontrado = alunoRepository.findById(id);
        return alunoEncontrado.orElse(null);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Aluno> get() {
        return alunoRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Aluno update(Integer id, Aluno entity) {
        Aluno alunoEncontrado = this.get(id);

        if (alunoEncontrado != null) {
            // Garante que o ID seja definido corretamente
            entity.setId(id);
            return alunoRepository.save(entity);
        } else {
            return null; // Retornar null se não encontrar o aluno pode ser uma opção, dependendo do contexto do seu aplicativo
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        alunoRepository.deleteById(id);
    }
}
