package users;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import users.pojo.PatternProperties;

/**
 * Spring Boot 应用程序入口类。
 *
 * 该类负责启动 Spring Boot 应用，并配置 MyBatis 的 Mapper 扫描路径。
 */
@SpringBootApplication // 标记这是一个 Spring Boot 应用程序，启用自动配置和组件扫描
@MapperScan("users.mapper") // 扫描指定包中的 MyBatis Mapper 接口，自动将它们注册为 Spring Beans
@EnableConfigurationProperties(PatternProperties.class) // 启用对指定配置属性类（PatternProperties）的支持
public class UserServiceApplication {

    /**
     * 应用程序入口点，启动 Spring Boot 应用程序。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args); // 启动 Spring Boot 应用程序
    }
}
