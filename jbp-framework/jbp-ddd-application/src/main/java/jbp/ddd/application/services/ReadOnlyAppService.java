package jbp.ddd.application.services;

import jbp.ddd.application.query.PagedAndSortedQuery;
import jbp.ddd.application.query.PagedQuery;
import jbp.mapping.IMapper;
import jbp.mapping.ISimpleMapper;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import yufu.jbp.domain.repositories.IRepository;

import javax.persistence.EntityNotFoundException;

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
