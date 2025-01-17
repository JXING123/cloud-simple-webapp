package cloud.com.cloud.simple.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

/**
 * 服务启动类
 * @author 钟鑫
 * @version 1.0
 * 使用jsp必须继承SpringBootServletInitializer类
 */
@Controller
@SpringBootApplication
public class Application  extends SpringBootServletInitializer{
 
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
        return application.sources(Application.class);  
    }
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
 
}