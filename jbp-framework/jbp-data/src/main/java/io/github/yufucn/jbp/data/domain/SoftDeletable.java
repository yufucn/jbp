package io.github.yufucn.jbp.data.domain;

/**
 * @author wang
 */
public interface SoftDeletable {
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
}
