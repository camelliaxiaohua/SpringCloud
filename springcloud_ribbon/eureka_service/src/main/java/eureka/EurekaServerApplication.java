package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Boot 应用的入口类，用于启动 Eureka 服务器。
 *
 * @SpringBootApplication 是 Spring Boot 应用的核心注解，它是 @Configuration、@EnableAutoConfiguration 和 @ComponentScan 的组合注解。
 *
 * @EnableEurekaServer 注解启用 Eureka 服务器功能，使这个应用成为一个 Eureka 服务注册中心。
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    /**
     * 应用程序的入口方法，启动 Spring Boot 应用程序。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 启动 Spring Boot 应用程序
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
