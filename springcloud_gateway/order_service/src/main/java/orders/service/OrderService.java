package orders.service;

import feign.clients.UserClient;
import feign.pojo.Order;
import feign.pojo.User;
import lombok.extern.slf4j.Slf4j;
import feign.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 订单服务类，用于处理订单相关的业务逻辑。
 */
@Service // 标记这是一个 Spring 服务组件，自动将其注册为 Spring Bean
@Slf4j
public class OrderService {

    @Autowired
    private OrderMapper orderMapper; // 注入 OrderMapper，用于执行与订单相关的数据库操作

    @Autowired
    private UserClient userClient;

    /**
     * 根据订单 ID 查询订单及其关联的用户信息。
     *
     * @param orderId 订单 ID
     * @return 包含用户信息的订单
     */
    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId); // 使用 OrderMapper 从数据库中查询订单信息
        // 2. 使用feign远程调用
        User user = userClient.finById(order.getUserId());
        // 3. 封装 User 到 Order
        order.setUser(user); // 将查询到的 User 信息设置到 Order 对象中
        // 4. 返回
        return order; // 返回包含用户信息的订单对象
    }
}
