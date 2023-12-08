package jbp.ddd.application.dtos;

/**
 * @author wang
 */
public interface IEntityDto<TKey> {
    TKey getId();

    void setId(TKey id);
}
