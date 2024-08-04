package users.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 用于加载和管理配置文件中的 "pattern" 前缀的配置属性。
 *
 * 这个类会将配置文件中以 "pattern" 前缀的属性映射到该类的属性中。
 */
@Component // 将此类标记为 Spring 组件，使其可以被 Spring 托管和自动装配
@Data // 自动生成 getter 和 setter 方法，以及 toString、equals 和 hashCode 方法
@ConfigurationProperties(prefix = "pattern") // 将配置文件中以 "pattern" 前缀的属性注入到该类的属性中
public class PatternProperties {

    private String dateformat; // 配置属性，表示日期格式的配置项
}
