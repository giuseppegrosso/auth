package it.plansoft.auth.controller.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller.interfaces */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudDtoController<DTO, ID> {

    ResponseEntity<List<DTO>> findAll();

    ResponseEntity<Page<DTO>> findAll(Pageable pageable);

    ResponseEntity<DTO> findById(ID id);

    ResponseEntity<DTO> save(DTO model);

    ResponseEntity<List<DTO>> saveAll(List<DTO> model);

    ResponseEntity<DTO> delete(DTO model);

    ResponseEntity<DTO> deleteById(ID id);

    ResponseEntity<DTO> update(DTO model);


}
