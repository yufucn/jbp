package jbp.mapping;

import org.mapstruct.MapperConfig;

/**
 * @author wang
 */
@MapperConfig
public interface IDetailCreateMapper<
        TEntity,
        TEntityDto,
        TCreate> extends IDetailMapper<
        TEntity,
        TEntityDto,
        TCreate,
        TCreate> {

}
