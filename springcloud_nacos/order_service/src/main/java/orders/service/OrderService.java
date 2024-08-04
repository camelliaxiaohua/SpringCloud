package orders.service;

import lombok.extern.slf4j.Slf4j;
import orders.mapper.OrderMapper;
import orders.pojo.Order;
import orders.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;


/**
 * 订单服务类，用于处理订单相关的业务逻辑。
 */
@Service // 标记这是一个 Spring 服务组件，自动将其注册为 Spring Bean
@Slf4j
public class OrderService {

    @Autowired
    private OrderMapper orderMapper; // 注入 OrderMapper，用于执行与订单相关的数据库操作

    @Autowired
    private RestTemplate restTemplate; // 注入 RestTemplate，用于发起 HTTP 请求

    /**
     * 根据订单 ID 查询订单及其关联的用户信息。
     *
     * @param orderId 订单 ID
     * @return 包含用户信息的订单
     */
    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId); // 使用 OrderMapper 从数据库中查询订单信息

        // 2. 利用 RestTemplate 发起 HTTP 请求，查询用户
        // 2.1. 构造 URL 路径
        String url = "http://user-service/user/" + order.getUserId(); // 构造访问用户服务的 URL
        log.info("Request URL: " + url);// 打印请求的 URL 以便调试
        // 2.2. 发送 HTTP 请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class); // 发起 GET 请求并将响应转换为 User 对象

        // 3. 封装 User 到 Order
        order.setUser(user); // 将查询到的 User 信息设置到 Order 对象中

        // 4. 返回
        return order; // 返回包含用户信息的订单对象
    }
}
