package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Turma;
import org.example.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TurmaService implements IService<Turma, Long> {

    @Autowired
    public TurmaRepository turmaRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Turma create(Turma entity) {
        return turmaRepository.save(entity);
    }

    @Override
    public List<Turma> get() {
        return turmaRepository.findAll();
    }

    public static org.slf4j.Logger getLog() {
        return log;
    }

    public TurmaRepository getTurmaRepository() {
        return turmaRepository;
    }

    public void setTurmaRepository(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Turma get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Turma update(Long id, Turma entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
