package gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 授权过滤器，用于在网关层进行请求的授权检查
 * @Datetime: 2024/8/5下午8:33
 * 作者: Camellia.xioahua
 */
// @Order(-1) // 如果需要指定过滤器的优先级，取消注释此行。值越小，优先级越高。
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    /**
     * 过滤器的核心方法，用于处理请求过滤逻辑
     * @param exchange 包含了请求和响应的上下文信息
     * @param chain 用于传递请求到下一个过滤器
     * @return 表示异步完成的Mono对象
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求对象
        ServerHttpRequest request = exchange.getRequest();

        // 2. 获取请求参数
        MultiValueMap<String, String> params = request.getQueryParams();

        // 3. 获取请求参数中的 "authorization" 参数值
        String auth = params.getFirst("authorization");

        // 4. 判断 "authorization" 参数是否为 "admin"
        if ("admin".equals(auth)) {
            // 4.1 如果参数为 "admin"，则放行请求
            return chain.filter(exchange);
        }

        // 5. 如果参数不是 "admin"，则拦截请求
        // 5.1 设置HTTP状态码为401 Unauthorized
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        // 5.2 拦截请求，终止请求链
        return exchange.getResponse().setComplete();
    }

    /**
     * 指定过滤器的顺序
     * @return 过滤器的优先级，值越小优先级越高
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
