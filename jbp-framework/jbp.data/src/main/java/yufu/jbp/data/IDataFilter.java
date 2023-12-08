package yufu.jbp.data;

import java.io.Closeable;

/**
 * @author wang
 */
public interface IDataFilter extends AutoCloseable {
    IDataFilter enable(Class<?> domainClass);

    IDataFilter disable(Class<?> domainClass);

    Boolean enabled(Class<?> domainClass);
}

