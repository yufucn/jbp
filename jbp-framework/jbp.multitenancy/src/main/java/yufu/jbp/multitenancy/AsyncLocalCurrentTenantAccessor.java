package yufu.jbp.multitenancy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author wang
 */
@Service
@Scope("singleton")
public class AsyncLocalCurrentTenantAccessor implements ICurrentTenantAccessor {

    private static final ThreadLocal<BasicTenantInfo> threadLocal = new ThreadLocal<>();

    @Override
    public BasicTenantInfo getCurrent() {
        return threadLocal.get();
    }

    @Override
    public void setCurrent(BasicTenantInfo current) {
        threadLocal.set(current);
    }
}
