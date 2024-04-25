package yufu.jbp.data.domain;

/**
 * @author wang
 */
public interface SoftDeletable {
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
}
