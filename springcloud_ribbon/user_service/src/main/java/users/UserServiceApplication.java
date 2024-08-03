package users;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot 应用程序入口类。
 *
 * 该类负责启动 Spring Boot 应用，并配置 MyBatis 的 Mapper 扫描路径。
 */
@SpringBootApplication // 标记这是一个 Spring Boot 应用程序，启用自动配置和组件扫描
@MapperScan("users.mapper") // 扫描指定包中的 MyBatis Mapper 接口，自动将它们注册为 Spring Beans
public class UserServiceApplication {

    /**
     * 应用程序入口点，启动 Spring Boot 应用程序。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args); // 启动 Spring Boot 应用程序
    }

    /**
     * <p>配置 Ribbon 的负载均衡策略为随机策略。</p>
     * <b>通过定义一个新的IRule实现的服务是全局服务，只要是在order-service中调用的微服务都使用修改后的负载均衡规则。</b>
     * @return 配置好的 IRule 实例
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule(); // 创建并返回一个 RandomRule 实例
    }

}
