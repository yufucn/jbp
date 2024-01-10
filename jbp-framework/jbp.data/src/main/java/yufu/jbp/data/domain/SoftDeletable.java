package yufu.jbp.data.domain;

/**
 * @author wang
 * @date 2024/1/10 23:05
 */
public interface SoftDeletable {
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
}
