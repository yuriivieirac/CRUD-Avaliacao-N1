package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.Disciplina;
import org.example.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Para habilitar o uso de logs
@RestController
@RequestMapping("api/v1/disciplina")
public class DisciplinaResource implements IResource<Disciplina, Integer> {

    @Autowired
    private DisciplinaService disciplinaService;

    @Override
    public Disciplina create(@RequestBody Disciplina entity) {
        log.info("Criando uma nova disciplina: {}", entity);
        return disciplinaService.create(entity);
    }

    @Override
    public Disciplina get(@PathVariable Integer id) {
        log.info("Recuperando disciplina com ID: {}", id);
        return disciplinaService.get(id);
    }

    @Override
    public List<Disciplina> get() {
        log.info("Recuperando todas as disciplinas");
        return disciplinaService.get();
    }

    @Override
    public Disciplina update(@PathVariable Integer id, @RequestBody Disciplina entity) {
        log.info("Atualizando disciplina com ID {}: {}", id, entity);
        return disciplinaService.update(id, entity);
    }

    @Override
    public void delete(@PathVariable Integer id) {
        log.info("Deletando disciplina com ID: {}", id);
        disciplinaService.delete(id);
    }
}
