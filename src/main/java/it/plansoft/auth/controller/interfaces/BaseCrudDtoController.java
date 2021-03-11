package it.plansoft.auth.controller.interfaces;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.auth.mapper.IMapper;
import it.plansoft.auth.model.BaseId;
import it.plansoft.auth.service.interfaces.BaseCrudDtoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseCrudDtoController<
        SERVICE extends BaseCrudDtoService,
        REPOSITORY extends JpaRepository<MODEL, ID>,
        MAPPER extends IMapper<DTO, MODEL>,
        DTO extends BaseId<ID>,
        MODEL extends BaseId<ID>,
        ID>
        implements ICrudDtoController<DTO, ID> {

    protected SERVICE service;

    public BaseCrudDtoController(SERVICE service) {
        this.service = service;
    }

    // ?page=0&size=2&sort=createdAt,desc
    @GetMapping("/paged")
    public ResponseEntity<Page<DTO>> findAll(Pageable pageable) {
        Page<DTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<DTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        return ResponseEntity.ok((DTO) service.findById(id));
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<DTO> save(@RequestBody DTO model) {
        return ResponseEntity.ok((DTO) service.save(model));
    }

    @Override
    @PostMapping("/addAll")
    public ResponseEntity<List<DTO>> saveAll(@RequestBody List<DTO> model) {
        return ResponseEntity.ok(service.saveAll(model));
    }

    @Override
    @DeleteMapping("/")
    public ResponseEntity<DTO> delete(DTO model) {
        DTO m = (DTO) service.findById(model.getId());

        if (m != null)
            service.delete(model);

        return ResponseEntity.ok(m);
    }

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<DTO> deleteById(@PathVariable ID id) {
        DTO m = (DTO) service.findById(id);

        if (m != null)
            service.deleteById(id);

        return ResponseEntity.ok(m);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<DTO> update(@RequestBody DTO model) {
        return ResponseEntity.ok((DTO) service.save(model));
    }
}