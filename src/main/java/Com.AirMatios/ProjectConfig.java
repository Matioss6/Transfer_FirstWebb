package Com.AirMatios;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "Com.AirMatios")
public class ProjectConfig {
}
