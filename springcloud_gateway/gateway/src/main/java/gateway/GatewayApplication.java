package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * gateway.GatewayApplication 是应用程序的入口类，负责启动 Spring Boot 应用。
 *
 * @Datetime: 2024/8/4 下午7:51
 * @Author: Camellia.xiaohua
 */
@SpringBootApplication // @SpringBootApplication 注解是一个组合注解，包含 @Configuration、@EnableAutoConfiguration 和 @ComponentScan
public class GatewayApplication {

    /**
     * main 方法是应用程序的入口点，使用 SpringApplication.run() 方法启动 Spring Boot 应用。
     *
     * @param args 命令行参数，可以在启动应用时传递
     */
    public static void main(String[] args) {
        // SpringApplication.run() 方法启动应用程序
        SpringApplication.run(GatewayApplication.class, args);
    }
}
