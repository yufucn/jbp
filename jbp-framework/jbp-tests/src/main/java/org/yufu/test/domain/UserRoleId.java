package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * @author wang
 */
@Getter
@Setter
@Embeddable
public class UserRoleId implements Serializable {
    private Long userId;
    private Long roleId;

}
