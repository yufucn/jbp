package jbp.ddd.application.services;

import org.springframework.data.domain.Page;

/**
 * @author wang
 */
public interface IReadOnlyAppService<TKey, TDto, TListDto, TQuery>
        extends IApplicationService {
    TDto get(TKey id);

    Page<TListDto> pagedList(TQuery input);
}
