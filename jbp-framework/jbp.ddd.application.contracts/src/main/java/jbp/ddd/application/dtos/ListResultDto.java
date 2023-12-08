package jbp.ddd.application.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author wang
 */
@Getter
@Setter
@ToString
public class ListResultDto<T> {
    private List<T> items;
}
