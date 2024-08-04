package orders;

import orders.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot 应用程序入口类。
 *
 * 该类负责启动 Spring Boot 应用，并配置 MyBatis 的 Mapper 扫描路径以及负载均衡的 RestTemplate。
 */
@SpringBootApplication // 标记这是一个 Spring Boot 应用程序，启用自动配置和组件扫描
@MapperScan("orders.mapper") // 扫描指定包中的 MyBatis Mapper 接口，自动将它们注册为 Spring Beans
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderServiceApplication {

    /**
     * 应用程序入口点，启动 Spring Boot 应用程序。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args); // 启动 Spring Boot 应用程序
    }

    /**
     * 配置负载均衡的 RestTemplate Bean。
     *
     * @return 配置好的 RestTemplate 实例
     */
    @Bean
    @LoadBalanced // 为 RestTemplate 配置 Ribbon 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate(); // 创建并返回一个 RestTemplate 实例
    }



}
