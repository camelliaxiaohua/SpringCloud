package orders.clients;

import orders.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 客户端接口，用于与用户服务进行通信。
 * 通过声明的接口方法调用，Feign 会自动为你生成实现类，简化 HTTP 请求的操作。
 *
 * @FeignClient 注解标记这个接口是一个 Feign 客户端，
 * 它会自动根据指定的服务名 ("user-service") 查找服务实例。
 *
 * @Datetime: 2024/8/4 下午2:00
 * @Author: Camellia.xioahua
 */
@FeignClient("user-service")
public interface UserClient {

    /**
     * 通过用户 ID 查找用户信息。
     * 使用 @GetMapping 注解标记为 HTTP GET 请求，
     * 并通过路径参数传递用户 ID。
     *
     * @param id 用户的唯一标识符。
     * @return 返回一个 User 对象，包含用户的详细信息。
     */
    @GetMapping("/user/{id}")
    User finById(@PathVariable("id") Long id);
}
