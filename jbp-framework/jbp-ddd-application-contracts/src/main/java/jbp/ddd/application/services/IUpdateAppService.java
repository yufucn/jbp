package jbp.ddd.application.services;

/**
 * @author wang
 */
public interface IUpdateAppService<TKey, TDto, TUpdate> {
    TDto update(TKey id, TUpdate input);
}

