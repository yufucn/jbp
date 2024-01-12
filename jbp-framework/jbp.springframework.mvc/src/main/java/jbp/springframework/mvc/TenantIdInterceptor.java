package jbp.springframework.mvc;

//import yufu.jbp.multitenancy.TenantIdHolder;
//
///**
// * @author wang
// * @date 2024/1/12 23:10
// */
//public class TenantIdInterceptor implements HandlerInterceptor {
//    private static final String TENANT_ID_HEADER = "Tenant-Id";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 在请求处理前获取TenantId
//        String tenantId = request.getHeader(TENANT_ID_HEADER);
//
//
//        TenantIdHolder.setTenantId(tenantId);
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 在请求处理后清除TenantId
//        TenantIdHolder.clearTenantId();
//    }
//}
