package cloud.com.cloud.simple.application.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import org.springframework.http.MediaType;

import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
//@EnableWebMvc
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        //registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        //registry.addResourceHandler("/statics/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/staticss/");
        super.addResourceHandlers(registry);
    }
    
    /**
     * 请求返回页面格式配置
     * @return
     
    @Bean 
    public InternalResourceViewResolver viewResolver(){
    	InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
	    viewResolver.setPrefix("/");
	    viewResolver.setSuffix(".jsp");
	    viewResolver.setViewClass(JstlView.class);
	    return viewResolver;
    }
   */
    
    /**
     * 配置JSON
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
       FastJsonConfig config=new FastJsonConfig();  
       config.setSerializerFeatures(SerializerFeature.PrettyFormat);  
       //配置日期类型    
       config.setDateFormat("yyyy/MM/dd HH:mm:ss");  
       //解决中文乱码   
       List<MediaType> fastMediaTypes = new ArrayList<MediaType>();  
       fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);  
       fastConverter.setSupportedMediaTypes(fastMediaTypes);  
       fastConverter.setFastJsonConfig(config);  
       HttpMessageConverter converter=fastConverter;  
       
       return new HttpMessageConverters(converter); 

    }
    
 
}