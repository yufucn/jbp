package yufu.jbp.data;

/**
 * @author wang
 */
public class DataFilterScope implements AutoCloseable {
    private Class<?>[] filterClasses;

    public DataFilterScope(Class<?>... filterClasses) {
        this.filterClasses = filterClasses;
        for (Class<?> filterClass :filterClasses) {
            DataFilter.disable(filterClass);
        }
    }

    @Override
    public void close() {
        for (Class<?> filterClass :filterClasses) {
            DataFilter.enable(filterClass);
        }
    }
}
