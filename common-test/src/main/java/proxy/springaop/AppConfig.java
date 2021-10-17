package proxy.springaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "proxy.springaop")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {

}
