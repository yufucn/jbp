package jbp.springframework.mvc;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import yufu.jbp.multitenancy.TenantContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wang
 */
public class TenantIdInterceptor implements HandlerInterceptor {
    private static final String TENANT_ID_HEADER = "X-TENANT-ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理前获取TenantId
        String tenantId = request.getHeader(TENANT_ID_HEADER);


        TenantContext.setCurrentTenant(tenantId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理后清除TenantId
        TenantContext.clear();
    }
}
