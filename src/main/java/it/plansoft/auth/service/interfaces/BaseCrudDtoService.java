package it.plansoft.auth.service.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.service */

import it.plansoft.auth.mapper.IMapper;
import it.plansoft.auth.model.BaseId;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BaseCrudDtoService
        <
                REPOSITORY extends JpaRepository<MODEL, ID>,
                MAPPER extends IMapper<DTO, MODEL>,
                DTO extends BaseId<ID>,
                MODEL extends BaseId<ID>,
                ID> implements ICrudDtoService<DTO, ID
        > {

    protected REPOSITORY repository;
    protected MAPPER mapper;

    public BaseCrudDtoService(REPOSITORY repository, MAPPER mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> findAll() {
        List<MODEL> models = repository.findAll();
        return this.convertModelsToDtos(models);
    }

    @Override
    public Page<DTO> findAll(Pageable page) {
        Page<MODEL> models = repository.findAll(page);

        return this.convertPagetoDtos(models);
    }


    @Override
    public DTO findById(ID id) {
        return this.convertModelToDto(repository.findById(id));
    }

    @Override
    public DTO save(DTO dto) {
        MODEL model = this.mapper.dtoToModel(dto);

        MODEL m = repository.save(model);

        return convertModelToDto(m);
    }

    @Override
    public List<DTO> saveAll(List<DTO> dtos) {
        List<DTO> mout = new ArrayList<>();
        for (DTO dto : dtos) {
            MODEL mm = repository.save(this.mapper.dtoToModel(dto));
            mout.add(this.convertModelToDto(mm));
        }
        return mout;
    }

    @Override
    public void delete(DTO dto) {
        deleteById(dto.getId());
    }

    @Override
    public void deleteById(ID id) {
        // read
        Optional<MODEL> m = repository.findById(id);
        if (m == null) {
            throw new RuntimeException(String.format("Entity with id %s not found", id));
        }

        repository.delete(m.get());
    }

    @Override
    public DTO update(DTO dto) {
        // read
        MODEL min = this.mapper.dtoToModel(dto);
        Optional<MODEL> m = repository.findById(min.getId());
        if (m == null)
            throw new RuntimeException(String.format("Entity with id %s not found", min.getId()));

        MODEL mm = repository.save(m.get());

        return this.mapper.toDto(mm);
    }

    private List<DTO> convertModelsToDtos(List<MODEL> models) {
        List<DTO> dtoToBeReturned = new ArrayList<>();

        models.forEach(model -> {
                    dtoToBeReturned.add(this.convertModelToDto(model));
                }
        );

        return dtoToBeReturned;
    }

    private DTO convertModelToDto(MODEL model) {
        return this.mapper.toDto(model);
    }

    private DTO convertModelToDto(Optional<MODEL> model) {
        if (model != null && model.get() != null)
            return this.mapper.toDto(model.get());

        Optional<DTO> dto = Optional.empty();

        return dto.get();
    }


    private Page<DTO> convertPagetoDtos(Page<MODEL> models) {

        List<Page<DTO>> dtoToBeReturned = new ArrayList<>();
        Page<DTO> p = new PageImpl(models.getContent(), models.getPageable(), models.getTotalPages());

        return p;
    }
}
