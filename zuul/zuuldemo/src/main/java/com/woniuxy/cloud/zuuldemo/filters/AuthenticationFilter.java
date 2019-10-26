package com.woniuxy.cloud.zuuldemo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


public class AuthenticationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        if(uri.endsWith(".html")||uri.endsWith(".json")){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if(!"abc123".equals(token)){

            ctx.setSendZuulResponse(false);  //阻止请求
            //返回401,未授权
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //返回消息
            ctx.getResponse().setHeader("Content-Type","text/plain;charset=utf-8");
            ctx.setResponseBody("ERROR:鉴权失败");
        }
        return null;
    }
}
