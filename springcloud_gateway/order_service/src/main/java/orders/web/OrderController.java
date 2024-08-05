package orders.web;

import feign.pojo.Order;
import jakarta.servlet.http.HttpServletRequest;
import orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId,@RequestHeader(value = "Header",required = false) String Header) {
        System.out.println("Header  "+Header);
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }
}
