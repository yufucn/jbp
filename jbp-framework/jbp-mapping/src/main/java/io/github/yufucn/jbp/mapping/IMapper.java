package io.github.yufucn.jbp.mapping;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author wang
 */
@MapperConfig
public interface IMapper<
        TEntity,
        TDto,
        TListDto,
        TCreate,
        TUpdate> {
    TDto toDto(TEntity entity);


    TListDto toListDto(TEntity entity);

    TEntity toEntity(TCreate create);

    void merge(TUpdate update, @MappingTarget TEntity entity);
}