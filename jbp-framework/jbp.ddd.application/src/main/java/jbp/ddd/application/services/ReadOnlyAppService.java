package jbp.ddd.application.services;

/**
 * @author wang
 */
public abstract class ReadOnlyAppService<TEntity, TKey, TDto, TListDto, TQuery>
        implements IReadOnlyAppService<TKey, TDto, TListDto, TQuery> {
}
