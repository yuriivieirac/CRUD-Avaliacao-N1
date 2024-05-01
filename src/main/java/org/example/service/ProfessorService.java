package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Professor;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProfessorService implements IService<Professor, Integer> {

    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Professor create(Professor entity) {
        return professorRepository.save(entity);
    }

    @Override
    public Professor get(Integer id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Professor> get() {
        return professorRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Professor update(Integer id, Professor entity) {
        Professor professorEncontrado = this.get(id);
        if (professorEncontrado != null) {
            entity.setId(id);
            return professorRepository.save(entity);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        professorRepository.deleteById(id);
    }
}
