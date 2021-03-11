package it.plansoft.auth.mapper;/* ggrosso created on 07/03/2021 inside the package - it.plansoft.publication.mapper */

import java.util.List;
import java.util.Set;

public interface IMapper<DTO, MODEL> {

    DTO toDto(MODEL model);
    MODEL dtoToModel(DTO dto);
    List<DTO> toDtos(List<MODEL> models);
    List<MODEL> toModels(List<DTO> dtos);
    Set<DTO> toSetDtos(Set<MODEL> model);
}
