package yufu.jbp.data;

/**
 * @author wang
 */
public class DataFilterScope implements AutoCloseable {
    private final Class<?> filterClass;

    public DataFilterScope(Class<?> filterClass) {
        this.filterClass = filterClass;
        DataFilter.disable(filterClass);
    }

    @Override
    public void close() {
        DataFilter.enable(filterClass);
    }
}
