package jbp.mapping;

import org.mapstruct.MapperConfig;

/**
 * @author wang
 */
@MapperConfig
public interface IDetailMapper<
        TEntity,
        TEntityDto,
        TCreate,
        TUpdate> extends IMapper<
        TEntity,
        TEntityDto,
        TEntityDto,
        TCreate,
        TUpdate> {
}
