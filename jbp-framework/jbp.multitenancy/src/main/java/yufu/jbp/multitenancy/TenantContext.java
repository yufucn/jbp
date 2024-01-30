package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }

    public static String getCurrentTenant() {
        String current = currentTenant.get();
        if (null == current) {
            return "default";
        }
        return current;
    }

    public static void clear() {
        currentTenant.remove();
    }
}
