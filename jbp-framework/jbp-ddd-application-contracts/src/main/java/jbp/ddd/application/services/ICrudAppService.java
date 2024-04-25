package jbp.ddd.application.services;

/**
 * @author wang
 */
public interface ICrudAppService<TKey, TDto, TListDto, TQuery, TCreate, TUpdate>
        extends
        IReadOnlyAppService<TKey, TDto, TListDto, TQuery>,
        ICreateUpdateAppService<TKey, TDto, TCreate, TUpdate>,
        IDeleteAppService<TKey> {
}

