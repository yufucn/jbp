package yufu.jbp.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wang
 */

public class DataFilter {
    private static final ThreadLocal<Map<Class<?>, Boolean>> dataFilterStatus = ThreadLocal.withInitial(HashMap::new);

    public static void disable(Class<?> filterClass) {
        dataFilterStatus.get().put(filterClass, Boolean.FALSE);
    }

    public static void enable(Class<?> filterClass) {
        dataFilterStatus.get().put(filterClass, Boolean.TRUE);
    }

    public static boolean isEnabled(Class<?> filterClass) {
        return dataFilterStatus.get().getOrDefault(filterClass, Boolean.TRUE);
    }

    public static void clear() {
        dataFilterStatus.remove();
    }
}
