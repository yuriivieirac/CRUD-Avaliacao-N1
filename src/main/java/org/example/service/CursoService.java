package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Curso;
import org.example.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CursoService implements IService<Curso, Integer> {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Curso create(Curso entity) {
        return cursoRepository.save(entity);
    }

    @Override
    public Curso get(Integer id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElse(null);
    }

    @Override
    public List<Curso> get() {
        return cursoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Curso update(Integer id, Curso entity) {
        Curso cursoEncontrado = this.get(id);
        if (cursoEncontrado != null) {
            entity.setId(id);
            return cursoRepository.save(entity);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }
}
