package feign.clients;


import feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Datetime: 2024/8/4下午2:00
 * @author: Camellia.xioahua
 */
@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    User finById(@PathVariable("id") Long id);
}
