package orders.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Datetime: 2024/8/4下午2:29
 * @author: Camellia.xioahua
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.FULL;
    }
}
