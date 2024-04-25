package jbp.ddd.application.services;

/**
 * @author wang
 */
public interface ICreateUpdateAppService<TKey, TDto, TCreateUpdate, TUpdate>
        extends ICreateAppService<TDto, TCreateUpdate>,
        IUpdateAppService<TKey, TDto, TUpdate> {
}
