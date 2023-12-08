package jbp.mapping;

import org.mapstruct.MapperConfig;

/**
 * @author wang
 */
@MapperConfig
public interface ISimpleMapper<
        TEntity,
        TEntityDto> extends IDetailCreateMapper<
        TEntity,
        TEntityDto,
        TEntityDto> {
}
