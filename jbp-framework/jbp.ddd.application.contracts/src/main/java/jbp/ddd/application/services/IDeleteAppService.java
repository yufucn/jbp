package jbp.ddd.application.services;

/**
 * @author wang
 */
public interface IDeleteAppService<TKey> extends IApplicationService {
    void delete(TKey id);
}
