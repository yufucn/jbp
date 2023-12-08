package jbp.ddd.application.services;

import jbp.ddd.application.dtos.PagedResultDto;
import jbp.ddd.application.query.PagedAndSortedQuery;
import jbp.ddd.application.query.PagedQuery;
import jbp.mapping.IMapper;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import yufu.jbp.domain.repositories.IRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.MappedSuperclass;

/**
 * @author wang
 */
@MappedSuperclass
public abstract class CrudAppService<
        TEntity,
        TKey,
        TDto,
        TListDto,
        TQuery,
        TCreate,
        TUpdate>
        implements ICrudAppService<TKey, TDto, TListDto, TQuery, TCreate, TUpdate> {

    private final IRepository<TEntity, TKey> repository;
    private final IMapper<TEntity, TDto, TListDto, TCreate, TUpdate> mapper;

    public CrudAppService(IRepository<TEntity, TKey> repository,
                          IMapper<TEntity, TDto, TListDto, TCreate, TUpdate> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TDto get(TKey id) {
        TEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity " + id + " not found"));
        return mapper.toDto(entity);
    }

    @Override
    public void delete(TKey id) {
        repository.deleteById(id);
    }

    @Override
    public TDto create(TCreate create) {
        var entity = mapper.toEntity(create);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public TDto update(TKey id, TUpdate update) {
        var entity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity " + id + " not found"));
        mapper.merge(update, entity);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Page<TListDto> pagedList(TQuery query) {
        var filteredQuery = createFilteredQuery(query);
        Pageable pageable = applyPaging(query);
        return repository.findAll(filteredQuery, pageable).map(this::toListDto);
    }

    public abstract Specification<TEntity> createFilteredQuery(TQuery query);

    protected Pageable applyPaging(TQuery query) {
        Integer page = 0;
        Integer size = 10;
        Sort sort = null;
        if (query instanceof PagedQuery) {
            var dto = (PagedQuery) query;
            page = dto.getPageIndex();
            size = dto.getPageSize();
        }
        if (query instanceof PagedAndSortedQuery) {
            var dto = (PagedAndSortedQuery) query;
            sort = dto.buildSort();
        }
        if (sort == null) {
            sort = Sort.by(Sort.Direction.DESC, "id");
        }
        return PageRequest.of(page, size, sort);
    }

    private TListDto toListDto(TEntity entity) {
        return mapper.toListDto(entity);
    }
}
