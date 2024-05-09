package io.github.yufucn.jbp.ddd.application.services;

import io.github.yufucn.jbp.mapping.ISimpleMapper;
import io.github.yufucn.jbp.domain.repositories.IRepository;

/**
 * @author wang
 */
public abstract class ReadOnlyAppService<TEntity, TKey, TDto, TListDto, TQuery>
        implements IReadOnlyAppService<TKey, TDto, TListDto, TQuery> {


    private final IRepository<TEntity, TKey> repository;
    private final ISimpleMapper<TEntity, TDto> mapper;

    public ReadOnlyAppService(IRepository<TEntity, TKey> repository,
                              ISimpleMapper<TEntity, TDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
