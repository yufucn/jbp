package jbp.ddd.application.services;

/**
 * @author wang
 */
public interface ICreateAppService<TDto, TCreate>
        extends IApplicationService {
    TDto create(TCreate input);
}
