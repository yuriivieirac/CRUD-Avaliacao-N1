package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PessoaService implements IService<Pessoa, Long> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pessoa create(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    @Override
    public Pessoa get(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        return pessoaOptional.orElse(null);
    }

    @Override
    public List<Pessoa> get() {
        return pessoaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pessoa update(Long id, Pessoa entity) {
        Pessoa pessoaEncontrada = this.get(id);
        if (pessoaEncontrada != null) {
            entity.setId(id);
            return pessoaRepository.save(entity);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
