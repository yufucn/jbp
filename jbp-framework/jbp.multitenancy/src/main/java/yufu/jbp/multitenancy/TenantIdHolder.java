package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public class TenantIdHolder {
    private static final ThreadLocal<String> tenantIdThreadLocal = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        tenantIdThreadLocal.set(tenantId);
    }

    public static String getTenantId() {
        return tenantIdThreadLocal.get();
    }
}
