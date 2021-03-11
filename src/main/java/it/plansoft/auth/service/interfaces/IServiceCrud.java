package it.plansoft.auth.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IServiceCrud<MODEL, ID> {

    /**
     * recupero tutti gli oggetti
     *
     * @return
     */
    public List<MODEL> getAll();

    /**
     * recupro un singolo oggetto
     *
     * @return
     */
    public Optional<MODEL> getById(ID id);

    /**
     * salvataggio entity
     *
     * @param entity
     * @return
     */
    public MODEL save(MODEL entity);

    /**
     * aggiornamento entity
     *
     * @param entity
     * @return
     */
    public MODEL update(MODEL entity);

    /**
     * cancellazione entity
     *
     * @param entity
     */
    public void delete(MODEL entity);

    /**
     * cancellazione entity
     *
     * @param entity
     */
    public void deleteById(ID id);
}