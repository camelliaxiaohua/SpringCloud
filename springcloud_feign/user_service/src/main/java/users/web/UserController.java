package users.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.pojo.PatternProperties;
import users.pojo.User;
import users.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 用户控制器类，处理与用户相关的 HTTP 请求。
 *
 * 该类包含两个主要的 API 端点：
 * 1. 根据用户 ID 查询用户信息
 * 2. 获取当前时间
 */
@Slf4j // 提供 SLF4J 日志记录功能
@RestController // 标记这是一个控制器类，自动将返回的对象转换为 JSON 响应
@RequestMapping("/user") // 指定控制器处理的请求路径前缀
public class UserController {

    @Autowired
    private UserService userService; // 注入 UserService 用于业务逻辑处理

    @Autowired
    private PatternProperties patternProperties; // 注入 PatternProperties 用于读取配置属性

    /**
     * 根据用户 ID 查询用户信息。
     *
     * @param id 用户 ID
     * @return 用户对象，包含用户的详细信息
     */
    @GetMapping("/{id}") // 映射 GET 请求到 /user/{id} 路径
    public User queryById(@PathVariable("id") Long id) {
        log.info("《被调用了》"); // 记录日志，表明该方法被调用
        return userService.queryById(id); // 调用 UserService 查询用户信息
    }

    /**
     * 获取当前时间，按照配置的日期格式返回。
     *
     * @return 当前时间的字符串表示，格式取决于配置属性中的 dateformat 值
     */
    @GetMapping("now") // 映射 GET 请求到 /user/now 路径
    public String now() {
        String dateFormat = patternProperties.getDateformat(); // 从配置属性中获取日期格式
        if (dateFormat == null || dateFormat.isEmpty()) { // 如果配置的日期格式为空，则使用默认格式
            dateFormat = "yyyy-MM-dd HH:mm:ss"; // 默认日期格式
        }
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat)); // 获取当前时间并格式化为指定格式
    }
}
