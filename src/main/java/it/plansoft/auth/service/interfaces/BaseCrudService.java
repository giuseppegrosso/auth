package it.plansoft.auth.service.interfaces;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * classe di implementazione delle operazioni di base.
 */
@Slf4j
@AllArgsConstructor
public class BaseCrudService<REPOSITORY extends JpaRepository<MODEL, ID>, MODEL, ID> implements IServiceCrud<MODEL, ID> {

    protected JpaRepository<MODEL, ID> repo;

    @Override
    public List<MODEL> getAll() {
        List<MODEL> t = repo.findAll();
        log.info("fetch data {} ", t);

        return t;
    }

    @Override
    public Optional<MODEL> getById(ID id) {
        Optional<MODEL> t = repo.findById(id);
        log.info("fetch data {} ", t);

        return t;
    }

    @Override
    public MODEL save(MODEL entity) {
        return repo.save(entity);
    }

    @Override
    public MODEL update(MODEL entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(MODEL entity) {
        repo.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        repo.deleteById(id);
    }
}